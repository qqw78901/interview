package com.jeff.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.FormMapper;
import com.jeff.mybatis.page.Page;
import com.jeff.po.Form;
import com.jeff.service.FormService;
import com.jeff.vo.FormShowVo;
import com.jeff.vo.FormVo;


@Service
public class FormServiceImpl extends BaseServiceImpl<Form, String>implements FormService {

	@Autowired
	private FormMapper formMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(formMapper);
	}

	@Override
	public FormShowVo show(Form form) {
		return formMapper.show(form);
	}

	@Override
	public Page<FormVo> getByPage(Form form) {
		return this.buildVoPage(formMapper.getByPage(form));
	}
	
	@Override
	public Page<FormVo> getPublicFormByPage(Form form) {
		return this.buildVoPage(formMapper.getPublicFormByPage(form));
	}

	@Override
	public int remove(String id) {
		return formMapper.remove(id);
	}

	@Override
	public String getIdByDomain(String domain) {
		return formMapper.getIdByDomain(domain);
	}





	

}
