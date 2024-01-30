package com.example.userSecurity.service;


import com.example.userSecurity.dao.PersonDAO;
import com.example.userSecurity.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonService(PersonDAO personDAO){
        this.personDAO=personDAO;
    }
    PersonDAO personDAO;

    public void addPerson(Person person){

        personDAO.addPerson(person);
    }

    public Person getPersonById(int id){

        return personDAO.getPersonByIdx(id);
    }

    public String getRoleById(int id){

        return personDAO.getRoleByPersonIdx(id);
    }

    public Person getPersonUserName(String name){
        for(Person person : personDAO.getAllPersons()){
            if(person.getUsername().equals(name)){
                return person;
            }
        }
        return null;
    }
    public List<Person> getAllUsers(){
        return personDAO.getAllPersons();
    }
}
