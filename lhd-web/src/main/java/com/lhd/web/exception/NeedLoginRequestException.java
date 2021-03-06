package com.lhd.web.exception;

import com.lhd.core.util.AjaxJson;
import com.lhd.core.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lihongde on 2016/11/25 12:10
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "The request you send to Server was failed")
public class NeedLoginRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private AjaxJson result;

	public NeedLoginRequestException(String message) {
		super(message);
		this.result = new AjaxJson();
		this.result.setCode(Constants.HttpStatus.NEED_LOGIN);
		this.result.setMessage(message);
	}

	public AjaxJson getResult() {
		return result;
	}

	public void setResult(AjaxJson result) {
		this.result = result;
	}
}
