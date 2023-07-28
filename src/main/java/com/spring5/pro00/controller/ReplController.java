package com.spring5.pro00.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring5.pro00.common.paging.ReplPagingCreaterDTO;
import com.spring5.pro00.common.paging.ReplPagingDTO;
import com.spring5.pro00.service.ReplService;

@RestController
@RequestMapping(value = "/replies")
public class ReplController {
	
	private ReplService replService;
	
	public ReplController(ReplService replService) {
		this.replService = replService;
	}
	
	//매핑 URL 목록
	//게시물에 대한 댓글 목록 조회: GET /replies/pages/{bno}/{page}
	@GetMapping(value = "/pages/{bno}/{page}",
				produces = {"application/json;charset=UTF-8", "application/xml;charset=UTF-8"})
	public ResponseEntity<ReplPagingCreaterDTO> showReplList(@PathVariable("bno") long bno, 
											@PathVariable("page") Integer pageNum){
		ReplPagingDTO replPagingDTO = new ReplPagingDTO(bno, pageNum);

		ReplPagingCreaterDTO replPagingCreaterDTO = replService.getReplList(replPagingDTO);
		
		ResponseEntity<ReplPagingCreaterDTO> responseEntity =
				new ResponseEntity<>(replPagingCreaterDTO, HttpStatus.OK);
		
		return responseEntity;
	}
	//게시물에 대한 댓글 등록(rno 반환): POST /replies/{bno}/new
	//게시물에 대한 댓글의 답글 등록(rno 반환): POST /replies/{bno}/{prno}/new
	//게시물에 대한 특정 댓글 조회: GET /replies/{bno}/{rno}
	//게시물에 대한 특정 댓글 수정: PUT:PATCH /replies/{bno}/{rno}
	//게시물에 대한 특정 댓글 삭제: DELETE: /replies/{bno}/{rno}
	
}
