package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Related;
import com.avlasenko.sb.fmmanager.service.RelatedService;
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
@RequestMapping("/clients/{id}/related/{type}")
public class RelatedController {

    @Autowired
    private RelatedService service;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String addRelated(Model model) {
        model.addAttribute("related", new Related());
        return "related";
    }

    @RequestMapping(value = "{relatedId}", method = RequestMethod.GET)
    public String editRelated(@PathVariable Integer id, @PathVariable String type,
                              @PathVariable Integer relatedId, Model model) {
        model.addAttribute("related", service.get(relatedId, id, type));
        return "related";
    }

    @RequestMapping(value = {"new", "{relatedId}"}, method = RequestMethod.POST)
    public String saveRelated(@PathVariable Integer id, @PathVariable String type, @ModelAttribute Related related) {
        service.save(related, id, type);
        return "redirect:/clients/" + id;
    }

    @RequestMapping(params = "action=delete", value = "{relatedId}", method = RequestMethod.GET)
    public String DeleteRelated(@PathVariable Integer id, @PathVariable String type,
                              @PathVariable Integer relatedId) {
        service.delete(relatedId, id, type);
        return "redirect:/clients/" + id;
    }
}
