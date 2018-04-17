package com.spring.mycontact.mycontatc.service;

import com.spring.mycontact.mycontatc.domain.Contact;
import com.spring.mycontact.mycontatc.repository.ContactDAO;

import java.util.ArrayList;
import java.util.List;

public class ContactDAOImpl implements ContactDAO {
    @Override
    public List<Contact> getAllContact() {
        List<Contact> contactList = new ArrayList<>();
        
        return null;
    }
}
