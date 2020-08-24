package com.sathish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathish.model.Account;
import com.sathish.service.AccountService;

@Controller
public class ViewAccountController {

	@Autowired
	private AccountService service;

	@RequestMapping("/editAccount")
	public String editAccount(@RequestParam("id") Integer id, Model model) {
		Account a = service.getAccountById(id);
		model.addAttribute("account", a);
		model.addAttribute("msg", "Edited sucessfully");
		return "createAccount";

	}

	@RequestMapping("/deleteAccount")
	public String deleteAccount(@RequestParam("id") Integer id) {
		service.deleteAccount(id);
		return "redirect:/viewAccounts";

	}
}
