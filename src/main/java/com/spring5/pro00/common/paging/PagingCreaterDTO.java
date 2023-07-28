package com.spring5.pro00.common.paging;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagingCreaterDTO {
	
	private PagingDTO pag;
	
	private int startPagingNum;
	private int endPagingNum;
	private boolean prev;
	private boolean next;
	private long boardCnt;
	private int pagingNumCnt;
	private int lastPageNum;
	
	public PagingCreaterDTO(long boardCnt, PagingDTO pag) {
		this.pag = pag;
		this.boardCnt = boardCnt;
		this.pagingNumCnt = 10;
		this.endPagingNum = (int)Math.ceil( (pag.getPageNum()) / (pagingNumCnt * 1.0) ) * pagingNumCnt;
		this.startPagingNum = this.endPagingNum - (this.pagingNumCnt-1);
		this.lastPageNum = (int)Math.ceil( this.boardCnt / (pag.getRowCntPerPage() * 1.0) );
		if(this.lastPageNum < this.endPagingNum) {
			this.endPagingNum = this.lastPageNum;
		}
		this.prev = this.startPagingNum > 10;
		this.next = this.endPagingNum != this.lastPageNum;
		
		System.out.println("전달된 페이징 기본데이터 : " + pag.toString());
		System.out.println("끝 페이징번호: " + this.endPagingNum);
		System.out.println("시작 페이징번호: " + this.startPagingNum);
		System.out.println("이전버튼 표시 여부: " + this.prev);
		System.out.println("다음버튼 표시 여부: " + this.next);
		System.out.println("마지막 페이지 번호: " + this.lastPageNum);
	}
	
}
