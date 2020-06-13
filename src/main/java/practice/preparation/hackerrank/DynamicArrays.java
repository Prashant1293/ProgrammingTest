package practice.preparation.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
2 5
        1 0 5
        1 1 7
        1 0 3
        2 1 0
        2 1 1*/

public class DynamicArrays {
    private static final int queryTypeIndex = 0;
    private static final int xIndex = 1;
    private static final int yIndex = 2;
    
    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        
        int lastAnswer = 0;
        List<List<Integer>> seqLists = new ArrayList();
        int seqListSize = n;
        List<Integer> result = new ArrayList();
        List<Integer> finalResult = new ArrayList();
        List<Integer> query2XYPositions = new ArrayList();
        
        IntStream.range(0, n).forEach(index -> seqLists.add(new ArrayList(seqListSize)));
        
        queries.stream().forEach(query -> {
            if (result.isEmpty()) {
                System.out.println("processQuery(query, lastAnswer, seqListSize, seqLists).join() => " + processQuery(query, lastAnswer, seqListSize, seqLists).join());
                result.add(processQuery(query, lastAnswer, seqListSize, seqLists).join());
            } else {
                System.out.println("processQuery(query, result.get(result.size() - 1), seqListSize, seqLists).join()" + processQuery(query, result.get(result.size() - 1), seqListSize, seqLists).join());
                result.add(processQuery(query, result.get(result.size() - 1), seqListSize, seqLists).join());
            }
            //return 0;
        });
        
        IntStream.range(0, queries.size()).forEach(index -> {
            if (queries.get(index).get(queryTypeIndex) == 2) {
                query2XYPositions.add(index);
            }
        });
        System.out.println("pos = " + query2XYPositions + " & result = " + result);
        /*for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i).get(queryTypeIndex) == 2) {
                query2XYPositions.add(i);
            }
        }
        */
        query2XYPositions.stream().forEach(position -> finalResult.add(result.get(position)));
        
        /*for (int i = 0; i < query2XYPositions.size(); i++) {
            int index = query2XYPositions.get(i);
            finalResult.add(result.get(index));
        }
        */
        
        return finalResult;
    }
    
    private static CompletableFuture<Integer> getSequence(int x, int lastAnswer, int n) {
        return CompletableFuture.supplyAsync(() -> (x ^ lastAnswer) % n).toCompletableFuture();
    }
    
    private static CompletableFuture<Integer> processQuery(List<Integer> query, int lastAnswer, int n,
                                                           List<List<Integer>> seqLists) {
        /*int seq = getSequence(query.get(xIndex), lastAnswer, n);
        
        if (query.get(queryTypeIndex) == 1) {
            seqLists.get(seq).add(query.get(yIndex));
        }
        
        if (query.get(queryTypeIndex) == 2) {
            int size = seqLists.get(seq).size();
            int index = query.get(yIndex) % size;
            lastAnswer = seqLists.get(seq).get(index);
        }
        return lastAnswer;
    */
        List<Integer> temp = new ArrayList<>();
        
        return getSequence(query.get(xIndex), lastAnswer, n)
                .thenApply(seq -> {
                    if (query.get(queryTypeIndex) == 1) {
                        seqLists.get(seq).add(query.get(yIndex));
                    }
                    
                    if (query.get(queryTypeIndex) == 2) {
                        int size = seqLists.get(seq).size();
                        int index = query.get(yIndex) % size;
                        //lastAnswer = seqLists.get(seq).get(index);
                        temp.add(seqLists.get(seq).get(index));
                    }
                    return temp.isEmpty() ? lastAnswer : temp.get(temp.size() - 1);
                }).toCompletableFuture();
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OutputDynamicArray"));
        
        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int n = Integer.parseInt(nq[0]);
        
        int q = Integer.parseInt(nq[1]);
        
        List<List<Integer>> queries = new ArrayList<>();
        
        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        List<Integer> result = dynamicArray(n, queries);
        System.out.println("result => " + result);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
