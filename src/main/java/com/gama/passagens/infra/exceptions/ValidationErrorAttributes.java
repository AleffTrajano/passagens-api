package com.gama.passagens.infra.exceptions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

@Component
public class ValidationErrorAttributes extends DefaultErrorAttributes {
 
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
    	Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
    	
    	if (!options.isIncluded(Include.BINDING_ERRORS)) {
    		return errorAttributes;
    	}
    	
    	Throwable error = this.getError(webRequest);
    	
    	if (error instanceof MethodArgumentNotValidException) {
    		 List<String> errors = getValidationErrors((MethodArgumentNotValidException)error);
    		 
    		 errorAttributes.put("errors", errors);
    	}
    	
		return errorAttributes;
    }

	private List<String> getValidationErrors(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getAllErrors().stream()
			.map(objectError -> {
		        String fieldName = ((FieldError) objectError).getField();
		        String errorMessage = objectError.getDefaultMessage();
		        return "Campo '" + fieldName + "' " + errorMessage;
		    })
			.collect(Collectors.toList());
		
		return errors;
	}
    
}
