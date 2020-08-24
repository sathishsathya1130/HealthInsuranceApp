package com.sathish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathish.model.Account;
import com.sathish.model.UnlockAccount;
import com.sathish.service.AccountService;

@Controller
public class UnlockAccountController {

	@Autowired
	private AccountService service;

	@GetMapping(value = "/unlockAdminForm")
	public String displayUnlockAccForm(@RequestParam("email") String email, Model model) {
		model.addAttribute("email", email);
		UnlockAccount UnlockAccount = new UnlockAccount();
		model.addAttribute("unlockAcc", UnlockAccount);
		return "unlockAdminForm";
	}

	@PostMapping("/unlockAdminAcc")
	public String unlockUserAcc(@ModelAttribute("unlockAcc") UnlockAccount acc, Model model) {
		System.out.println(acc);

		Account admin = service.getUserAcctByTempPwd(acc.getTempPwd());

		if (admin != null) {
			return "unlockAccSucess";
		}
		model.addAttribute("errmsg", "please enter the valid password");
		return "unlockAdminForm";
	}
}
