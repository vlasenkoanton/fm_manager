package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.Contact;
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
@Controller
@RequestMapping("/clients/{id}/contact")
public class ContactController {

    @Autowired
    private ClientService service;

    @RequestMapping(method = RequestMethod.GET)
    public String editContact(@PathVariable Integer id, Model model) {
        Client client = service.getById(id);
        Contact contact = client.getContact();

        if (contact == null) {
            model.addAttribute("contact", new Contact());
        } else {
            model.addAttribute("contact", contact);
        }
        return "contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveContact(@ModelAttribute Contact contact, @PathVariable Integer id) {
        Client client = service.getById(id);
        client.setContact(contact);
        service.save(client);
        return "redirect:/clients/"+id;
    }

}
