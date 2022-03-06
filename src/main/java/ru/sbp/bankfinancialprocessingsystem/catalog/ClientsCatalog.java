package ru.sbp.bankfinancialprocessingsystem.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.ClientsRepository;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class ClientsCatalog {
    private final Map<String, Clients> clients = new HashMap<>();
    @Autowired
    private ClientsRepository clientsRepository;
    @PostConstruct
    public void init() {

        create(new Clients("Gera", "Gerasim", "Nemoy", "Тимофеевич",
                Date.valueOf("1872-05-12"), "Nema 5789 622589",
                "Володнинсая губерния, Петропавловский уезд", Date.valueOf("1899-06-04"),
                "mumu@mail.ru", "8-222-020-02-02"));

        create(new Clients("Kisa", "Ипполи́т", "Воробья́нинов", "Матве́евич",
                Date.valueOf("1875-01-22"), "2658 125687",
                "Старгородский уезд", Date.valueOf("1902-09-15"),
                "kisa@mail.ru", "8-456-085-98-21"));

        for (Clients client: clientsRepository.findAll())
        {
            create(client);
        }
    }
    public Collection<Clients> getAll() {

        return clients.values();
    }
    public Clients create(Clients client) {

        this.clients.put(client.getUserLogin(), client);
        return client;
    }
}
