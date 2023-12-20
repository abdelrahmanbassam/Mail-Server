package app.mailserver.service.FoldersManagement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.mailserver.models.UserModel;

public class JsonFileHandler {
        private static final String usersDataFilePath =  Paths.get("").toAbsolutePath().resolve("C:\\USers\\Osama\\Desktop\\mail-server\\Mail-Server\\backend\\src\\main\\resources\\usersData.json").toString();    
   

    //read from all_usersfile    
     public List<UserModel> fetchAllUsers(){
        ObjectMapper objectmapper=new ObjectMapper();
        try{
            File file=new File(usersDataFilePath);
          List<UserModel>usersData=objectmapper.readValue(file, new TypeReference<List<UserModel>>(){});
          System.out.println("Values read from Json");

            for(var x:usersData){
                System.out.println(x.getId());
            }

          return usersData;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
     } 
   
 
    //write in all_usersfile
     public  void updateAllUsers(List<UserModel> updatedList) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(usersDataFilePath), updatedList);          
     } 


    public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
        JsonFileHandler s=new JsonFileHandler();
        UserModel os=new UserModel();
        UserModel osa=new UserModel();
        UserModel osa1=new UserModel();
        UserModel osa2=new UserModel();
        List <UserModel> users=new ArrayList<>();
        os.setId(0);
        os.setName("metarsham");
        osa.setId(1);
        osa1.setId(2);
        osa2.setId(5);
        osa1.setName("a7aaaaaa");
        users.add(os);
        users.add(osa2);
        users.add(osa);
        users.add(osa1);
        s.updateAllUsers(users);
        s.fetchAllUsers();


    }
}
