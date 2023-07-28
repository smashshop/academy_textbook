package com.spring5.pro00.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring5.pro00.domain.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시물 전체 조회
	public List<BoardVO> selectBoardList(){
		List<BoardVO> boardList = sqlSession.selectList("BoardMapperDAO.selectBoardList");
//		sqlSession.commit();
//		sqlSession.close();	context 파일의 세션 관련 스프링 클래스를 주입해주었기 때문에 자동으로 해줌
		return boardList;
	}
	
	public int insertBoard(BoardVO boardVO) {
		return sqlSession.insert("BoardMapperDAO.insertBoard", boardVO);
	}
}
