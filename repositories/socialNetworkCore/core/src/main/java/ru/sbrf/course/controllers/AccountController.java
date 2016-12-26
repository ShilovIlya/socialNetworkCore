package ru.sbrf.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sbrf.course.domain.Account;
import ru.sbrf.course.domain.UserData;
import ru.sbrf.course.services.AccountService;
import ru.sbrf.course.services.UserDataService;

@Controller
public class AccountController {
    private AccountService accountService;
    private UserDataService userDataService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setUserDataService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @RequestMapping(value = "accounts", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("accounts", accountService.listAllAccounts());
        return "accounts";
    }

    @RequestMapping("signin")
    public String signInAcc(Model model) {
        model.addAttribute("account", new Account());
        return "signin";
    }

    @RequestMapping("signup")
    public String signUp(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "signup";
    }

    @RequestMapping(value = "openaccount", method = RequestMethod.POST)
    public String signIn(Account account){
        Account acc = accountService.getAccountByLogin(account.getLogin());
        if (acc != null)
            return "redirect:/account/" + acc.getAccountId();
        else
            return "redirect:/signin";
    }

    @RequestMapping(value = "createaccount", method = RequestMethod.POST)
    public String createAccount(Account account, Model model){
        Account acc = accountService.getAccountByLogin(account.getLogin());
        if (acc != null) {
            return "signupexist";
        } else {
            UserData userData = new UserData();
            userDataService.saveUserData(userData);
            account.setUserDataId(userData.getId());
            accountService.saveAccount(account);
            userData.setAccountId(account.getAccountId());
            userDataService.saveUserData(userData);
            return "signin";
        }
    }

    @RequestMapping("account/{accountId}")
    public String showAccount(@PathVariable Long accountId, Model model){
        Account acc = accountService.getAccountById(accountId);
        UserData userData = userDataService.getUserDataById(acc.getUserDataId());
        model.addAttribute("userdata", userData);
        return "accountInfo";
    }

    @RequestMapping(value = "editdata/{id}", method = RequestMethod.POST)
    public String editUserData(@PathVariable Long id, Model model){
        UserData userData = userDataService.getUserDataById(id);
        model.addAttribute("userdata", userData);
        return "editdata";
    }

    @RequestMapping(value = "savedata/{id}", method = RequestMethod.POST)
    public String saveUserData(UserData userData){
        userDataService.saveUserData(userData);
        Account account = accountService.getAccountByUserDataId(userData.getId());
        return "redirect:/account/" + account.getAccountId();
    }
}
