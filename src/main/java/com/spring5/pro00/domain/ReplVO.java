package com.spring5.pro00.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplVO {
	
	private long bno;
	private long rno;
	private String rcontent;
	private String rwriter;
	private Timestamp rregDate;
	private Timestamp rmodDate;
	private long prno;
	private int lvl;
	
}
