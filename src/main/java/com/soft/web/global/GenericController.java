package com.soft.web.global;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class GenericController {
	/** 로거 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="config")
	protected Properties config;
	
	@Autowired
	private MessageSource messageSource;
	
	
	/*
	//-- 상단메뉴
	@ModelAttribute("globalAdminTopMenuList")
	protected List<Map<String, Object>> globalAdminTopMenuList() throws Exception {
		Map<String, Object> admin = this.getSessionAdminMap();
		if(admin != null && !admin.isEmpty() ){	
			Map<String, Object> sqlMap = new HashMap<String, Object>();	
			sqlMap.put("adminUid",admin.get("ADMIN_UID"));
			return adminAuthService.selectAdminAuthListTopMenu(sqlMap);
		}
		else{
			return null;
		}
	}
	
	//-- 왼쪽메뉴
	@ModelAttribute("globalAdminLeftMenuList")
	protected List<Map<String, Object>> globalAdminLeftMenuList() throws Exception {
		Map<String, Object> admin = this.getSessionAdminMap();
		if(admin != null && !admin.isEmpty() ){
			Map<String, Object> sqlMap = new HashMap<String, Object>();
			sqlMap.put("adminUid",admin.get("ADMIN_UID"));
			return adminAuthService.selectAdminAuthListLeftMenu(sqlMap);
		}
		else{
			return null;
		}
	}
	*/

	protected String getMessage(String messageId,  String[] args) {
		return messageSource.getMessage(messageId, args, Locale.getDefault());
	}

	protected Result getResult(boolean isSuccess, String messageId,  String[] args) {
		Result result = new Result();

		String mesg = this.getMessage(messageId, args);
		if ( StringUtils.isBlank(mesg) ) {
			mesg = isSuccess ? "처리하였습니다." : "처리되지 않았습니다.";
		}

		result.setSuccess(isSuccess);
		result.setMessage(mesg);
		return result;
	}


	/**
	 * HTTP세션 객체를 구하여 반환
	 * 
	 * @return	HTTP세션 객체
	 */
	protected HttpSession getSession() {
		HttpSession session;

		try {
			ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			session = sra.getRequest().getSession();
		}
		catch (IllegalStateException e) {
			logger.error("<오류> 세션 조회 : (원인) " + e.getMessage());
			session = null;
		}
		return session;
	}
	
	/**
	 * 세션에 저장된 사용자맵 정보를 반환한다. 없으면 null 반환
	 * 
	 * @return	세션에 저장된 사용자맵
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> getSessionUserMap() {
		Map<String, Object> sessionUserMap;

		try {
			
			ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = sra.getRequest().getSession();
			sessionUserMap = null==session ? null : (Map<String, Object>) session.getAttribute(CommonConf.session.SESSION_KEY_USER);
		}
		catch (IllegalStateException e) {
			logger.error("<오류> 세션 정보 조회 : (원인) " + e.getMessage());
			sessionUserMap = null;
		}

		return sessionUserMap;
	}

	/**
	 * 세션에 저장된 사용자맵에서 지정된 key의 값을 문자열로 반환한다. 없으면 null 반환
	 * 
	 * @param 	key	세션사용자맵에서 지정된 key 값(문자열)
	 * @return	세션에 저장된 사용자맵에서 지정된 key의 값
	 */
	protected String getSessionAttr(String key) {
		Map<String, Object> sessionUserMap = this.getSessionUserMap();
		
		String val = null==sessionUserMap ? null : (String)sessionUserMap.get(key);
		logger.debug("<콘트롤러#세션조회> key : '{}', 세션값 = '{}'", key, val);

		return val;
	}
	
	/**
	 * 세션에 저장된 사용자맵 정보를 반환한다. 없으면 null 반환
	 * 
	 * @return	세션에 저장된 사용자맵
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> getSessionAdminMap() {
		Map<String, Object> sessionAdminMap;

		try {
			
			ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = sra.getRequest().getSession();
			sessionAdminMap = null==session ? null : (Map<String, Object>) session.getAttribute(CommonConf.session.SESSION_KEY_ADMIN);
		}
		catch (IllegalStateException e) {
			logger.error("<오류> 관리자세션 정보 조회 : (원인) " + e.getMessage());
			sessionAdminMap = null;
		}

		return sessionAdminMap;
	}

	/**
	 * 세션에 저장된 사용자맵에서 지정된 key의 값을 문자열로 반환한다. 없으면 null 반환
	 * 
	 * @param 	key	세션사용자맵에서 지정된 key 값(문자열)
	 * @return	세션에 저장된 사용자맵에서 지정된 key의 값
	 */
	protected String getSessionAdminAttr(String key) {
		Map<String, Object> sessionAdminMap = this.getSessionAdminMap();
		
		String val = null==sessionAdminMap ? null : (String)sessionAdminMap.get(key);
		logger.debug("<콘트롤러#관리자세션조회> key : '{}', 세션값 = '{}'", key, val);

		return val;
	}
}
