package com.spring5.pro00.mapper02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring5.pro00.common.paging.ReplPagingDTO;
import com.spring5.pro00.domain.ReplVO;
import com.spring5.pro00.mapper.ReplMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/mybatis-context.xml")
@Log4j
public class ReplMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private ReplMapper replMapper;
	
//	@Test
//	public void testMapper() {
//		System.out.println("주입된 맵퍼 객체 : " + replMapper);
//	}
	
//	@Test
//	public void testSelectReplList() {
//		List<ReplVO> replList = replMapper.selectReplList(458756);
//		replList.forEach(replLi -> System.out.println(replLi));
//	}
	
	//페이징 기능 추가
	@Test
	public void testSelectReplList() {
//		List<ReplVO> replList = replMapper.selectReplList(new ReplPagingDTO(458756, 1));
//		replList.forEach(replLi -> System.out.println(replLi));
		
		System.out.println("총 댓글 개수 : " + replMapper.selectReplTotCnt(new ReplPagingDTO(458756, 1)));
		replMapper.selectReplList(new ReplPagingDTO(458756, 1))
				  .forEach(replLi -> System.out.println(replLi));
	}
	
}
