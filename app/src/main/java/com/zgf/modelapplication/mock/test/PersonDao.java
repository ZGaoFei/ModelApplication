package com.zgf.modelapplication.mock.test;

/**
 * Created by zgf on 2016/12/8.
 */

public interface PersonDao {
    Person fetchPerson(int age);
    void update(Person person);
}
