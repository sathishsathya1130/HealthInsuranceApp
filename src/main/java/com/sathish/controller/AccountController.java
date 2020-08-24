package com.sathish.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sathish.model.Account;
import com.sathish.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService service;

	@GetMapping(value = { "/", "/AccountForm" })
	public String loadForm(Model model) {

		Account a = new Account();
		model.addAttribute("account", a);
   	    return "createAccount";

		/*
		 * UnlockAccount UnlockAccount = new UnlockAccount();
		 * model.addAttribute("unlockAcc", UnlockAccount); return "unlockAdminForm";
		 */
	}

	@RequestMapping(value = "/accountRegSuccess")
	public String handelCreateBtn(@ModelAttribute("account") Account account, RedirectAttributes attributes)
			throws MessagingException, IOException {
		boolean isSaved = service.saveAccount(account);

		if (isSaved) {

			attributes.addFlashAttribute("succmsg", "Account Added Sucessfully,Please check Your mail");

		} else {

			attributes.addFlashAttribute("Errmsg", "failed to  Add Account");
		}

		return "redirect:/AccountForm";
		/* return "AdminRegSuccess"; */

	}

	@GetMapping(value = "viewAccounts")
	public String handleViewContactsLink(Model model) {
		List<Account> adminList = service.getAllAccount();
		model.addAttribute("admins", adminList);
		return "viewAccounts";

	}
}
