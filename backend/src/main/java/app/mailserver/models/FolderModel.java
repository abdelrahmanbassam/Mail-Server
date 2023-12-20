package app.mailserver.models;

import java.util.List;

public class FolderModel {

    private String name;
    private List <MailModel> emails;
    private List<FolderModel> subFolders;

 
    public FolderModel(String name, List<MailModel> emails, List<FolderModel> subFolders) {
        this.name = name;
        this.emails = emails;
        this.subFolders = subFolders;
    }

    public void addEmail(MailModel newEmail){
        emails.add(newEmail);
    }

    public void deleteEmail( MailModel deletedEmail){
       
    }
    // public List <MailModel> filterEmails(filterParameter){
       
    // }
    // public void sortEmails(sortParameter){
       
    // }
    // public void searchEmails(sortParameter){
       
    // }
    
    
}
