package app.mailserver.service;
import app.mailserver.service.FoldersManagement.SystemFolders;

import app.mailserver.models.UserModel;

public class UserService {
   private UserModel curUser;

   public UserModel login(String emailAddress, String password){
       if(SystemFolders.loginChecker(emailAddress,password)){
           
            this.curUser=SystemFolders.getCurUser();
            return curUser;
       }
       return null; 
   }

   public UserModel signUp(String name,String emailAddress, String password){
       if(SystemFolders.loginChecker(emailAddress,password)){
           
            this.curUser=SystemFolders.getCurUser();
            return curUser;
       }
       return null; 
   }
   
   public void logOut(){
   
}
}
