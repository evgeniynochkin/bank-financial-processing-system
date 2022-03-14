package ru.sbp.bankfinancialprocessingsystem.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class osUserCache {

    private Map<String, PosUserInfo> cache = new HashMap<>();

    public PosUserInfo get(String id) {
        return cache.get(id);
    }

    private void create(PosUserInfo info) {
        cache.put(info.getLogin(), info);
    }

    @PostConstruct
    public void init() {
        // Администраторы
        create(new PosUserInfo("admin", "admin", "Admin Name", "ADMIN"));
        // Пользователь
        create(new PosUserInfo("user", "user", "Manager Name", "MANAGER"));

    }

}
