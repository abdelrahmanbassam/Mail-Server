package app.mailserver.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.SystemManagement.SystemFolders;

// import java.time.LocalDate;
// import java.util.List;
// import lombok.Builder;

/**
 * MailService
 */

@Service
public class MailService {
  
  

   public UserModel sendEmail(MailModel newEmail) throws IOException{

       UserModel curUser=SystemFolders.getCurUser();
       curUser.getFolders().addEmailTo("sentEmails",newEmail);
       SystemFolders.updateUser(curUser);

       //we can make it as a queue 
       for(var x : newEmail.getTo()){

         if(SystemFolders.isUserExist(x)){
            List<String>singleReceiver=new ArrayList<>();
            singleReceiver.add(x);
            MailModel sentMail=new MailModel();
            sentMail =newEmail;
            sentMail.setTo(singleReceiver);
            
            SystemFolders.sendEmailTo(sentMail, x);
          }

       }
        return curUser;
   }

   public UserModel addToDraft(MailModel newEmail){
       UserModel curUser=SystemFolders.getCurUser();
       curUser.getFolders().addEmailTo("draft",newEmail);
       SystemFolders.updateUser(curUser);
      return curUser; 
   }
    
}