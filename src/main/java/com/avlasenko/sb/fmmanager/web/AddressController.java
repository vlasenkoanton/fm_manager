package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by A. Vlasenko on 18.06.2016.
 */
@Controller
@RequestMapping("/clients/{id}/address")
public class AddressController {

    @Autowired
    private ClientService service;

    @RequestMapping(method = RequestMethod.GET)
    public String address(@PathVariable Integer id,
                          Model model) {
        Client client = service.getById(id);
        Address address = client.getAddress();

        if (address == null) {
            model.addAttribute("address", new Address());
        } else {
            model.addAttribute("address", address);
        }
        model.addAttribute("client", client);
        return "address";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveAddress(@PathVariable Integer id,
                              @ModelAttribute Address address) {
        service.setAddress(id, address);
        return "redirect:/clients/"+id;
    }
}
