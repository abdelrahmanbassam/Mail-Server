package app.mailserver.service;

import java.util.List;


import app.mailserver.models.ContactModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.FoldersManagement.SystemFolders;

public class ContactsService {
  //add
  //delete
  //edit
  //search
  //sort
  public UserModel addContact(){
      UserModel curUser=SystemFolders.getCurUser();
      List<ContactModel>curContacts=curUser.getContacts();


      
      curUser.setContacts(curContacts);
      SystemFolders.updateUser(curUser);
      return curUser;
  }
}
