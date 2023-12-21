package app.mailserver.service;
import app.mailserver.service.FoldersManagement.SystemFolders;

import org.springframework.stereotype.Service;

import app.mailserver.models.UserModel;

@Service
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
       if(SystemFolders.signUp(name,emailAddress,password)!=null){
           
            curUser=SystemFolders.getCurUser();
            
            return curUser;
       }
       return null; 
   }
   
   public void logOut(){
   
   }
   public static void main(String[] args) {

     UserService userService=new UserService();
     UserModel x=userService.signUp("tayson","ahmed@gmail.com", "fat7y");
     System.out.println("done");
    }
}
