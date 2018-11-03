package cn.pl.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
	/*	String message=null;
		if (ex instanceof CustomException) {
			message=((CustomException)ex).getMessage();
		}else {
			message="Î´Öª´íÎó";
		}
		return null;
	}*/
		CustomException customException=null;
		if (ex instanceof CustomException) {
			customException=(CustomException) ex;
		}else {
			customException=new CustomException("Î´Öª´íÎó");
		}
		String message=customException.getMessage();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
