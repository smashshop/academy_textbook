package com.spring5.pro00.mapper;

import java.util.List;

import com.spring5.pro00.common.paging.PagingDTO;
import com.spring5.pro00.domain.BoardVO;

public interface BoardMapper {
	//게시물 전체 조회
//	public List<BoardVO> selectBoardList();
	
	//게시물 전체 개수 조회(검색기능 추가)
	public long selectBoardCnt(PagingDTO pagingDTO);
	
	//게시물 조회(페이징 기능 추가)
	public List<BoardVO> selectBoardList(PagingDTO pagingDTO);
	
	//게시물 추가 방법1
//	public int insertBoard1(BoardVO boardVO);
	
	//게시물 추가 방법2
	public int insertBoard(BoardVO boardVO);
	
	//특정 게시물 조회
	public BoardVO selectBoard(long bno);
	
	//유저가 게시물 삭제
	public int updateBdelFlag(long bno);
	
	//관리자가 특정 게시물 삭제
	public int deleteBoard(long bno);
	
	//게시물 수정
	public int updateBoard(BoardVO boardVO);
	
	//게시물 조회수 증가
	public int updateBviewCnt(long bno);
}
