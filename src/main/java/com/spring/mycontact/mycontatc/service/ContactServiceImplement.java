package com.spring.mycontact.mycontatc.service;

import com.spring.mycontact.mycontatc.domain.Contact;
import com.spring.mycontact.mycontatc.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImplement implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public Iterable<Contact> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Contact> search(String key) {
        return repository.findContactByNameContaining(key);
    }

    @Override
    public Contact findOne(int id) {
        return repository.findContactById(id);
    }

    @Override
    public void save(Contact contact) {
        repository.save(contact);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}
