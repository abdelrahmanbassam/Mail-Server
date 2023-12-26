package app.mailserver.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.SystemManagement.SystemManager;


@Service
public class MailService {
   private SystemManager systemManager; // Field to store the singleton instance

   public MailService() {
       this.systemManager = SystemManager.getInstance(); // Initialize the singleton instance
   }
  

   public UserModel sendEmail(MailModel newEmail) throws IOException{

       UserModel curUser=systemManager.getCurUser();
       curUser.getFolders().addEmailTo("send",newEmail);
       systemManager.updateUser(curUser);

       //we can make it as a queue 
       for(var x : newEmail.getTo()){

         if(systemManager.isUserExist(x)){
            List<String>singleReceiver=new ArrayList<>();
            singleReceiver.add(x);
            MailModel sentMail=newEmail.clone();
            sentMail.setTo(singleReceiver);
            
            systemManager.sendEmailTo(sentMail, x);
          }

       }
        return curUser;
   }

   public UserModel addToDraft(MailModel newEmail){
       UserModel curUser=systemManager.getCurUser();
       curUser.getFolders().addEmailTo("draft",newEmail);
       systemManager.updateUser(curUser);
      return curUser; 
   }
    
}