package com.soft.web.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageCommonController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass() );
	
	@RequestMapping(value = {"/{sub1}/{file}.do"})
	public String otherUrl(
			 @PathVariable("sub1") String sub1
			,@PathVariable("file") String file
			,Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
   	
		String reqUrl = request.getRequestURI().toString();
		logger.debug("============================="+reqUrl);
		return "/" + sub1 + "/" + file;
   }
	
	@RequestMapping(value = {"/{sub1}/{sub2}/{file}.do"})
	public String otherUrl2(
			 @PathVariable("sub1") String sub1
			,@PathVariable("sub2") String sub2
			,@PathVariable("file") String file
			,Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
   	
		String reqUrl = request.getRequestURI().toString();
		logger.debug("============================="+reqUrl);
		return "/" + sub1 + "/" + sub2 + "/" + file;
   }
	
	@RequestMapping(value = {"/{sub1}/{sub2}/{sub3}/{file}.do"})
	public String otherUrl3(
			 @PathVariable("sub1") String sub1
			,@PathVariable("sub2") String sub2
			,@PathVariable("sub3") String sub3			
			,@PathVariable("file") String file
			,Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
   	
		String reqUrl = request.getRequestURI().toString();
		logger.debug("============================="+reqUrl);
		return "/" + sub1 + "/" + sub2 + "/" + sub3 + "/" + file;
   }
	
}
