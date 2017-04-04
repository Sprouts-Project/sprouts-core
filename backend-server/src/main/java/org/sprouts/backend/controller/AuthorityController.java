package org.sprouts.backend.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sprouts.backend.service.AuthorityService;
import org.sprouts.model.Authority;

@RestController
@Api
@RequestMapping("/authority")
public class AuthorityController extends AbstractController {

	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Authority userInfo() throws Exception {
		Authority result = authorityService.findByPrincipal();
		return result;
	}
}