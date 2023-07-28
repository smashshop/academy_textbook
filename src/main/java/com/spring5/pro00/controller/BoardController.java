package com.spring5.pro00.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring5.pro00.common.paging.PagingCreaterDTO;
import com.spring5.pro00.common.paging.PagingDTO;
import com.spring5.pro00.domain.BoardVO;
import com.spring5.pro00.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	
	private BoardService boardService;
	
	//게시물 조회(페이징 기능 추가)	/board/list
	@GetMapping("/list")
	public void showBoardList(PagingDTO pagingDTO, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(pagingDTO));
		
		long boardCnt = boardService.getBoardCnt(pagingDTO);
		PagingCreaterDTO pagingC = new PagingCreaterDTO(boardCnt, pagingDTO);
		model.addAttribute("pagingCreater", pagingC);
	}
	
	//게시물 전체 조회	/board/list
//	@GetMapping("/list")
//	public void showBoardList(Model model) {
//		model.addAttribute("boardList", boardService.getBoardList());
//	}
	
	//등록 페이지 호출	GET /Board/register
	@GetMapping("/register")
	public void showBoardRegisterPage() {
		System.out.println("등록 페이지 호출");
	}
	
	//등록 처리	POST /board/register 처리완료 후 목록정보로 이동
	@PostMapping("/register")
	public String registerNewBoard(BoardVO boardVO, RedirectAttributes ra) {
		long bno = boardService.registerBoard(boardVO);
		ra.addFlashAttribute("result", bno);
		System.out.println("등록된 게시물의 bno : " + bno);
		return "redirect:/board/list";
	}
	
	//특정 게시물 조회	GET /board/detail
	@GetMapping("/detail")
	public void showBoardDetail(@RequestParam("bno") long bno, Model model,
								@ModelAttribute("paging") PagingDTO pagingDTO) {
		model.addAttribute("board", boardService.getBoard(bno));
	}
	
	//수정 페이지 호출	GET /Board/modify
	@GetMapping("/modify")
	public void showBoardModifyPage(@RequestParam("bno") long bno, Model model,
									@ModelAttribute("paging") PagingDTO pagingDTO) {
		System.out.println("수정 페이지 호출");
		model.addAttribute("board", boardService.getBoardDetailModify(bno));
	}
	
//	//수정후 특정 게시물 조회 요청	GET /board/modify
//	@GetMapping("/modify")
//	public void showBoardModify(@RequestParam("bno") long bno, Model model) {
//		model.addAttribute("board", boardService.getBoardDetailModify(bno));
//	}
	
	//특정 게시물 수정	POST /board/modify
	@PostMapping("/modify")
	public String modifyBoard(BoardVO boardVO, RedirectAttributes ra,
							 //@ModelAttribute("paging") PagingDTO pagingDTO) { 리다이렉트 때문에 전달이 안됨
							 PagingDTO pagingDTO) {
		if(boardService.modifyBoard(boardVO)) {
			ra.addFlashAttribute("result", "modifySuccess");
		}
		ra.addAttribute("bno", boardVO.getBno());
		ra.addAttribute("pageNum", pagingDTO.getPageNum());
		ra.addAttribute("rowCntPerPage", pagingDTO.getRowCntPerPage());
		ra.addAttribute("keyword", pagingDTO.getKeyword());
		ra.addAttribute("scope", pagingDTO.getScope());
		return "redirect:/board/detailmod";
	}
	
	//수정후 특정 게시물 조회 요청	GET /board/detailmod
	@GetMapping("/detailmod")
	public String showBoardDetailMod(@RequestParam("bno") long bno, Model model,
									 @ModelAttribute("paging") PagingDTO pagingDTO) {
		model.addAttribute("board", boardService.getBoardDetailModify(bno));
		return "board/detail";
	}
	
	//게시물 삭제	POST /board/remove
	@PostMapping("/delete")
	public String setBoardDeleted(long bno, RedirectAttributes ra, PagingDTO pagingDTO) {
		if(boardService.setBoardDeleted(bno)) {
			ra.addFlashAttribute("result", "deleteSuccess");
		}
		
		return "redirect:/board/list" + pagingDTO.addPagingParamsToURI();
		
//		ra.addAttribute("pageNum", pagingDTO.getPageNum());
//		ra.addAttribute("rowCntPerPage", pagingDTO.getRowCntPerPage());
//		ra.addAttribute("keyword", pagingDTO.getKeyword());
//		ra.addAttribute("scope", pagingDTO.getScope());
//		return "redirect:/board/list";
	}
	
	//게시물 삭제	POST /board/remove
	@PostMapping("/remove")
	public String setBoardRemove(long bno, RedirectAttributes ra, PagingDTO pagingDTO) {
		if(boardService.removeBoard(bno)) {
			ra.addFlashAttribute("result", "removeSuccess");
		}
		
		return "redirect:/board/list" + pagingDTO.addPagingParamsToURI();
		
		//아래 코드를 위 코드 한줄로 줄일수 있음
//		ra.addAttribute("pageNum", pagingDTO.getPageNum());
//		ra.addAttribute("rowCntPerPage", pagingDTO.getRowCntPerPage());
//		ra.addAttribute("keyword", pagingDTO.getKeyword());
//		ra.addAttribute("scope", pagingDTO.getScope());
//		return "redirect:/board/list";
	}
	
}
