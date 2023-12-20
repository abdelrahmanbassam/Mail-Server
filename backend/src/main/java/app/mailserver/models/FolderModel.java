package app.mailserver.models;

import java.util.List;

public class FolderModel {

    private String name;
    private List <MailModel> mails;
    private List<FolderModel> subFolders;

 
    public FolderModel(String name, List<MailModel> mails, List<FolderModel> subFolders) {
        this.name = name;
        this.mails = mails;
        this.subFolders = subFolders;
    }

    public void addEmail(MailModel newEmail){
        mails.add(newEmail);
    }

    public void deleteEmail(MailModel newEmail){
       
    }
    // public List <MailModel> filterEmails(filterParameter){
       
    // }
    // public void sortEmails(sortParameter){
       
    // }
    // public void searchEmails(sortParameter){
       
    // }
    
    
}
