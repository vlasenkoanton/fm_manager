package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.service.DocumentService;
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
@RequestMapping("/profiles/individuals/{id}/documents")
public class DocumentController {

    @Autowired
    private DocumentService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDate.class, new LocalTimePropertyConverter("yyyy-MM-dd"));
    }

    @RequestMapping(params = "action=create", method = RequestMethod.GET)
    public String newDocument(Model model) {
        model.addAttribute("document", new Document());
        return "document";
    }

    @RequestMapping(params = "action=create", method = RequestMethod.POST)
    public String saveNewDocument(@ModelAttribute Document document, @PathVariable Integer id) {
        service.save(document, id);
        return "redirect:/profiles/individuals/"+id;
    }

    @RequestMapping(value = "{docId}", method = RequestMethod.GET)
    public String editDocument(@PathVariable Integer id,
                               @PathVariable Integer docId,
                               Model model) {
        model.addAttribute("document", service.get(docId, id));
        return "document";
    }

    @RequestMapping(value = "{docId}", method = RequestMethod.POST)
    public String saveDocument(@ModelAttribute Document document, @PathVariable Integer id) {
        service.save(document, id);
        return "redirect:/profiles/individuals/"+id;
    }

    @RequestMapping(value = "{docId}", params = "action=delete", method = RequestMethod.GET)
    public String deleteDocument(@PathVariable Integer id, @PathVariable Integer docId) {
        service.delete(docId, id);
        return "redirect:/profiles/individuals/"+id;
    }

}
