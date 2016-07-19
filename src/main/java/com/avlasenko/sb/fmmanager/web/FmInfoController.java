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
@RequestMapping("/clients/{id}/fmInfo")
public class FmInfoController {

    @Autowired
    private FmInfoService service;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newFmInfo(Model model) {
        model.addAttribute("fmInfo", new FmInfo());
        return "fmInfo";
    }

    @RequestMapping(value = "{fmInfoId}", method = RequestMethod.GET)
    public String editFmInfo(@PathVariable Integer id, @PathVariable Integer fmInfoId, Model model) {
        model.addAttribute("fmInfo", service.get(fmInfoId, id));
        return "fmInfo";
    }

    @RequestMapping(value = {"new", "{fmInfoId}"}, method = RequestMethod.POST)
    public String saveFmInfo(@ModelAttribute FmInfo fmInfo, @PathVariable Integer id) {
        service.save(fmInfo, id);
        return "redirect:/clients/" + id;
    }

    @RequestMapping(value = "{fmInfoId}", params = "action=delete", method = RequestMethod.GET)
    public String deleteFmInfo(@PathVariable Integer id, @PathVariable Integer fmInfoId) {
        service.delete(fmInfoId, id);
        return "redirect:/clients/" + id;
    }
}
