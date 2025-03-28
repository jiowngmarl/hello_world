package com.yedam.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok 설치 & 라이브러리 다운로드
@Getter
@Setter
@ToString
public class BoardVo {

	private int boardNo; 
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
}
