package edu.knoldus;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;

public class SampleJson {
    
    private static Logger logger = LoggerFactory.getLogger(SampleJson.class);
    private static ObjectMapper objectMapper = new ObjectMapper();
    
    public static void main(String[] args) throws Exception {
        
        callMe();
        Map<String, Object> complexMdcValue = new HashMap<>();
        Map<String, Object> childMdcValue = new HashMap<>();
        childMdcValue.put("name", "Joe");
        childMdcValue.put("type", "Martian");
        complexMdcValue.put("child", childMdcValue);
        complexMdcValue.put("category", "etc");
        logger.warn("MY Sample Json.", childMdcValue);
        MDC.put("complexNestedValue", objectMapper.writeValueAsString(complexMdcValue));
        logger.info("HOLOLOLOJO");
        
    }
    
    private static void callMe() {
        logger.info("MY Sample Json From callMe.");
    }
    
}

@Builder
@Value
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class Base {
    
    String eventType;
    
    String traceId;
    
    String userID;
    
    String feature;
    
    String timestamp;
}