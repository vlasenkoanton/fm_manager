package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by A. Vlasenko on 27.06.2016.
 */
@Controller
@RequestMapping("/profiles/individuals/{id}/work")
public class WorkController {

    @Autowired
    private WorkService service;

    @RequestMapping(method = RequestMethod.GET)
    public String work(@PathVariable Integer id, Model model) {
        Work work = service.getByOwner(id);
        if (work == null) {
            model.addAttribute("work", new Work());
        } else {
            model.addAttribute("work", work);
        }
        return "work";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveWork(@ModelAttribute Work work, @PathVariable Integer id) {
        service.saveByOwner(work, id);
        return "redirect:/profiles/individuals/"+id;
    }

    @RequestMapping(params = "action=delete", method = RequestMethod.GET)
    public String deleteWork(@PathVariable Integer id) {
        service.deleteByOwner(id);
        return "redirect:/profiles/individuals/"+id;
    }
}
