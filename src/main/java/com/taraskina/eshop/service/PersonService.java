package com.taraskina.eshop.service.impl;

import com.taraskina.eshop.entity.Person;
import com.taraskina.eshop.repository.PersonRepository;
import com.taraskina.eshop.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @Override
    @Transactional
    public Person save(Person person){
        return personRepository.save(person);
    }

   @Override
    public Person findById(Long id){
        return personRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    @Transactional
    public Person update(Person person){
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public void delete(Long id){
        personRepository.deleteById(id);
    }

    @Override
    public Person findByName(String name){
        return personRepository.findByName(name).orElseThrow(()->new RuntimeException());
    }

}
