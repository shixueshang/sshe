package com.lhd.web.exception;

import com.lhd.core.util.AjaxJson;
import com.lhd.core.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lihongde on 2016/11/25 12:10
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The request you send to server is not found")
public class NotFoundRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private AjaxJson result;

	public NotFoundRequestException(String message) {
		super(message);
		this.result = new AjaxJson();
		this.result.setCode(Constants.HttpStatus.NOT_FOUND);
		this.result.setMessage(message);
	}

	public AjaxJson getResult() {
		return result;
	}

	public void setResult(AjaxJson result) {
		this.result = result;
	}
}
