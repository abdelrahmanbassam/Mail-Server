package app.mailserver.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.annotation.MergedAnnotations.Search;
import org.springframework.stereotype.Service;

import app.mailserver.models.ContactModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.FoldersManagement.JsonFileHandler;
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

    return curUser;
  }

  public void deleteContact(ContactModel contact, UserModel curUser) {

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

  }

  public List<ContactModel> searchContacts(String Name, UserModel curUser) {
    List<ContactModel> curContacts = curUser.getContacts();
    List<ContactModel> searched = curContacts.stream()
        .filter(contact -> contact.getName().toLowerCase().contains(Name.toLowerCase()))
        .collect(Collectors.toList());
    return searched;
  }

  public void sort(UserModel curUser) {
    List<ContactModel> curContacts = curUser.getContacts();
    Collections.sort(curContacts, new Comparator<ContactModel>() {
      public int compare(ContactModel Contact1, ContactModel Contact2) {
        return Contact1.getName().toLowerCase().compareTo(Contact2.getName().toLowerCase());
      }
    });
  }
}
