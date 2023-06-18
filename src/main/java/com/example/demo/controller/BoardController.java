package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.vo.BoardVo;

import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
public class BoardController {

	@Autowired
	com.example.demo.service.BoardService boardService;

	@GetMapping(value="/list")
	public ModelAndView getAlllist(Model model) {
		System.out.println("게시판 전체 글 조회");
		ModelAndView mv = new ModelAndView("list");
		List<BoardVo> boardList = boardService.getAlllist();
		model.addAttribute("boardList", boardList);
		return mv;
	}
	
	@GetMapping(value="/detail")
	public ModelAndView boardDetail(Model model, @RequestParam("boardId") int boardId) {
		System.out.println("boardId ; "+ boardId);
		ModelAndView mv = new ModelAndView("detail");
		List<BoardVo> detailList = boardService.getBoardDetail(boardId);
		model.addAttribute("detailList", detailList);
		return mv;
	}

	@PostMapping(value="post")
	public void post(@RequestBody com.example.demo.model.dto.BoardDto postRequest) {
		System.out.println("게시판 글 등록");
		boardService.post(postRequest);
	}

	@PostMapping(value="modify")
	public void edit(@RequestBody com.example.demo.model.dto.BoardDto modifyRequest) {
		System.out.println("게시판 글 수정");
		boardService.modify(modifyRequest);
	}

	@DeleteMapping(value="delete/{boardId}")
	public void delete(@PathVariable Long boardId) {
		System.out.println("게시글 삭제");
		boardService.delete(boardId);
	}

}
