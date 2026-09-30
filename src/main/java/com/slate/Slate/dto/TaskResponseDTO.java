package com.slate.Slate.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {
	private Long id;
	private String title;
	private String description;
	private boolean completed;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
