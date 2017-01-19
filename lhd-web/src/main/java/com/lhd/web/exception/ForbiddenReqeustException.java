package com.lhd.web.exception;

import com.lhd.core.util.AjaxJson;
import com.lhd.core.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "The request you send to Server was forbidden")
public class ForbiddenReqeustException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private AjaxJson result;

	public ForbiddenReqeustException(String message) {
		super(message);
        this.result.setCode(Constants.HttpStatus.FORBIDDEN);
        this.result.setMessage(message);
	}

	public AjaxJson getResult() {
		return result;
	}

	public void setResult(AjaxJson result) {
		this.result = result;
	}
}


