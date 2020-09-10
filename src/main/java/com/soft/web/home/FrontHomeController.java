package com.soft.web.home;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.web.global.GenericController;

@Controller
public class FrontHomeController extends GenericController {
	

	@RequestMapping(value = {"/index"})
    public String index(@RequestParam Map<String, Object> param, ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		
 		return "/index";
    }
	
}
