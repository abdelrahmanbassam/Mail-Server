package app.mailserver.service.FoldersManagement;
import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;

import java.util.List;


public class SystemFolders {
    private static List<UserModel> allUsers;
    private static  UserModel curUser;

    public static UserModel signUp(String name,String emailAddress, String password){
        fetchAllUsers();
        List<UserModel> x=allUsers;
        if(isUserExist(emailAddress)){
            return null;
        }
        else{
            UserModel newUser=new UserModel(name,emailAddress,password);
            allUsers.add(newUser);
            curUser=newUser;
            updateAllUsers();

            return curUser; 
        }
    }

    public static boolean loginChecker(String emailAddress,String password){
        fetchAllUsers();
        
        if(!isUserExist(emailAddress)){
            //if we want to type message"user not found"
            return false;
        }
        else{
             if(getUser(emailAddress).getPassword().equals(password)){
                curUser= getUser(emailAddress);
                return true;
            //we can type a message here
             }
        }
     return false;
    }

    public static UserModel getCurUser() {
        return curUser;
    }

    public static void fetchAllUsers(){
        allUsers=JsonFileHandler.fetchAllUsers();
    }

    //search in this.allUsers and set the user to the changedUser then update the file using json file handler 
    public static void updateUser(UserModel changedUser){
        for(int i = 0; i < allUsers.size(); i++){
            UserModel x = allUsers.get(i);
            if(x.getEmailAddress().equals(changedUser.getEmailAddress())){
                allUsers.set(i, changedUser); // Update the list at the specific index
                // Assuming you have a method to save the updated list to a file
                
                updateAllUsers();
            }
        }
    }
    
    //take an email and put it in receiver inbox and change the receiver to be me and the sender 
    public static void sendEmailTo(MailModel email ,String receiverAddress){
     
    }

    // search in this.allUsers and return a user model 
    public static boolean isUserExist(String emailAddress){
     for(var x :allUsers){
        if(x.getEmailAddress().equals(emailAddress))
        return true;
      }
      return false;
    }

    //get user by address 
    public static UserModel getUser(String emailAddress){

       for(var x :allUsers){
          if(x.getEmailAddress().equals(emailAddress))
            return x;
       }

       return null;
    }
    
    public static void updateAllUsers(){
          try {
                 JsonFileHandler.updateAllUsers(allUsers);
          } catch (Exception e) {
                    return;
          }
         
     }
}
