package com.spring5.pro00.mapper02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring5.pro00.common.paging.PagingDTO;
import com.spring5.pro00.domain.BoardVO;
import com.spring5.pro00.mapper.BoardMapper;
import com.spring5.pro00.mapper.BoardDAO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/mybatis-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class MyBoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
//	@Setter(onMethod_ = @Autowired)
//	private BoardDAO boardDAO;
	
	//페이징 기능 검색기능 추가
	@Test
	public void testSearchBoardWithPaging() {
	 PagingDTO pagingDTO = new PagingDTO(1, 10); //기본 생성자 이용(1, 10)
	 pagingDTO.setKeyword("5");
	 
	 //pagingDTO.setScope("T");
	 //pagingDTO.setScope("C");
	 //pagingDTO.setScope("W");
	 //pagingDTO.setScope("TC");
	 pagingDTO.setScope("TCW");
	 //pagingDTO.setScope("TW");
	 //pagingDTO.setScope("CW");
	 log.info("행 총 개수: " + boardMapper.selectBoardCnt(pagingDTO));
	 
	 List<BoardVO> list = boardMapper.selectBoardList(pagingDTO);
	 list.forEach(board -> log.info(board));
	}
	
//모든 리스트 조회
//	@Test
//	public void testSelectBoardList() {
//		boardMapper.selectBoardList().forEach(board -> log.info(board));
//	}
	
//테이블에 데이터 삽입 방법1
//	@Test
//	public void testInsertBoard1() {
//		BoardVO boardVO = new BoardVO(0, "인서트 매퍼 테스트-제목1", "인서트 매퍼 테스트-내용1", "test1", 0, 0, 0, null, null);
//		log.info("\n" + boardMapper.insertBoardList1(boardVO) + " 행이 삽입되었습니다");
//		
//		log.info("\n전달된 BoardVO : " + boardVO);
//	}

//테이블에 데이터 삽입 방법2
//	@Test
//	public void testInsertBoard2() {
//		BoardVO boardVO = new BoardVO(0, "인서트 매퍼 테스트-제목2", "인서트 매퍼 테스트-내용2", "test2", 0, 0, 0, null, null);
//		log.info("\n" + boardMapper.insertBoardList2(boardVO) + " 행이 삽입되었습니다");
//		
//		log.info("\n" + "전달된 BoardVO : " + boardVO);
//	}
	
//특정 리스트 조회
//	@Test
//	public void testSelectBoard() {
//		log.info("\n" + "전달받은 데이터 : " + boardMapper.selectBoard(1));
//	}
	
//게시물 삭제여부
//	@Test
//	public void testUpdateBdelFlag() {
//		log.info("\n" + boardMapper.updateBdelFlag(1) + " 행이 수정되었습니다\n수정된 데이터 : " + boardMapper.selectBoard(1));
//	}
	
//관리자가 게시물 직접 삭제
//	@Test
//	public void testDeleteBoard() {
//		log.info("\n" + boardMapper.deleteBoard(1) + " 행이 삭제되었습니다");
//	}

//특정 데이터 수정
//	@Test
//	public void testUpdateBoard() {
//		BoardVO boardVO = new BoardVO(2, "업데이트 매퍼 테스트-제목2", "업데이트 매퍼 테스트-내용2", null, 0, 0, 0, null, null);
//		log.info("\n" + boardMapper.updateBoard(boardVO) + " 행이 수정되었습니다.\n수정된 데이터 : " + boardMapper.selectBoard(2));
//	}
	
//게시물의 조회수 증가
//	@Test
//	public void testUpdateBviewCnt() {
//		log.info("\n" + boardMapper.updateBviewCnt(2) + "행이 수정되었습니다.\n수정된 데이터 : " + boardMapper.selectBoard(2));
//	}
	
	
	
	
//MapperDAO사용 테스트	
	
//	@Test
//	public void testSelectBoardList() {
//		boardDAO.selectBoardList().forEach(board -> log.info(board));
//	}
	
//	@Test
//	public void testInsertBoard() {
//		BoardVO boardVO = new BoardVO(0, "인서트 매퍼 테스트-제목3", "인서트 매퍼 테스트-내용3", "test3", 0, 0, 0, null, null);
//		log.info("\n" + boardDAO.insertBoard(boardVO) + " 행이 삽입되었습니다");
//		
//		log.info("\n" + "전달된 BoardVO : " + boardVO);
//	}
}
