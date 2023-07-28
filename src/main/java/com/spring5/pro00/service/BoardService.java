package com.spring5.pro00.service;

import java.util.List;

import com.spring5.pro00.common.paging.PagingDTO;
import com.spring5.pro00.domain.BoardVO;

public interface BoardService {
	
	public long getBoardCnt(PagingDTO pagingDTO);
	
	public List<BoardVO> getBoardList(PagingDTO pagingDTO);
	
	public long registerBoard(BoardVO boardVO);
	
	public BoardVO getBoard(long bno);
	
	public BoardVO getBoardDetailModify(long bno);
	
	public boolean setBoardDeleted(long bno);
	
	public boolean removeBoard(long bno);
	
	public boolean modifyBoard(BoardVO boardVO);
	
}
