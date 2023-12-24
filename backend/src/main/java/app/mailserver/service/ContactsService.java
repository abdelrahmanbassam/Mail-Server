package app.mailserver.service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import app.mailserver.models.ContactModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.FoldersManagement.SystemFolders;
@Service
public class ContactsService {
  // add
  // delete
  // edit
  // search
  // sort
  public UserModel addContact(ContactModel newContact, UserModel curUser) {

    List<ContactModel> curContacts = curUser.getContacts();
    curUser.setContacts(curContacts);

    curContacts.add(newContact);
    SystemFolders.updateUser(curUser);
    return curUser;
  }

  public UserModel deleteContact(ContactModel contact, UserModel curUser) {

    List<ContactModel> curContacts = curUser.getContacts();

    curUser.setContacts(curContacts);

    for (int i = 0; i < curContacts.size(); i++) {

      if (curContacts.get(i).getPhoneNums().get(0).equals(contact.getPhoneNums().get(0))
          && curContacts.get(i).getName().toLowerCase().equals(contact.getName().toLowerCase())) {

        curContacts.remove(i);
        break;
        
      }
    }
    curUser.setContacts(curContacts);
    SystemFolders.updateUser(curUser);
    return curUser;
    
  }

  public List<ContactModel> searchContacts(String Name, UserModel curUser) {
    List<ContactModel> curContacts = curUser.getContacts();
    List<ContactModel> searched = curContacts.stream()
        .filter(contact -> contact.getName().toLowerCase().contains(Name.toLowerCase()))
        .collect(Collectors.toList());
    return searched;
  }

  public UserModel sort(UserModel curUser) {
    List<ContactModel> curContacts = curUser.getContacts();
    Collections.sort(curContacts, new Comparator<ContactModel>() {
      public int compare(ContactModel Contact1, ContactModel Contact2) {
        return Contact1.getName().toLowerCase().compareTo(Contact2.getName().toLowerCase());
      }
    });
    SystemFolders.updateUser(curUser);
    return curUser;
  }

}
