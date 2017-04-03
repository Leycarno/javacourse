package com.leycarno.javacourse.java_06_mvc.services;

import com.leycarno.javacourse.java_06_mvc.models.Person;

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
