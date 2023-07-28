package com.spring5.pro00.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring5.pro00.common.paging.ReplPagingDTO;
import com.spring5.pro00.domain.ReplVO;

public interface ReplMapper {
	
	//게시물의 댓글 목록 조회
	public List<ReplVO> selectReplList(@Param("ReplPagingDTO") ReplPagingDTO replPagingDTO);
	
	//게시물의 댓글 총 개수
	public int selectReplTotCnt(@Param("ReplPagingDTO") ReplPagingDTO replPagingDTO);
	
	//게시물에 댓글 등록
	public long insertReplForBoard(ReplVO repl);
	
	//댓글에 대한 답글 등록
	public long insertReplForRepl(ReplVO repl);
	
	//게시물의 댓글 답글 한개 선택
	public ReplVO selectRepl(@Param("bno") long bno, @Param("rno") long rno);
	
	//게시물의 댓글/답글 수정
	public int updateRepl(ReplVO repl);
	
	//게시물의 댓글/답글 삭제
	public int deleteRepl(@Param("bno") long bno, @Param("rno") long rno);
}
