package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.catalog.ClientsCache;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.ClientsRepository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Сервлет контроллер, выводит страницу html по адресу "http://localhost:8080/clients/all"
 *
 */
@Controller
@RequestMapping(value = "/clients")
public class MVC_Controller {
    private ClientsRepository clientsRepository;
    @Autowired
    public void setClientsRepository(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }
    @GetMapping("/main")
    public ModelAndView clients(){

        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");
        model.addObject("message", "Доберо пожаловать в систему поиска и регитрации клиентов банка!");
        return model;
    }
    @GetMapping("/all")
    public ModelAndView getAll() {

        ModelAndView model = new ModelAndView();
        model.setViewName("/all.jsp");
        int i = 0;
        Collection<Clients> clients1 = new ArrayList<>(); Collection<Clients> clients2 = new ArrayList<>();
        for (Clients clientsIterator: this.clientsRepository.findAll()) {
            if (i++%2==0)
            {
                clients1.add(clientsIterator);
            } else {
                clients2.add(clientsIterator);
            }
        }

        model.addObject("message", "Сводный список всех клиентов банка:");
        model.addObject("clientsList1", clients1);
        model.addObject("clientsList2", clients2);
        return model;
    }
    @PostMapping("main")
    public ModelAndView new_user(@RequestBody() User user){

        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");
        return model;
    }
}
