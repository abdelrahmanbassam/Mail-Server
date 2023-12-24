package app.mailserver.controller;

import app.mailserver.models.*;
import app.mailserver.service.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

class updateRequest {
    
@RestController
@CrossOrigin
@RequestMapping
public class ContactController {
    @Autowired
    private ContactsService contactService;
    @Autowired
    private ObjectMapper objectMapper;
    
    @PostMapping("/addContact")
    public UserModel addContact(@RequestBody RequestObject params) {
       
        return contactService.addContact(convertParams(params));
    }

    @PostMapping("/deleteContact")
    public UserModel deleteCotact(@RequestBody RequestObject params) {
        return contactService.deleteContact(convertParams(params));
    }

    @PostMapping("/searchContact")
    public List<ContactModel> search(@RequestBody RequestObject params) {
      
        return contactService.searchContacts((String)params.getByKey("contactName"));
    }

    @PostMapping("/editContact")
    public UserModel editContact(@RequestBody RequestObject params) {

        return contactService.editContact((String)params.getByKey("oldName"),convertParams(params));
    }

    public ContactModel convertParams(RequestObject params){
       Map<String, Object> reqContact = (Map<String, Object>) params.getByKey("contact");
       return objectMapper.convertValue(reqContact, ContactModel.class);
    }
 }
}
