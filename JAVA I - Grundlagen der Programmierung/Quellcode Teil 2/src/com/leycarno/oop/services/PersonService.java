package com.leycarno.oop.services;

import com.leycarno.oop.models.Person;

public class PersonService {

    /**
     * pay the money if you can
     *
     * @param person
     * @param money
     * @return payed?
     */
    public boolean pay(Person person, float money) {
        if (person.getMoney() < money) return false;
        person.setMoney(person.getMoney() - money);
        return true;
    }
}
