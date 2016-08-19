package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by A. Vlasenko on 18.06.2016.
 */
@Controller
@RequestMapping("/profiles/individuals/{id}/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @RequestMapping(method = RequestMethod.GET)
    public String address(@PathVariable Integer id, Model model) {
        Address address = service.getByOwner(id);
        if (address == null) {
            model.addAttribute("address", new Address());
        } else {
            model.addAttribute("address", address);
        }
        return "address";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveAddress(@ModelAttribute Address address, @PathVariable Integer id) {
        service.saveByOwner(address, id);
        return "redirect:/profiles/individuals/" + id;
    }

    @RequestMapping(params = "action=delete", method = RequestMethod.GET)
    public String deleteAddress(@PathVariable Integer id) {
        service.deleteByOwner(id);
        return "redirect:/profiles/individuals/" + id;
    }
}
