package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.service.FmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Controller
@RequestMapping("/profiles/individuals/{id}/fmInfo")
public class FmInfoController {

    @Autowired
    private FmInfoService service;

    @RequestMapping(method = RequestMethod.GET)
    public String fmInfo(@PathVariable Integer id, Model model) {
        FmInfo fmInfo = service.getByOwner(id);
        if (fmInfo == null) {
            model.addAttribute("fmInfo", new FmInfo());
        } else {
            model.addAttribute("fmInfo", fmInfo);
        }
        return "fmInfo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveFmInfo(@ModelAttribute FmInfo fmInfo, @PathVariable Integer id) {
        service.saveByOwner(fmInfo, id);
        return "redirect:/profiles/individuals/" + id;
    }

    @RequestMapping(params = "action=delete", method = RequestMethod.GET)
    public String deleteFmInfo(@PathVariable Integer id) {
        service.deleteByOwner(id);
        return "redirect:/profiles/individuals/" + id;
    }
}
