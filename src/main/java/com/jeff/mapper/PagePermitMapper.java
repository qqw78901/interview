package com.jeff.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jeff.po.PagePermit;

@Repository
public interface PagePermitMapper extends BaseMapper<PagePermit, String> {
	List<PagePermit> getMenuInId(@Param("ids")List<Integer> ids);

}
