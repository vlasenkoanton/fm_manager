package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.service.IndividualService;
import com.avlasenko.sb.fmmanager.util.LocalDateTimePropertyConverter;
import com.avlasenko.sb.fmmanager.util.LocalDatePropertyConverter;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
@Controller
@RequestMapping("/profiles/individuals")
public class IndividualController {

    @Autowired
    private IndividualService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDate.class, new LocalDatePropertyConverter("yyyy-MM-dd"));
        webDataBinder.registerCustomEditor(LocalDateTime.class, new LocalDateTimePropertyConverter("yyyy-MM-dd hh:mm:ss"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("individuals", service.getAll());
        return "individuals";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String editIndividual(@PathVariable Integer id, Model model) {
        Individual individual = service.getWithAllProperties(id);
        model.addAttribute("individual", individual);
        if (individual.isClient()) {
            return "client";
        }
        return "individual";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public String saveIndividual(@ModelAttribute Individual individual, @PathVariable Integer id) {
        service.updateWithoutRelations(individual, id);
        return "redirect:/profiles/individuals";
    }

    @RequestMapping(params = "action=create", method = RequestMethod.GET)
    public String createClient(Model model) {
        model.addAttribute("individual", new IndividualQuickFormDTO());
        return "individualQuickForm";
    }

    @RequestMapping(params = "action=create", method = RequestMethod.POST)
    public String saveNewClient(@Valid @ModelAttribute("individual") IndividualQuickFormDTO quickFormDTO,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "individualQuickForm";
        }
        Integer id = service.save(quickFormDTO);
        return "redirect:individuals/" + id;
    }

    @RequestMapping(params = "action=delete", value = "{id}", method = RequestMethod.GET)
    public String deleteIndividual(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/profiles/individuals";
    }

}























