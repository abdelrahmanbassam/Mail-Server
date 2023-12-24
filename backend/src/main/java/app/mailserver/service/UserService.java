package app.mailserver.service;

import org.springframework.stereotype.Service;

import app.mailserver.models.UserModel;
import app.mailserver.service.SystemManagement.SystemFolders;

@Service
public class UserService {
    private UserModel curUser;

    public UserModel login(String emailAddress, String password) {

        if (SystemFolders.loginChecker(emailAddress, password)) {

            this.curUser = SystemFolders.getCurUser();
            return curUser;
        }
        return null;
    }

    public UserModel signUp(String name, String emailAddress, String password) {
        if (SystemFolders.signUp(name, emailAddress, password) != null) {

            curUser = SystemFolders.getCurUser();

            return curUser;
        }
        return null;
    }


    public void logOut() {

    }

}
