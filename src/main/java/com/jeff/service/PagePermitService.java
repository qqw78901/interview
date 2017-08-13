package com.jeff.service;

import java.util.List;

import com.jeff.po.PagePermit;

public interface PagePermitService extends BaseService<PagePermit, String> {
	public List<PagePermit> getMenuInId(List<Integer> ids);
	
}
