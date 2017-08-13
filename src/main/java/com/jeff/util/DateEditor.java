package com.jeff.util;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport {

	SimpleDateFormat format;

	public DateEditor(SimpleDateFormat format) {
		this.format = format;
	}

	public String getAsText() {
		Date value = (Date) getValue();
		if (null == value) {
			value = new Date();
		}
		SimpleDateFormat df = format;
		return df.format(value);
	}

	public void setAsText(String text) throws IllegalArgumentException {
		Date value = null;
		if (null != text && !text.equals("")) {
			SimpleDateFormat df = format;
			try {
				value = df.parse(text);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		setValue(value);
	}
}