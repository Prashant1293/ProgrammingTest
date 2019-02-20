package edu.knoldus.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    
    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = queries;
        List<List<Integer>> seqListFinal = new ArrayList<>();
        IntStream.range(0, n)
                .mapToObj(index-> seqListFinal.add(new ArrayList<>()));
        int lastAnswer = 0;
        List<Integer>lastAnswers=new ArrayList<>();
        lastAnswers.add(lastAnswer);
        final int x = 1;
        final int y = 2;
        final int queryType = 0;
        seqList.forEach(seq -> {
            if (seq.get(queryType) == 1) {
                int seqNum = (seq.get(x) ^ lastAnswers.get(lastAnswers.size()-1)) % 2;
                if (seqListFinal.isEmpty()) {
                    seqListFinal.add(seqNum, Arrays.asList(seq.get(y)));
                } else {
                    if (seqListFinal.size() - 1 < seqNum) {
                        seqListFinal.add(seqNum, Arrays.asList(seq.get(y)));
                    } else {
                        int sizeOfInternalList = seqListFinal.get(seqNum).size();
                        System.out.println("sizeOfInternalList======" + sizeOfInternalList);
                        List<Integer> internalList = seqListFinal.get(seqNum);
                        List<Integer> newList = internalList.stream().collect(Collectors.toList());
                        newList.add(seq.get(y));
                        seqListFinal.set(seqNum, newList);
                        //System.out.println("internalList======" + internalList);
                        
                        //internalList.add(sizeOfInternalList-0,seq.get(y));
                        //seqListFinal.add(seqNum, internalList);
                    }
                }
                System.out.println(" SeqListFinal = " + seqListFinal);
                
                //array[seqNum][] = seq.get(y);
            } else if (seq.get(queryType) == 2) {
                int seqNum = (seq.get(x) ^ lastAnswers.get(lastAnswers.size()-1)) % 2;
                int size = seqListFinal.get(seqNum).size();
                lastAnswers.add(seqListFinal.get(seqNum).get(seq.get(y)%size));
                System.out.println(lastAnswers.get(lastAnswers.size()-1));
            }
        });
        return new ArrayList<>(5);
        
    }
    
    public static void main(String[] args) throws IOException {
        
        List<List<Integer>> queries = new ArrayList<>();
        
        queries.add(Arrays.asList(1, 0, 5));
        queries.add(Arrays.asList(1, 1, 7));
        queries.add(Arrays.asList(1, 0, 3));
        queries.add(Arrays.asList(2, 1, 0));
        queries.add(Arrays.asList(2, 1, 1));
        System.out.println(queries);
        dynamicArray(2, queries);
        
    }
}
