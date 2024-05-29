package com.taraskina.eshop.service;

import com.taraskina.eshop.entity.Person;
import com.taraskina.eshop.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    /**
     * Поиск всех брендов
     *
     * @return список найденных брендов
     */
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @Transactional
    public Person save(Person person){
        return personRepository.save(person);
    }

    public Person findById(Long id){
        return personRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Transactional
    public Person update(Person person){

        return personRepository.save(person);
    }

    @Transactional
    public void delete(Long id){
        personRepository.deleteById(id);
    }

    public Optional<Person> findByName(String name){
        return personRepository.findByName(name);
    }

}
