package com.spring.mycontact.mycontatc.repository;

import com.spring.mycontact.mycontatc.domain.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findContactByNameContaining(String prefix);

    Contact findContactById(int id);
}
