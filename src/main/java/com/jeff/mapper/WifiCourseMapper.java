package com.jeff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeff.po.WifiCourse;

@Repository
public interface WifiCourseMapper extends BaseMapper<WifiCourse, String> {

	List<WifiCourse> check(WifiCourse wifiCourse);

	int closewifi(WifiCourse wifiCourse);

	int count(WifiCourse wifiCourse);

	WifiCourse findCourse(WifiCourse wifiCourse);
	

}
