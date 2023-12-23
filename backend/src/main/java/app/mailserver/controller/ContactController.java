package app.mailserver.controller;

import app.mailserver.models.*;
import app.mailserver.service.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class updateRequest {
    private String oldName;
    private ContactModel updatedContactModel;

    public updateRequest() {
    }

    public updateRequest(String oldName, ContactModel updatedContactModel) {
        this.oldName = oldName;
        this.updatedContactModel = updatedContactModel;
    }

    public String getOldName() {
        return this.oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public ContactModel getUpdatedContactModel() {
        return this.updatedContactModel;
    }

    public void setUpdatedContactModel(ContactModel updatedContactModel) {
        this.updatedContactModel = updatedContactModel;
    }

    @Override
    public String toString() {
        return "{" +
                " oldName='" + getOldName() + "'" +
                ", updatedContactModel='" + getUpdatedContactModel() + "'" +
                "}";
    }

}

@RestController
@CrossOrigin
@RequestMapping
public class ContactController {
    @Autowired
    private ContactsService contactService;

    @PostMapping("/add")
    public UserModel addContact(@RequestBody ContactModel newContact) {
        return contactService.addContact(newContact);
    }

    @PostMapping("/delete")
    public UserModel deleteCotact(@RequestBody ContactModel deletedContact) {
        return contactService.deleteContact(deletedContact);
    }

    @PostMapping("/search")
    public List<ContactModel> search(@RequestBody String name) {
        System.out.println(name);
        return (contactService.searchContacts(name.trim()));
    }

    @PostMapping("/edit")
    public UserModel editContact(@RequestBody updateRequest updatedContactModel) {
        return contactService.editContact(updatedContactModel.getOldName(),
                updatedContactModel.getUpdatedContactModel());
    }

}
