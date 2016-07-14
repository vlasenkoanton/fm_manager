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
@RequestMapping("/clients/{id}/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newAddress(Model model) {
        model.addAttribute("address", new Address());
        return "address";
    }

    @RequestMapping(value = "{addressId}", method = RequestMethod.GET)
    public String editAddress(@PathVariable Integer id,
                              @PathVariable Integer addressId,
                              Model model) {
        model.addAttribute("address", service.get(addressId, id));
        return "address";
    }

    @RequestMapping(value = {"new", "{addressId}"}, method = RequestMethod.POST)
    public String saveAddress(@ModelAttribute Address address, @PathVariable Integer id) {
        service.save(address, id);
        return "redirect:/clients/"+id;
    }

    @RequestMapping(value = "{addressId}", params = "action=delete", method = RequestMethod.GET)
    public String deleteAddress(@PathVariable Integer addressId, @PathVariable Integer id) {
        service.delete(addressId, id);
        return "redirect:/clients/"+id;
    }

}
