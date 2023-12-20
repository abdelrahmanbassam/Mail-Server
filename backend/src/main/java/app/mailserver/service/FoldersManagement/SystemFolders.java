package app.mailserver.service.FoldersManagement;
import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import java.util.List;


public class SystemFolders {
    private List<UserModel> allUsers;
    private UserModel curUser;

    public List<UserModel> getAllUsers() {
        return allUsers;
    }

    //use json file handler to fetch allUsers
    public static void fetchAllUsers(){

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

    //search in this.allUsers and return a user model 
    // public UserModel getUserByAddress(String emailAddress){
      
    // }


}
