package com.jeff.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.FormThMapper;

import com.jeff.po.FormTh;
import com.jeff.service.FormThService;


@Service
public class FormThServiceImpl extends BaseServiceImpl<FormTh, String>implements FormThService {

	@Autowired
	private FormThMapper formThMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(formThMapper);
	}
	@Override
	public int batchFormTh(List<FormTh> formthes) {
		// TODO Auto-generated method stub
		return formThMapper.batchFormTh(formthes);
	}


}
