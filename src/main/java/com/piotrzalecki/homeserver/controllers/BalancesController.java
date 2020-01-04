package com.piotrzalecki.homeserver.controllers;

import com.piotrzalecki.homeserver.domain.AccountStatus;
import com.piotrzalecki.homeserver.services.BalanceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@Controller
public class BalancesController {

    private BalanceServiceImpl balanceService;

    public BalancesController(BalanceServiceImpl balanceService) {
        this.balanceService = balanceService;
    }


    @GetMapping({"balances"})
    public String index(Model model){
        ArrayList<Set<AccountStatus>> array = new ArrayList<>();
        array.add(balanceService.getRecentBalances());
        array.add(balanceService.getAllBalances());
        model.addAttribute("data", array);
        return "balances/index";
    }



    @PostMapping({"balances"})
    public String update(@ModelAttribute AccountStatus accountStatus, Model model){
        Long accountStatusId = accountStatus.getId();
        double balance = accountStatus.getBalance();
        balanceService.updateBalance(accountStatusId, balance);

        return "redirect:balances";
    }

    @GetMapping("balances/{id}")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("accountstatus", balanceService.getBalance(Long.valueOf(id)));
        return "balances/update";
    }

}
