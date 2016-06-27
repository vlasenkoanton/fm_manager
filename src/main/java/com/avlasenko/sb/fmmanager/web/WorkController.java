package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.service.ClientService;
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
@Controller("/clients/{id}/work")
public class WorkController {

    @Autowired
    private ClientService service;

    @RequestMapping(method = RequestMethod.GET)
    public String editWork(@PathVariable Integer id, Model model) {
        Client cLient = service.getById(id);
        Work work = cLient.getWork();

        if (work == null) {
            model.addAttribute("work", new Work());
        } else {
            model.addAttribute("work", work);
        }
        return "work";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveWork(@ModelAttribute Work work, @PathVariable Integer id) {
        Client client = service.getById(id);
        client.setWork(work);
        service.save(client);
        return "redirect:/clients/"+id;
    }
}
