package com.yedam.common;

import lombok.Getter;
import lombok.ToString;

// 게시글 건수를 계산하여 페이지 갯수를 지정하는 클래스

@Getter
@ToString
public class PageDTO {


	// 현제 페이지를 기준으로 시작페이지와 끝페이지
	private int startPage; // 시작페이지
	private int endPage; // 끝페이지
	private int currentPage; // 현재페이지
	private boolean prev, next; // 이전, 이후 10개 페이지가 있는지의 여부를 확인
	
	public PageDTO(int totalCnt, int page) {
		currentPage = page;
		endPage = (int) (Math.ceil(page / 10.0)) * 10;
		startPage = endPage - 9;
		int realEnd = (int) (Math.ceil(totalCnt / 5.0));
		endPage = endPage > realEnd ? realEnd : endPage; // 계산한 마지막페이지인가 실제 마지막 페이지인가
		// 이전 10개 페이지의 유무
		prev = startPage > 1 ? true : false;
		next = endPage < realEnd ? true : false;
	}
}
