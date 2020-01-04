package com.piotrzalecki.homeserver.controllers;

import com.piotrzalecki.homeserver.services.BalanceService;
import com.piotrzalecki.homeserver.services.BalanceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private BalanceService balanceService;

    public IndexController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }


    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model){

        List data = new ArrayList<>();
        data.add(balanceService.getTotalBalance());
        data.add("-320");
        data.add("-18");
        data.add("50");
        model.addAttribute("data", data);
        return "index";
    }
}
