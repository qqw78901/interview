package com.jeff.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.WifiCourseMapper;
import com.jeff.po.WifiCourse;
import com.jeff.service.WifiCourseService;


@Service
public class WifiCourseServiceImpl extends BaseServiceImpl<WifiCourse, String>implements WifiCourseService {

	@Autowired
	private WifiCourseMapper WifiCourseMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(WifiCourseMapper);
	}

	@Override
	public List<WifiCourse> check(WifiCourse wifiCourse) {
		return WifiCourseMapper.check(wifiCourse);
	}

	@Override
	public int closeWifi(WifiCourse wifiCourse) {
		return WifiCourseMapper.closewifi(wifiCourse);
	}

	@Override
	public int count(WifiCourse wifiCourse) {
		return WifiCourseMapper.count(wifiCourse);
	}

	@Override
	public WifiCourse findCourse(WifiCourse wifiCourse) {
		return WifiCourseMapper.findCourse(wifiCourse);
	}


}
