package com.adstore.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String getStatus() {
		return "API is running ...";
	}
}
