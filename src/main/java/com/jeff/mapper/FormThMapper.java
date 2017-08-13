package com.jeff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeff.po.FormTh;

@Repository
public interface FormThMapper extends BaseMapper<FormTh, String> {

	int batchFormTh(List<FormTh> formthes);

}
