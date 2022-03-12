package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.ClientsRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
        model.addObject("message", "Добро пожаловать в систему поиска и регитрации клиентов банка!");
        return model;
    }

    @PostMapping("/main")
    public ModelAndView delete(@RequestParam("userLogin") String userLogin){

        Optional<Clients> client = clientsRepository.findById(userLogin);


        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");
        if (!client.isPresent())
        {
            model.addObject("message", "Клиент с логином '" + userLogin + "' не найден в базе данных!");
        } else {
            clientsRepository.deleteById(userLogin);
            model.addObject("message", "Клиент с логином '" + userLogin + "' удален!");
        }
        return model;
    }

    @GetMapping("/find")
    public ModelAndView clients(@RequestParam("userLogin") String userLogin){

        Optional<Clients> client = clientsRepository.findById(userLogin);
        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");
        if (!client.isPresent())
        {
            model.addObject("message", "Клиент с логином '" + userLogin + "' не найден в базе данных!");
        } else {
            model.addObject("userData",client.get());
            model.addObject("message", "Добро пожаловать в систему поиска и регитрации клиентов банка!");
        }

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

    @PostMapping("/create")
    public ModelAndView new_user(@RequestBody() Clients client){

        ModelAndView model = new ModelAndView();
        if (client == null || client.getUserLogin().equals("")) {
            model.addObject("message", "Нельзя зписывать клиента с пустым логином!");
        } else {
            System.out.printf(clientsRepository.save(client).toString());
            model.addObject("userData", client);
        }
        model.setViewName("/clients.jsp");
        return model;
    }
    @PutMapping("/findFIO")
    public ModelAndView find_fio(@RequestBody() Clients user) {

        ModelAndView model = new ModelAndView();
        if (user == null) {
            model.addObject("message", "Нельзя зписывать клиента с пустым логином!");
        } else {
            List<Clients> clientsList = new ArrayList<>();
            for (Clients usr: clientsRepository.findAll()) {
                if (usr.getFirstName().equals(user.getFirstName())
                        &&usr.getLastName().equals(user.getLastName())
                        &&usr.getMiddleName().equals(user.getMiddleName()))
                {
                    clientsList.add(usr);
                }
            }
            if (clientsList.size() == 0){
                model.addObject("message", "Клиентов с данным фио не найдено в базе данных!");
            } else if (clientsList.size() > 1){
                model.addObject("message", "Клиентов с данным фио найдено больше одного!");
            } else {
                model.addObject("message", "Найден один пользователь!");
                model.addObject("userData", clientsList.get(0));
            }
        }
        model.setViewName("/clients.jsp");
        return model;
    }
}
