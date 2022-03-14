package ru.sbp.bankfinancialprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbp.bankfinancialprocessingsystem.cardutil.CardUtil;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CardStatusType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.CardsRepository;

import java.sql.Date;
import java.util.List;

/**
 * Сервисы работы с банковскими картами
 */
@Service
public class CardService {

    @Autowired
    private CardsRepository repo;

    /**
     * Создание карты
     * @param card
     */
    public void createNewCard(Card card) {
        List<Card> list = repo.findAll();

        card.setExpirationDate(new Date(new java.util.Date().getTime()));
        card.setCardStatus(CardStatusType.Valid);
        card.setCardNumber(CardUtil.getNumberCard(list, card.getPaymentSystem()));

        repo.save(card);
    }

    /**
     * Сохранение изменений в карте
     * @param card изменяемая карта
     */
    public void saveCard(Card card) {
        repo.save(card);
    }

    /**
     * Поиск карты по id
     * @param id карты
     * @return найденная карта
     */
    public Card getCardById(Integer id) {
        return repo.findCardById(id);
    }
}
