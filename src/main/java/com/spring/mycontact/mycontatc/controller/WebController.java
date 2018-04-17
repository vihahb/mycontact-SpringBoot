package com.spring.mycontact.mycontatc.controller;

import com.spring.mycontact.mycontatc.domain.Contact;
import com.spring.mycontact.mycontatc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String index(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "list";
    }

    @GetMapping("/contact/create")
    public String create(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @GetMapping("/contact/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));
        return "form";
    }

    @PostMapping("/contact/save")
    public String save(@Valid Contact contact, BindingResult bindResult, RedirectAttributes attributes) {
        if (bindResult.hasErrors()) {
            return "form";
        }
        List<Contact> contactList = (List<Contact>) contactService.findAll();
        for (Contact contact1 : contactList) {
            if (contact.getEmail().equals(contact1.getEmail())) {
                bindResult.addError(new FieldError("email", "email", "Email already exists!"));
                return "form";
            } else if (contact.getPhone().equals(contact1.getPhone())) {
                bindResult.addError(new FieldError("phone", "phone", "Phone already exists!"));
                return "form";
            }
        }
        contactService.save(contact);
        attributes.addFlashAttribute("success", "Saved contact successfully!");
        return "redirect:/contact";
    }

    @PostMapping("/contact/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        contactService.delete(id);
        redirect.addFlashAttribute("success", "Delete contact successfully!");
        return "redirect:/contact";
    }

    @GetMapping("contact/search")
    public String search(@RequestParam("key") String key, Model model) {
        if (key.equals(""))
            return "redirect:/contact";

        model.addAttribute("contacts", contactService.search(key));
        return "list";
    }

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

}
