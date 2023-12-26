package app.mailserver.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.mailserver.models.UserModel;
import app.mailserver.service.SystemManagement.SystemFolders;

@Service
public class UserService {
    private UserModel curUser;

    public Map<String, Object> login(String emailAddress, String password) {
       
        Map<String, Object> response = new HashMap<String, Object>();
        response=SystemFolders.loginChecker(emailAddress, password);

        if ((boolean)response.get("isValid")) {

            this.curUser = SystemFolders.getCurUser();
            return response;
        }
        return response;
    }

    public Map<String, Object> signUp(String name, String emailAddress, String password) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();
        response=SystemFolders.signUp(name, emailAddress, password);

        if ((boolean)response.get("isValid")) {

            curUser = SystemFolders.getCurUser();
        }
        return response;
    }
   
    public void logOut() {

    }

}
