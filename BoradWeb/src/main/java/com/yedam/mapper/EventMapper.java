package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.EventVo;

public interface EventMapper {

	List<EventMapper> selectEvent();
	int insertEvent(EventVo vo);
	int deleteEvent(EventVo vo);
}
