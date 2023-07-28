package com.spring5.pro00.controller04;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spring5.pro00.common.paging.PagingDTO;
import com.spring5.pro00.domain.BoardVO;
import com.spring5.pro00.mapper.BoardMapper;
import com.spring5.pro00.service.BoardServiceimpl;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", 
					   "file:src/main/webapp/WEB-INF/spring/mybatis-context.xml"})
@Log4j
public class BoardControllerTests {
	
	//서버없이 컨트롤러를 테스트 하기위해 웹 애플리케이션컨텍스트를 주입받아야 한다
	
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	//테스트 환경구성 끝
	
//	@Test//페이징 기능 추가 테스트
//	public void testShowBoardList() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list").param("pageNum", "1").param("rowCntPerPage", "10"))
//						.andReturn().getModelAndView().getModelMap());
//	}
	
//	@Test
//	public void testShowBoardList() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//						.andReturn().getModelAndView().getModelMap());
//	}
	
//	@Test
//	public void testShowBoardRegisterPage() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/register"))
//					.andReturn().getModelAndView().getModelMap()
//				);
//	}

//	@Test
//	public void testRegisterNewBoard() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//									.param("btitle", "컨트롤러 게시물 등록 테스트 - 제목")
//									.param("bcontent", "컨트롤러 게시물 등록 테스트 - 내용")
//									.param("bwriter", "test")
//								)
//					.andReturn().getModelAndView().getModelMap()
//				);
//	}
	
//	@Test
//	public void testShowBoardDetail() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/detail")
//									.param("bno", "2")
//								)
//					.andReturn().getModelAndView().getModelMap()
//				);
//	}

//	@Test
//	public void testModifyBoard() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//									.param("bno", "2")
//									.param("btitle", "컨트롤러 게시물 수정 테스트 - 제목")
//									.param("bcontent", "컨트롤러 게시물 수정 테스트 - 내용")
//								)
//					.andReturn().getModelAndView().getModelMap()
//				);
//	}
	
//	@Test
//	public void testModifyBoard() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
//									.param("bno", "10")
//								)
//					.andReturn().getModelAndView().getModelMap()
//				);
//	}
	
}
