package app.mailserver.service.SystemManagement;
import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SystemFolders {
    // private static List<UserModel> allUsers;
    private static  UserModel curUser;

    public static UserModel getCurUser() {
            return curUser;
        }

    public static UserModel signUp(String name,String emailAddress, String password) throws IOException{
    
        if(JsonFileHandler.isUserExist(emailAddress)){
            //throw error then return 
        }
        if(!isValidEmail(emailAddress)){
            //throw error (invalid email format )then return
        }
        if(password.length()<6){
            //throw error (password is too short )then return
        }
        
        UserModel newUser=new UserModel(name,emailAddress,password);
     
        curUser=newUser;
        JsonFileHandler.writeUserModel(curUser);

        return curUser; 
        
    }

    public static boolean loginChecker(String emailAddress,String password){
        
        if(!JsonFileHandler.isUserExist(emailAddress)){
            //if we want to type message"user not found"
            return false;
        }
        else{
            UserModel tempUser= JsonFileHandler.fetchUser(emailAddress);
             if(tempUser.getPassword().equals(password)){
                curUser= tempUser;
                return true;
             }
        }
     return false;
    }

    public static void updateUser(UserModel changedUser) {
       try {
           JsonFileHandler.writeUserModel(changedUser);
       } catch (Exception e) {
        
       }
    }
   
    public static boolean isUserExist(String emailAddress) {
        return JsonFileHandler.isUserExist(emailAddress);
    }
    
    //take an email and put it in receiver inbox and change the receiver to be me and the sender 
    public static void sendEmailTo(MailModel email ,String receiverAddress) throws IOException{
           
          UserModel receiver= JsonFileHandler.fetchUser(receiverAddress);
          receiver.getFolders().addEmailTo("inbox", email); 
          JsonFileHandler.writeUserModel(receiver);
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+\\.com)$";
        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
}
