package app.mailserver.models;

import java.util.List;

// import org.springframework.boot.SpringApplication;

// import app.mailserver.MailServerApplication;

public class UserModel {
    private int id;
    private String name;
    private String password;
    private String emailAddress;
    public UserModel(String name, String password, String emailAddress) {
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
    }
    private List<ContactModel> contacts;
    private UserFoldersModel folders;
    
    public UserFoldersModel getFolders() {
        return folders;
    }
    public void setFolders(UserFoldersModel folders) {
        this.folders = folders;
    }
    public List<ContactModel> getContacts() {
        return contacts;
    }
    public void setContacts(List<ContactModel> contacts) {
        this.contacts = contacts;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
