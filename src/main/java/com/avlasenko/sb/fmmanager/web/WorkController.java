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
@RequestMapping("/clients/{id}/work")
public class WorkController {

    @Autowired
    private WorkService service;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newWork(Model model) {
        model.addAttribute("work", new Work());
        return "work";
    }

    @RequestMapping(value = "{workId}", method = RequestMethod.GET)
    public String editWork(@PathVariable Integer id, @PathVariable Integer workId, Model model) {
        model.addAttribute("work", service.get(workId, id));
        return "work";
    }

    @RequestMapping(value = {"new", "{workId}"}, method = RequestMethod.POST)
    public String saveWork(@ModelAttribute Work work, @PathVariable Integer id) {
        service.save(work, id);
        return "redirect:/clients/"+id;
    }

    @RequestMapping(value = "{workId}", params = "action=delete", method = RequestMethod.GET)
    public String deleteWork(@PathVariable Integer id, @PathVariable Integer workId) {
        service.delete(workId, id);
        return "redirect:/clients/"+id;
    }
}
