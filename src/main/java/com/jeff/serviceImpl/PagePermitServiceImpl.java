package com.jeff.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.PagePermitMapper;
import com.jeff.po.PagePermit;
import com.jeff.service.PagePermitService;

@Service
public class PagePermitServiceImpl extends BaseServiceImpl<PagePermit, String>
		implements PagePermitService {

	@Autowired
	private PagePermitMapper pagePermitMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(pagePermitMapper);
	}

	@Override
	public List<PagePermit> getMenuInId(List<Integer> ids) {
		// TODO Auto-generated method stub
		return pagePermitMapper.getMenuInId(ids);
	}

}
