package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ReplyVo;

// 업무프로세스(service)

public interface ReplyService {

	List<ReplyVo> replyList(SearchDTO search);
	boolean addReply(ReplyVo rvo);
	boolean removeReply(int replyNo);
	ReplyVo getReply(int replyNo);
	
	// 페이징 계산
	int getTotalCnt(int boardNo);
	
	//Datatable용 데이터
	List<Map<String, Object>> replyListForDT(int boardNo);
}
