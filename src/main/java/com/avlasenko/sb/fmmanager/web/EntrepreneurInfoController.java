package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.service.EntrepreneurService;
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
public class EntrepreneurInfoController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDate.class, new LocalTimePropertyConverter("yyyy-MM-dd"));
    }

    @Autowired
    private EntrepreneurService service;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newEntrepreneur(Model model) {
        model.addAttribute("entrepreneurInfo", new EntrepreneurInfo());
        return "entrepreneurInfo";
    }

    @RequestMapping(value = "{entrepreneurId}", method = RequestMethod.GET)
    public String editEntrepreneur(@PathVariable Integer id, @PathVariable Integer entrepreneurId, Model model) {
        model.addAttribute("entrepreneurInfo", service.get(entrepreneurId, id));
        return "entrepreneurInfo";
    }

    @RequestMapping(value = {"new", "{entrepreneurId}"}, method = RequestMethod.POST)
    public String saveEntrepreneur(@ModelAttribute EntrepreneurInfo entrepreneurInfo, @PathVariable Integer id) {
        service.save(entrepreneurInfo, id);
        return "redirect:/clients/"+id;
    }

    @RequestMapping(value = "{entrepreneurId}", params = "action=delete", method = RequestMethod.GET)
    public String deleteEntrepreneur(@PathVariable Integer id, @PathVariable Integer entrepreneurId) {
        service.delete(entrepreneurId, id);
        return "redirect:/clients/"+id;
    }
}
