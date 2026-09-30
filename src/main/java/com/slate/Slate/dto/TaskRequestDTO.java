package com.slate.Slate.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TaskRequestDTO {
	private String title;
	private String description;
	private boolean completed;
}
