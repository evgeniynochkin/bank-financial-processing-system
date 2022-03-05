package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.Cards;

/**
 * Класс enum содержит описание значений поля в таблие cards.payment_system
 * @autor Sergey Proshchaev
 * @version 1.0
 * @see Cards#Object()
 */
public enum PaymentSystemType {
    VISA,
    MC,
    МИР;

    PaymentSystemType() {
    }

}
