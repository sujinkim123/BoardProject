package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.vo.BoardVo;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class BoardService {

	@Autowired
	com.example.demo.mapper.BoardMapper boardMapper;

	public List<com.example.demo.model.vo.BoardVo> getAlllist() {
		return boardMapper.getAlllist();
	}
	
	public List<BoardVo> getBoardDetail(int boardId) {
		return boardMapper.getBoardDetail(boardId);
	}

	public void post(com.example.demo.model.dto.BoardDto postRequest) {
		boardMapper.post(postRequest);
	}

	public void modify(com.example.demo.model.dto.BoardDto modifyRequest) {
		boardMapper.modify(modifyRequest);
	}

	public void delete(Long boardId) {
		// TODO 게시글 작성자 매칭 확인 필요?
		boardMapper.delete(boardId);
	}

}
