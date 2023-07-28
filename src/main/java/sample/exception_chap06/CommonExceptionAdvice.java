package sample.exception_chap06;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
//@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex, Model model) {
		System.out.println("Exception 발생 : " + ex.getMessage());
		model.addAttribute("exception", ex);
		System.out.println("전달되는 model : " + model);
		
		return "sample2/exception/error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String exception404(NoHandlerFoundException ex) {
		return "sample2/exception/error_page_404";
	}
	
}
