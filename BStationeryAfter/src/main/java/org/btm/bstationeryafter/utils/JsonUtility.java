package org.btm.bstationeryafter.utils;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JsonUtility {

    // Gson instance for JSON serialization/deserialization
	private static final Gson gson = new GsonBuilder()
	        .registerTypeAdapter(Date.class, new DateSerializerDeserializer())
	        .setDateFormat("dd/MM/yyyy")
	        .create();
	
    // Marshal (serialize) an object to JSON
    public static String marshal(Object object) {
        return gson.toJson(object);
    }

    // Unmarshal (deserialize) JSON to an object of the specified class
    public static <T> T unmarshal(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
    
    // Custom Date Serializer and Deserializer
    private static class DateSerializerDeserializer implements JsonSerializer<Date>, JsonDeserializer<Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            return gson.toJsonTree(dateFormat.format(date));
        }

        @Override
        public Date deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) {
            try {
                return dateFormat.parse(json.getAsString());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
