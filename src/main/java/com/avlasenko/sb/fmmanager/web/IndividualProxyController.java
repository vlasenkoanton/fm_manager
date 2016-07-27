package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.service.IndividualService;
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

/**
 * Created by A. Vlasenko on 22.07.2016.
 */
@Controller
@RequestMapping("/profiles/individuals/{id}/proxies/{type}")
public class IndividualProxyController {

    @Autowired
    private IndividualService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDate.class, new LocalDatePropertyConverter("yyyy-MM-dd"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String createProxy(Model model) {
        model.addAttribute("individual", new IndividualQuickFormDTO());
        return "individualQuickForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveProxy(@Valid @ModelAttribute("individual") IndividualQuickFormDTO dto, BindingResult result,
                            @PathVariable Integer id, @PathVariable String type) {
        if (result.hasErrors()) {
            return "individualQuickForm";
        }
        service.saveProxy(dto, id, type);
        return "redirect:/profiles/individuals/" + id;
    }
}
