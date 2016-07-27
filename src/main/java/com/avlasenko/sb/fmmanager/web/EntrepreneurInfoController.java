package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.service.EntrepreneurService;
import com.avlasenko.sb.fmmanager.util.LocalDatePropertyConverter;
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
@RequestMapping("/profiles/individuals/{id}/entrepreneur")
public class EntrepreneurInfoController {

    @Autowired
    private EntrepreneurService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDate.class, new LocalDatePropertyConverter("yyyy-MM-dd"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String entrepreneur(@PathVariable Integer id, Model model) {
        EntrepreneurInfo entrepreneurInfo = service.getByOwner(id);
        if (entrepreneurInfo == null) {
            model.addAttribute("entrepreneurInfo", new EntrepreneurInfo());
        } else {
            model.addAttribute("entrepreneurInfo", entrepreneurInfo);
        }
        return "entrepreneurInfo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveEntrepreneur(@ModelAttribute EntrepreneurInfo entrepreneurInfo, @PathVariable Integer id) {
        service.save(entrepreneurInfo, id);
        return "redirect:/profiles/individuals/" + id;
    }

    @RequestMapping(params = "action=delete", method = RequestMethod.GET)
    public String deleteEntrepreneur(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/profiles/individuals/" + id;
    }
}
