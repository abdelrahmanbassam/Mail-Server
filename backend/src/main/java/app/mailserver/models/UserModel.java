package app.mailserver.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// import org.springframework.boot.SpringApplication;

// import app.mailserver.MailServerApplication;

public class UserModel {
   
    private String name;
    private String emailAddress;
    private String password;
    private List<ContactModel> contacts;
    private UserFoldersModel folders;
    
    public UserModel(){
        this.folders=new UserFoldersModel();
    }
    public UserModel(String name, String emailAddress,String password) {
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.folders=new UserFoldersModel();
        this.contacts=new ArrayList<>();
    }
    
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
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(name, userModel.name) && Objects.equals(password, userModel.password) && Objects.equals(emailAddress, userModel.emailAddress) && Objects.equals(contacts, userModel.contacts) && Objects.equals(folders, userModel.folders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, emailAddress, contacts, folders);
    }

    @Override
    public String toString() {
        return "{" +
            
            " name='" + getName() + "'" +
            ", password='" + getPassword() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            ", contacts='" + getContacts() + "'" +
            ", folders='" + getFolders() + "'" +
            "}";
    }
    

}
