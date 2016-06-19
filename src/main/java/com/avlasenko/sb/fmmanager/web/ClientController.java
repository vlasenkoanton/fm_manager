package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String clientList(Model model) {
            List<Client> clients = new ArrayList<>(clientService.getAll());
            model.addAttribute("clients", clients);
            return "clients";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String editClient(@PathVariable Integer id,
                             @RequestParam(required = false) String action,
                             Model model) {
        if (action != null && action.equals("delete")) {
            clientService.delete(id);
            return "redirect:/clients";
        }
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "clientEditForm";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute Client client){
        clientService.saveWithRelations(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newClient(Model model){
        model.addAttribute("client", new Client());
        return "clientAddForm";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String addNewClient(@ModelAttribute Client client){
        clientService.save(client);
        return "redirect:/clients/"+client.getId();
    }

}
