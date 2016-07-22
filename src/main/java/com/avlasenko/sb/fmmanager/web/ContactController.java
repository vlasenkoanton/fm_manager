package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.service.ContactService;
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
@RequestMapping("/profiles/individuals/{id}/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @RequestMapping(method = RequestMethod.GET)
    public String contact(@PathVariable Integer id, Model model) {
        Contact contact = service.getByOwner(id);
        if (contact == null) {
            model.addAttribute("contact", new Contact());
        } else {
            model.addAttribute("contact", contact);
        }
        return "contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveContact(@ModelAttribute Contact contact, @PathVariable Integer id) {
        service.save(contact, id);
        return "redirect:/profiles/individuals/" + id;
    }

    @RequestMapping(params = "action=delete", method = RequestMethod.GET)
    public String deleteContact(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/profiles/individuals/" + id;
    }

}
