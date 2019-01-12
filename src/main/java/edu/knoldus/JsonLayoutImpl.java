package edu.knoldus;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Builder
@AllArgsConstructor
@Setter
public class JsonLayoutImpl extends JsonLayout {
    public static final String TIMESTAMP_ATTR_NAME = "myTimestamp";
    
    @Override
    protected Map toJsonMap(ILoggingEvent event) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        addTimestamp(TIMESTAMP_ATTR_NAME, true, event.getTimeStamp(), map);
        addCustomDataToJsonMap(map, event);
        return map;
    }
    
    @Override
    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
        Map<String, Base> myMap = new HashMap<>();
        myMap.put("Base", Base.builder().eventType("Error").timestamp(String.valueOf(map.get(TIMESTAMP_ATTR_NAME))).build());
        addMap("Base", true, myMap, map);
        
        //super.addCustomDataToJsonMap(map, event);
    }
    
    public Map generateBaseStructure(ILoggingEvent event, Map<?, ?> map) {
        Map<?, ?> payload = new LinkedHashMap<>();
        Set<?> keySet = map.keySet();
        return map;
        
    }
}
