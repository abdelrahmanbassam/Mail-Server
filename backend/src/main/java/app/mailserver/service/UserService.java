package app.mailserver.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.mailserver.models.UserModel;
import app.mailserver.service.SystemManagement.SystemManager;

@Service
public class UserService {
    private UserModel curUser;

    private SystemManager systemManager; // Field to store the singleton instance

    public UserService() {
        this.systemManager = SystemManager.getInstance(); // Initialize the singleton instance
    }

    public Map<String, Object> login(String emailAddress, String password) {
       
        Map<String, Object> response = new HashMap<String, Object>();
        response=systemManager.loginChecker(emailAddress, password);

        if ((boolean)response.get("isValid")) {

            this.curUser = systemManager.getCurUser();
            return response;
        }
        return response;
    }

    public Map<String, Object> signUp(String name, String emailAddress, String password) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();
        response=systemManager.signUp(name, emailAddress, password);

        if ((boolean)response.get("isValid")) {

            curUser = systemManager.getCurUser();
        }
        return response;
    }
   
    public void logOut() {

    }

}
