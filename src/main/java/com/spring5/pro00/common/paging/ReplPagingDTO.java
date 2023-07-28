package com.spring5.pro00.common.paging;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ReplPagingDTO {
	
	private long bno;
	private Integer pageNum;
	private int rowCntPerPage;
	
	public ReplPagingDTO(long bno, Integer pageNum) {
		this.bno = bno;
		if(pageNum == null) {
			this.pageNum = 1;
		}else{
			this.pageNum = pageNum;
		}
		this.rowCntPerPage = 10;
	}
	
}
