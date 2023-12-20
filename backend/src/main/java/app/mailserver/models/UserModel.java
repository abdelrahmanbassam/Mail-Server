package app.mailserver.models;

import java.util.List;

public class UserModel {
    private int id;
    private String name;
    private String password;
    private String emailAddress;
    private List<ContactModel> contacts;
    
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
