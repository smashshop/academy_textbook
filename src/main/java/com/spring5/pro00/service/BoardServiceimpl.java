package com.spring5.pro00.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring5.pro00.common.paging.PagingDTO;
import com.spring5.pro00.domain.BoardVO;
import com.spring5.pro00.mapper.BoardDAO;
import com.spring5.pro00.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
//public class BoardServiceimpl implements BoardService{
public class BoardServiceimpl implements BoardService{
	
	private BoardMapper bm;
	//private BoardDAO bm;

	@Autowired
	public void setBm(BoardMapper bm) {
		this.bm = bm;
	}
	
	@Override
	public long getBoardCnt(PagingDTO pagingDTO) {
		return bm.selectBoardCnt(pagingDTO);
	}
	
	//페이징 기능 추가
	@Override
	public List<BoardVO> getBoardList(PagingDTO pagingDTO){
		return bm.selectBoardList(pagingDTO);
	}
	
//	@Override
//	public List<BoardVO> getBoardList(){
//		return bm.selectBoardList();
//	}
	
	@Override
	public long registerBoard(BoardVO boardVO) {
		bm.insertBoard(boardVO);
		return boardVO.getBno();
	}
	@Override
	public BoardVO getBoard(long bno) {
		bm.updateBviewCnt(bno);
		return bm.selectBoard(bno);
	}
	
	@Override
	public BoardVO getBoardDetailModify(long bno) {
		return bm.selectBoard(bno);
	}
	
	@Override
	public boolean setBoardDeleted(long bno) {
		return (bm.updateBdelFlag(bno) == 1);
	}
	@Override
	public boolean removeBoard(long bno) {
		return (bm.deleteBoard(bno) == 1);
	}
	@Override
	public boolean modifyBoard(BoardVO boardVO) {
		return (bm.updateBoard(boardVO) == 1);
	}
	
}
