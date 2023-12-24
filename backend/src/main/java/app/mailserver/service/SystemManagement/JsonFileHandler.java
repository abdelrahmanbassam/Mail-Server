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
    private static final String usersDataFilePath =  Paths.get("").toAbsolutePath().resolve("backend/src/main/resources/usersData.json").toString();    
  

    //read from all_usersfile    
    public static List<UserModel> fetchAllUsers(){
      ObjectMapper objectmapper=new ObjectMapper();
      try{
          File file=new File(usersDataFilePath);
        List<UserModel>usersData=objectmapper.readValue(file, new TypeReference<List<UserModel>>(){});
        
        return usersData;
      }
      catch(Exception e){
        return new ArrayList<>();
          // e.printStackTrace();
      }
    } 
   
 
    //write in all_usersfile
     public static void updateAllUsers(List<UserModel> updatedList) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        // System.out.println("Values read from Json");
        //   for(var x:updatedList){
        //       System.out.println(x.toString());
        //   }
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(usersDataFilePath), updatedList);
     } 
     

}
