package app.mailserver.service.SystemManagement;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import app.mailserver.models.UserModel;

public class JsonFileHandler {
    private static final String usersDataFilePath =  Paths.get("").toAbsolutePath().resolve("backend/src/main/resources/users").toString();    
  
    public static boolean checkforfile(String email){
      String userfile=usersDataFilePath+"/"+email+".json";
      File file=new File(userfile);
      return file.exists();
    }
    //read from all_usersfile    
    public static UserModel fetchAllUsers(String email){
      String userfile=usersDataFilePath+email+".json";
      ObjectMapper objectmapper=new ObjectMapper();
      try{
          File file=new File(userfile);
        UserModel usersData=objectmapper.readValue(file, new TypeReference<UserModel>(){});
        
        return usersData;
      }
      catch(Exception e){
        return new UserModel();
          // e.printStackTrace();
      }
    } 
   
 
    //write in all_usersfile
     public static void updateAllUsers(UserModel updatedList) throws IOException{
      String userfile=usersDataFilePath+"/"+updatedList.getEmailAddress()+".json";
      ObjectMapper objectmapper=new ObjectMapper();
        // System.out.println("Values read from Json");
        //   for(var x:updatedList){
        //       System.out.println(x.toString());
        //   }
        objectmapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectmapper.writeValue(new File(userfile), updatedList);
     } 

}
