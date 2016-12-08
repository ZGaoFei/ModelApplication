package com.zgf.modelapplication.mock.test;

/**
 * Created by zgf on 2016/12/8.
 */

public class PersonService {
    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(int age, String name) {
        Person person = personDao.fetchPerson(age);
        if (person != null) {
            Person updatedPerson = new Person(person.getAge(), name);
            personDao.update(updatedPerson);
            return true;
        } else {
            return false;
        }
    }
}
