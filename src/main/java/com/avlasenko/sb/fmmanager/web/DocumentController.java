package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.service.ClientService;
import com.avlasenko.sb.fmmanager.util.LocalTimePropertyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


/**
 * Created by A. Vlasenko on 19.06.2016.
 */
@Controller
@RequestMapping("/clients/{id}/document")
public class DocumentController {

    @Autowired
    private ClientService clientService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDate.class, new LocalTimePropertyConverter("yyyy-MM-dd"));
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newDocument(Model model) {
        model.addAttribute("document", new Document());
        return "document";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String addNewDocument(@ModelAttribute Document document, @PathVariable Integer id) {
        Client client = clientService.getById(id);
        client.addDocument(document);
        clientService.save(client);
        return "redirect:/clients/"+id;
    }

    @RequestMapping(value = "{docId}", method = RequestMethod.GET)
    public String editDocument(@PathVariable Integer id,
                               @PathVariable Integer docId,
                               Model model) {
        model.addAttribute("document", clientService.getDocument(docId, id));
        return "document";
    }

    @RequestMapping(value = "{docId}", method = RequestMethod.POST)
    public String saveDocument(@PathVariable Integer id,
                               @ModelAttribute Document document) {
        Client client = clientService.getById(id);
        client.addDocument(document);
        clientService.save(client);
        return "redirect:/clients/"+id;
    }



}
