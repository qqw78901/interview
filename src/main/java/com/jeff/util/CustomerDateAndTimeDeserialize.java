package com.jeff.util;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.expression.ParseException;

public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser paramJsonParser,
			DeserializationContext paramDeserializationContext)
			throws IOException, JsonProcessingException {
		String str = paramJsonParser.getText().trim();
		try {
			return DateUtil.smartFormat(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return paramDeserializationContext.parseDate(str);
	}
}
