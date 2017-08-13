package com.jeff.util;

import java.util.HashMap;

import com.jeff.mybatis.page.Page;

/**
 * 
 * @author jeff he
 *
 */
@SuppressWarnings("serial")
public class ResultMap extends HashMap<String, Object> {

	public ResultMap() {

	}

	public ResultMap success() {
		this.put("success", true);
		return this;
	}

	public ResultMap fail() {
		this.put("success", false);
		return this;
	}

	public ResultMap info(String info) {
		this.put("info", info);
		return this;
	}

	public ResultMap msg(String msg) {
		this.put("message", msg);
		return this;
	}

	public ResultMap data(Object obj) {
		this.put("data", obj);
		return this;
	}

	public ResultMap page(Page<?> page) {
		this.put("rows", page.getRows());
		this.put("total", page.getTotal());
		return this;
	}

}
