package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.catalog.ClientsCatalog;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Сервлет контроллер, выводит страницу html по адресу "http://localhost:8080/clients/all"
 *
 */
@Controller
@RequestMapping(value = "/clients")
public class MVC_Controller {

    public ClientsCatalog clientsCatalog;

    @Autowired
    public void setUsers(ClientsCatalog clientsCatalog) {
        this.clientsCatalog = clientsCatalog;
    }

    @GetMapping()
    public ModelAndView info(){

        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");
        //model.addObject("message", "Hello from controller SpringMVC ");
        return model;
    }

    @GetMapping("all")
    public ModelAndView allUsers(){

        Collection<Clients> clients = this.clientsCatalog.getAll();

        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");
        model.addObject("clientsList", clients);
        return model;
    }
}
