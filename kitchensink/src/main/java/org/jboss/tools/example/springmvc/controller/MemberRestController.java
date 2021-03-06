package org.jboss.tools.example.springmvc.controller;

import java.util.List;

import org.jboss.tools.example.springmvc.data.MemberDao;
import org.jboss.tools.example.springmvc.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/rest/members")
public class MemberRestController {
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Member> listAllMembers() {
		return memberDao.findAllOrderedByName();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Member lookupMemberById(@PathVariable("id") Long id) {
		return memberDao.findById(id);
	}
}
