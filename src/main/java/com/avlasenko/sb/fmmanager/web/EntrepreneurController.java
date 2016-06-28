package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.service.ClientService;
import com.avlasenko.sb.fmmanager.util.LocalTimePropertyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Created by A. Vlasenko on 28.06.2016.
 */
@Controller
@RequestMapping("/clients/{id}/entrepreneur")
public class EntrepreneurController {

    @Autowired
    private ClientService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDate.class, new LocalTimePropertyConverter("yyyy-MM-dd"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String editEntrepreneurInfo(@PathVariable Integer id, Model model) {
        Client client = service.getById(id);
        EntrepreneurInfo entrepreneurInfo = client.getEntrepreneurInfo();

        if (entrepreneurInfo == null) {
            model.addAttribute("entrepreneurInfo", new EntrepreneurInfo());
        } else {
            model.addAttribute("entrepreneurInfo", entrepreneurInfo);
        }
        return "entrepreneurInfo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveEntrepreneurInfo(@ModelAttribute EntrepreneurInfo entrepreneurInfo,
                                       @PathVariable Integer id) {
        Client client = service.getById(id);
        client.setEntrepreneurInfo(entrepreneurInfo);
        service.save(client);
        return "redirect:/clients/"+id;
    }
}
