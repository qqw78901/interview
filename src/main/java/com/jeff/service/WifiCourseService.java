package com.jeff.service;



import java.util.List;

import com.jeff.po.WifiCourse;

public interface WifiCourseService extends BaseService<WifiCourse, String> {
	public List<WifiCourse> check(WifiCourse wifiCourse);
	public int closeWifi(WifiCourse wifiCourse);
	public int count(WifiCourse wifiCourse);
	public WifiCourse findCourse (WifiCourse wifiCourse);

	
}
