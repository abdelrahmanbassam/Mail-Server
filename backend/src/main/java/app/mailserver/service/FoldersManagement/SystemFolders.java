package app.mailserver.service.FoldersManagement;
import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;

import java.util.List;


public class SystemFolders {
    private static List<UserModel> allUsers;
    private static  UserModel curUser;

    public static UserModel signUp(String name,String emailAddress, String password){
        fetchAllUsers();
        if(isUserExist(emailAddress)){
            return null;
        }
        else{
            UserModel newUser=new UserModel(name,emailAddress,password);
            allUsers.add(newUser);
            curUser=newUser;

           return curUser; 
        }
    }

    public static boolean loginChecker(String emailAddress,String password){
        fetchAllUsers();
        return true;
    //     if(!isUserExist(emailAddress)){
    //         //if we want to type message"user not found"
    //         return false;
    //     }
    //     else{
    //          if(getUser(emailAddress).getPassword().equals(password)){
    //             curUser= getUser(emailAddress);
    //             return true;
    //         //we can type a message here
    //          }
    //     }
    //  return false;
    }

    public static UserModel getCurUser() {
        return curUser;
    }

    public static void fetchAllUsers(){
        allUsers=JsonFileHandler.fetchAllUsers();
    }

    //search in this.allUsers and set the user to the changedUser then update the file using json file handler 
    public static void updateUser(UserModel changedUser){
        
    }
    
    //search in allUsers.emailAddress and return 
    public static boolean isAddressExist(String address){
     return true;
    }

    //take an email and put it in receiver inbox and change the receiver to be me and the sender 
    public static void sendEmailTo(MailModel email ,String receiverAddress){
     
    }

    // search in this.allUsers and return a user model 
    public static boolean isUserExist(String emailAddress){
      return false;
    }

    //get user by address 
    // public static UserModel getUser(String emailAddress){
    //    //seach in allusers 
    //    UserModel x=new UserModel();
    //     return x;
    // }

}
