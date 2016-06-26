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
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String addressEdit(@PathVariable Integer id, Model model) {
        Client client = clientService.getById(id);
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
        Client client = clientService.getById(id);
        client.setAddress(address);
        clientService.save(client);
        return "redirect:/clients/" + id;
    }
}
