package app.mailserver.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import app.mailserver.models.ContactModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.SystemManagement.SystemManager;
@Service
public class ContactsService {

  private SystemManager systemManager; // Field to store the singleton instance

  public ContactsService() {
      this.systemManager = SystemManager.getInstance(); // Initialize the singleton instance
  }
 
  public List<ContactModel> addContact(ContactModel newContact) {
    UserModel curUser=systemManager.getCurUser();
    List<ContactModel> curContacts = curUser.getContacts();
    curUser.setContacts(curContacts);
    if(newContact.getName()==null){
      return curUser.getContacts();
    }
    curContacts.add(newContact);
    sort();
    systemManager.updateUser(curUser);
    return curUser.getContacts();
  }

  public List<ContactModel> deleteContact(ContactModel contact) {
    UserModel curUser=systemManager.getCurUser();
    List<ContactModel> curContacts = curUser.getContacts();

    for (int i = 0; i < curContacts.size(); i++) {

      if (curContacts.get(i).getName().toLowerCase().equals(contact.getName().toLowerCase())) {

        curContacts.remove(i);
        break;
        
      }
    }
    curUser.setContacts(curContacts);
    systemManager.updateUser(curUser);
    return curUser.getContacts();
    
  }
  public List<ContactModel> editContact(String oldName,ContactModel updatedContactModel){
    UserModel curUser=systemManager.getCurUser();
    List<ContactModel> curContacts = curUser.getContacts();
    for(int i=0;i<curContacts.size();i++){
      if(curContacts.get(i).getName().equalsIgnoreCase(oldName)){
        curContacts.get(i).setName(updatedContactModel.getName());
        curContacts.get(i).setEmailAddresses(updatedContactModel.getEmailAddresses());
        curContacts.get(i).setPhoneNums(updatedContactModel.getPhoneNums());
        curContacts.get(i).setImportance(updatedContactModel.getImportance());
        break;
      }
    }
    curUser.setContacts(curContacts);
    sort();
    systemManager.updateUser(curUser);
    return curUser.getContacts();


  }
  public List<ContactModel> searchContacts(String Name) {
    UserModel curUser=systemManager.getCurUser();
    List<ContactModel> curContacts =new ArrayList<>();
    curContacts=curUser.getContacts();
    return curContacts.stream()
        .filter(contact -> contact.getName().toLowerCase().contains(Name.toLowerCase()))
        .collect(Collectors.toList());
  }
  

  public List<ContactModel> sort() {
    UserModel curUser=systemManager.getCurUser();
    List<ContactModel> curContacts = curUser.getContacts();
    Collections.sort(curContacts, new Comparator<ContactModel>() {
      public int compare(ContactModel Contact1, ContactModel Contact2) {
        return Contact1.getName().toLowerCase().compareTo(Contact2.getName().toLowerCase());
      }
    });
    systemManager.updateUser(curUser);
    return curUser.getContacts();
  }

  public  List<ContactModel> getContacts(){
     UserModel curUser=systemManager.getCurUser();
     return curUser.getContacts();
  }

}
