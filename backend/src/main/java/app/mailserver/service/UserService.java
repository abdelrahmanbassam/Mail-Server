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
    // public UserModel login(String emailAddress, String password) {

    //     if (SystemFolders.loginChecker(emailAddress, password)) {

    //         this.curUser = SystemFolders.getCurUser();
    //         return curUser;
    //     }
    //     return null;
    // }

    // public UserModel signUp(String name, String emailAddress, String password) throws IOException {
    //     if (SystemFolders.signUp(name, emailAddress, password) != null) {

    //         curUser = SystemFolders.getCurUser();

    //         return curUser;
    //     }
    //     return null;
    // }


    public void logOut() {

    }

}
