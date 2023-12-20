package app.mailserver.models;

import java.sql.Date;
import java.sql.Struct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FolderModel {

    private String name;
    private List <MailModel> emails;
    private List<FolderModel> subFolders;
    
    
    public void SetName(String name ){
        this.name=name;
    }

    public List<MailModel> getEmails() {
        return this.emails;
    }
    public String getName() {
        return this.name;
    }    
    public FolderModel(){
        this.subFolders=new ArrayList<>();
    }

    public FolderModel(String name, List<MailModel> emails, List<FolderModel> subFolders) {
        this.name = name;
        this.emails = emails;
        this.subFolders = subFolders;
    }

    public void addEmail(MailModel newEmail){
        emails.add(newEmail);
    }

    public void deleteEmail( MailModel deletedEmail){
       emails.remove(deletedEmail);
    }
    // public List <MailModel> filterEmails(filterParameter){
       
    // }
    // public void sortEmails(sortParameter){
       
    // }
    // public void searchEmails(sortParameter){
       
    // }
   
}
