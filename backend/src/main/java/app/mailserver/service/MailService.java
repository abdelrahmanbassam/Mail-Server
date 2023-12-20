package app.mailserver.service;

import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.FoldersManagement.SystemFolders;

// import java.time.LocalDate;
// import java.util.List;
// import lombok.Builder;

/**
 * MailService
 */


public class MailService {
  
  

   public UserModel sendEmail(MailModel newEmail){
       UserModel curUser=SystemFolders.getCurUser();
       curUser.getFolders().addEmailTo("sentEmails",newEmail);
       
       for(var x : newEmail.getRecivers()){
         if(SystemFolders.isAddressExist(x)){
           SystemFolders.sendEmailTo(newEmail, x);
         }
       }
        SystemFolders.updateUser(curUser);
        return curUser;
   }

   public UserModel addToDraft(MailModel newEmail){
       UserModel curUser=SystemFolders.getCurUser();
       curUser.getFolders().addEmailTo("draft",newEmail);
       SystemFolders.updateUser(curUser);
      return curUser; 
   }
    
}