package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BoardDto {

	private Long boardId;

	private Long categoryId;

	private String title;

	private String contents;

	private String writer;

	private LocalDateTime createdAt  = LocalDateTime.now();

	private LocalDateTime updatedAt;

}
