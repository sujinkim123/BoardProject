package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.vo.BoardVo;


@Mapper
@Repository
public interface BoardMapper {

	List<com.example.demo.model.vo.BoardVo> getAlllist();
	
	List<BoardVo> getBoardDetail(int boardId);

	void post(com.example.demo.model.dto.BoardDto postRequest);

	void modify(com.example.demo.model.dto.BoardDto modifyRequest);

	void delete(Long boardId);

}
