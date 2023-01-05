package com.balietek.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LodalDateTimeDeserializer extends JsonDeserializer<LocalDateTime>{

    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        String value = jsonParser.getValueAsString();
        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern(dateTimeFormat));
    }
    
}