package com.thzhima.location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "/")
public class UserController {

	@ResponseBody
	@RequestMapping(path="/login")
	public String login() {
		return "<html><head><style></style></head>"
				+ "<body></body>"
				+"</html>";
	}
}
