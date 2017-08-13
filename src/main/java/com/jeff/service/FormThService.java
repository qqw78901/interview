package com.jeff.service;

import java.util.List;

import com.jeff.po.FormTh;

public interface FormThService extends BaseService<FormTh, String> {
	int batchFormTh(List<FormTh> formthes);
}
