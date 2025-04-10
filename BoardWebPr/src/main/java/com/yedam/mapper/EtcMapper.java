package com.yedam.mapper;

import java.util.List;
import java.util.Map;

public interface EtcMapper {
	List<Map<String, Object>> selectEvent();
	int insertEvent(Map<String, Object> data);
	int deleteEvent(Map<String, Object> data);
	
	// 차트를 그리기위한 쿼리를 생성
	List<Map<String, Object>> selectWriter();
	
	// 로그 정보를 만들기위한 것
	int insertLogging(Map<String, String> map);
	
	
}
