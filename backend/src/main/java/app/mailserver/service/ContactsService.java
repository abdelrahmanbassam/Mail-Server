package app.mailserver.service;

import java.util.List;

import app.mailserver.models.ContactModel;

public class ContactsService {

    private List<ContactModel> userContacts;

    public List<ContactModel> getUserContacts() {
        return userContacts;
    }

    public void setUserContacts(List<ContactModel> userContacts) {
        this.userContacts = userContacts;
    }

    public List<ContactModel> rename(ContactModel curConatct ,String newName){
        
        return this.userContacts;
    }
    public List<ContactModel> addEmailAddress(ContactModel curConatct ,String emailAddress){
        
        return this.userContacts;
    }
    public List<ContactModel> deleteEmailAddress(ContactModel curConatct ,String emailAddress){
        
        return this.userContacts;
    }
    public List<ContactModel> addPhoneNum(ContactModel curConatct ,String phoneNum){
        
        return this.userContacts;
    }
    public List<ContactModel> deletePhoneNum(ContactModel curConatct ,String phoneNum){
        
        return this.userContacts;
    }
    public List<ContactModel> sortContacts(){
        
        return this.userContacts;
    }
    public List<ContactModel> searchContacts(){
        
        return this.userContacts;
    }
   
}
