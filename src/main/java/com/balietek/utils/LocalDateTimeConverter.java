package com.balietek.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime,Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		return attribute != null ? Timestamp.valueOf(attribute) : null;
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		return dbData != null ? dbData.toLocalDateTime() : null ;
	}

}

// @Converter(autoApply = true)
// public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

//   @Override
//   public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
//     return Optional.ofNullable(localDateTime)
//         .map(Timestamp::valueOf)
//         .orElse(null);
//   }

//   @Override
//   public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
//     return Optional.ofNullable(timestamp)
//         .map(Timestamp::toLocalDateTime)
//         .orElse(null);
//   }
// }