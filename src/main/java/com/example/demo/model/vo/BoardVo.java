package com.example.demo.model.vo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardVo {

	private Long boardId;

	private Long categoryId;

	private String title;

	private String contents;

	private String writer;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

}
