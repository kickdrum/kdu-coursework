package com.example.springhandson5.dao;


import com.example.springhandson5.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAO {
    List<Person> personList;
    public PersonDAO() {
        this.personList = new ArrayList<>();
    }
    public void addPerson(Person person){
        personList.add(person);
    }
    public Person getPersonByIndex(int index){
        return personList.get(index);
    }

    public String getRoleByPersonIndex(int index){
        return personList.get(index).getRole();
    }

    public List<Person> getAllPersons(){
        return personList;
    }

}
