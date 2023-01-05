package com.balietek.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime>{

	private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

	@Override
	public void serialize(LocalDateTime dateTime, JsonGenerator generator, SerializerProvider sp) throws IOException {
		String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern(dateTimeFormat));
		generator.writeString(formattedDateTime);
	}
	
}