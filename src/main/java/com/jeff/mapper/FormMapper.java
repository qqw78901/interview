package com.jeff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeff.po.Form;
import com.jeff.vo.FormShowVo;
import com.jeff.vo.FormVo;

@Repository
public interface FormMapper extends BaseMapper<Form, String> {
	FormShowVo show(Form form);
	List<FormVo> getByPage(Form form);
    int remove(String id);
}
