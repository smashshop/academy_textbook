package com.spring5.pro00.service3;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring5.pro00.common.paging.PagingDTO;
import com.spring5.pro00.domain.BoardVO;
import com.spring5.pro00.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/mybatis-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService boardService;
	
//	@Test
//	public void testBoardServiceExist() {
//		log.info(boardService);
//		assertNotNull(boardService); //널값일 경우 강제로 오류를 냄
//	}
	
	//페이징 기능 추가
	@Test
	public void testGetBoardList() {
		boardService.getBoardList(new PagingDTO(2, 20)).forEach(board -> log.info(board));
	}
	
//	@Test
//	public void testGetBoardList() {
//		boardService.getBoardList().forEach(board -> log.info(board));
//	}
	
//	@Test
//	public void testRegisterBoard() {
//		BoardVO boardVO = new BoardVO(0, "서비스 새글 입력 테스트-제목1", "서비스 새글 입력 테스트-내용1", "test1", 0, 0, 0, null, null);
//		log.info("\n등록된 글의 번호 : " + boardService.registerBoard(boardVO));
//	}
	
//	@Test
//	public void testGetBoard() {
//		log.info("\n가져온 데이터 : " + boardService.getBoard(2));
//	}
	
//	@Test
//	public void testSetBoardDeleted() {
//		log.info("\n데이터 삭제요청 : " + (boardService.setBoardDeleted(2)? "성공" : "실패") );
//	}

//	@Test
//	public void testRemoveBoard() {
//		log.info("\n데이터 삭제 : " + (boardService.removeBoard(1)? "성공" : "실패") );
//	}

//	@Test
//	public void testModifyBoard() {
//		BoardVO boardVO = new BoardVO(2, "업데이트 매퍼 테스트-제목2", "업데이트 매퍼 테스트-내용2", null, 0, 0, 0, null, null);
//		log.info("\n데이터 수정 : " + boardService.modifyBoard(boardVO) + "\n수정된 데이터 : " + boardService.getBoard(2));
//	}
	
}
