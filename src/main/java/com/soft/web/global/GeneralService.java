package com.soft.web.global;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {
	
	@Autowired
	private MessageSource messageSource;

	public GeneralService() {
    }

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
}
