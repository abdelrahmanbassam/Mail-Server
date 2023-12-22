package app.mailserver.service;

import org.springframework.stereotype.Service;

import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.FoldersManagement.SystemFolders;

// import java.time.LocalDate;
// import java.util.List;
// import lombok.Builder;

/**
 * MailService
 */

@Service
public class MailService {
  
  

   public UserModel sendEmail(MailModel newEmail){

       UserModel curUser=SystemFolders.getCurUser();
       curUser.getFolders().addEmailTo("sentEmails",newEmail);
       SystemFolders.updateUser(curUser);

       //we can make it as a queue 
       for(var x : newEmail.getReceivers()){

         if(SystemFolders.isUserExist(x)){

           UserModel receiver=SystemFolders.getUser(x);
           receiver.getFolders().addEmailTo("inbox", newEmail);

           SystemFolders.updateUser(receiver);
         }

       }
        return curUser;
   }

   public UserModel addToDraft(MailModel newEmail){
       UserModel curUser=SystemFolders.getCurUser();
       System.out.println(newEmail.toString());
       curUser.getFolders().addEmailTo("draft",newEmail);
       SystemFolders.updateUser(curUser);
      return curUser; 
   }
    
}