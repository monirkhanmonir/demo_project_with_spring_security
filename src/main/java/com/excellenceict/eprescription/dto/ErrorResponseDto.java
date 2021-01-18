package com.excellenceict.eprescription.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String field;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String massage;
}
