package com.excellenceict.eprescription.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.excellenceict.eprescription.dto.ErrorResponseDto;
import com.excellenceict.eprescription.dto.Response;


public final class ResponseBuilder {
	private ResponseBuilder() {};
	
	private static List<ErrorResponseDto> getCustomeError(BindingResult result){
		List<ErrorResponseDto> errorList = new ArrayList<ErrorResponseDto>();
		result.getFieldErrors().forEach(fieldError->{
			ErrorResponseDto dto = ErrorResponseDto.builder()
					.field(fieldError.getField())
					.massage(fieldError.getDefaultMessage()).build();
			errorList.add(dto);
		});
		return errorList;
	}
		
	
	public static Response getFailorResponse(BindingResult result, String massage) {
		return Response.builder()
				.massage(massage)
				.errors(getCustomeError(result))
				.status(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.timestamp(new Date().getTime()).build();
	}

	public static Response getFailorResponse(HttpStatus status, String massage) {
		return Response.builder()
				.massage(massage)
				.status(status.getReasonPhrase())
				.statusCode(status.value())
				.timestamp(new Date().getTime()).build();
				
	}



	public static Response getSuccessResponse(HttpStatus status, String massage, Object content) {
		return Response.builder()
				.massage(massage)
				.status(status.getReasonPhrase())
				.content(content)
				.statusCode(status.value())
				.timestamp(new Date().getTime()).build();			
	}
	
	public static Response getSuccessResponse(HttpStatus status, String massage, Object content,int numberOfElement) {
		return Response.builder()
				.massage(massage)
				.status(status.getReasonPhrase())
				.content(content)
				.numberOfElement(numberOfElement)
				.statusCode(status.value())
				.timestamp(new Date().getTime()).build();			
	}

	
	public static Response getSuccessResponse(HttpStatus status, String massage, Object content,int numberOfElement,long rowCount) {
		return Response.builder()
				 .massage(massage)
				.status(status.getReasonPhrase())
				.content(content)
				.numberOfElement(numberOfElement)
				.statusCode(status.value())
				.rowCount(rowCount)
				.timestamp(new Date().getTime()).build();			
	} 
}
