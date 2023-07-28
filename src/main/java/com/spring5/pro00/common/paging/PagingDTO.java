package com.spring5.pro00.common.paging;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class PagingDTO {
	
	private int pageNum;
	private int rowCntPerPage;
	private String scope;
	private String keyword;
	
	public PagingDTO() {
		//현재 페이지
		this.pageNum = 1;
		//페이지마다 표시할 개수
		this.rowCntPerPage = 10;
	}
	
	public PagingDTO(int pageNum) {
		if(pageNum <= 0) {
			this.pageNum = 1;
		}else{
			this.pageNum = pageNum;
		}
	}
	
	public PagingDTO(int pageNum, int rowCntPerPage) {
		if(pageNum <= 0) {
			this.pageNum = 1;
		}else{
			this.pageNum = pageNum;
		}
		
		if(rowCntPerPage <= 0) {
			this.rowCntPerPage = 10;
		}else{
			this.rowCntPerPage = rowCntPerPage;
		}
	}
	
	public PagingDTO(String pageNum, String rowCntPerPage) {
		int p = Integer.parseInt(pageNum);
		int r = Integer.parseInt(rowCntPerPage);
		if(p <= 0) {
			this.pageNum = 1;
		}else{
			this.pageNum = p;
		}
		
		if(r <= 0) {
			this.rowCntPerPage = 10;
		}else{
			this.rowCntPerPage = r;
		}
	}
	
	public String[] getScopeArray() {
		return scope == null ? new String[] {} : scope.split("");
	}
	
	public String addPagingParamsToURI() {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromPath("")
															  .queryParam("pageNum", this.pageNum)
															  .queryParam("rowCntPerPage", this.rowCntPerPage)
															  .queryParam("scope", this.scope)
															  .queryParam("keyword", this.keyword);
		String uriStr = uriBuilder.toUriString();
		System.out.println("생성된 URI 문자열 : " + uriStr);
		return uriStr;
	}
}
