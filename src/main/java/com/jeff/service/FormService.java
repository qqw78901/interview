package com.jeff.service;

import com.jeff.mybatis.page.Page;
import com.jeff.po.Form;
import com.jeff.vo.FormShowVo;
import com.jeff.vo.FormVo;

public interface FormService extends BaseService<Form, String> {
	public FormShowVo show(Form form);
	public Page<FormVo> getByPage(Form form);
    public int remove(String id);
}
