package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String clients(@RequestParam(required = false) String action,
                          @RequestParam(required = false) Integer id,
                          Model model) {
        if (action == null) {
            List<Client> clients = new ArrayList<>(clientService.getAll());
            model.addAttribute("clients", clients);
            return "clients";
        } else if (action.equals("add")) {
            model.addAttribute("client", new Client());
            return "clientAdd";
        } else if (action.equals("edit")) {
            model.addAttribute("client", clientService.getById(id));
            return "clientAdd";
        } else if (action.equals("delete")) {
            clientService.delete(id);
            return "redirect:/clients";
        }
        return null;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addClient(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }
}
