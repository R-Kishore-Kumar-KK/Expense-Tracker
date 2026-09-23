package com.fintrack.expenseservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ExpenseNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleExpenseNotFound(ExpenseNotFoundException ex) {

		Map<String, Object> response = new HashMap<>();

		response.put("timestamp", LocalDateTime.now());
		response.put("status", HttpStatus.NOT_FOUND.value());
		response.put("error", "Expense Not Found");
		response.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {

		Map<String, Object> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		Map<String, Object> response = new HashMap<>();

		response.put("timestamp", LocalDateTime.now());
		response.put("status", HttpStatus.BAD_REQUEST.value());
		response.put("error", "Validation Failed");
		response.put("messages", errors);

		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {

		Map<String, Object> response = new HashMap<>();

		response.put("timestamp", LocalDateTime.now());
		response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.put("error", "Internal Server Error");
		response.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
