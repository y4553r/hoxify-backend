package com.hoxify.hoxify.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hoxify.hoxify.error.ApiError;
import com.hoxify.hoxify.shared.GenericResponse;
import com.hoxify.hoxify.user.vm.UserVM;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	GenericResponse createUser(@Valid @RequestBody User user) {
		userService.save(user);
		return new GenericResponse("User saved");
	}
	
	@GetMapping("/users")
	Page<UserVM> getUsers() {
		return userService.getUsers().map(UserVM::new);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ApiError handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request) {
		ApiError apiError = new ApiError(400, "Validation Error", request.getServletPath());
		BindingResult result = exception.getBindingResult();
		Map<String, String> validationErrors = new HashMap<>();
		for(FieldError fieldError: result.getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		apiError.setValidationErrors(validationErrors);
		return apiError;
	}
	
}
