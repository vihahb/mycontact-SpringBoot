package com.spring.mycontact.mycontatc.service;

import com.spring.mycontact.mycontatc.domain.Contact;

import java.util.List;

public interface ContactService {

    Iterable<Contact> findAll();

    List<Contact> search(String key);

    Contact findOne(int id);

    void save(Contact contact);

    void delete(int id);
}
