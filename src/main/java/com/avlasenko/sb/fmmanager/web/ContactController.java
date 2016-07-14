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
@RequestMapping("/clients/{id}/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @RequestMapping(value = "{contactId}", method = RequestMethod.GET)
    public String editContact(@PathVariable Integer id, @PathVariable Integer contactId, Model model) {
        model.addAttribute("contact", service.get(contactId, id));
        return "contact";
    }

    @RequestMapping(value = {"new", "{contactId}"}, method = RequestMethod.POST)
    public String saveContact(@ModelAttribute Contact contact, @PathVariable Integer id) {
        service.save(contact, id);
        return "redirect:/clients/"+id;
    }

    @RequestMapping(value = "{contactId}", params = "action=delete", method = RequestMethod.GET)
    private String deleteContact(@PathVariable Integer id, @PathVariable Integer contactId) {
        service.delete(contactId, id);
        return "redirect:/clients/"+id;
    }

}
