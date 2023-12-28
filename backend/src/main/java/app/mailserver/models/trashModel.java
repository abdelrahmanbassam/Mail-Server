package app.mailserver.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import app.mailserver.service.SystemManagement.SystemManager;

public class trashModel extends FolderModel {
    Map <String,MailModel> deletedmMails=new HashMap<String,MailModel>();

   

    public trashModel(String name, List<MailModel> emails, List<FolderModel> subFolders) {
        super(name, emails, subFolders);
    }

    public void addEntryDate(MailModel Deleted){
            deletedmMails.put(setbeginDate(),Deleted);
    }
    
    public String setbeginDate() {
        String ddate=new String();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       ddate=LocalDateTime.now().format(formatter);
       System.out.println(ddate);
       return ddate;
    }

    public void addEmail(MailModel newEmail){
        addEntryDate(newEmail);
        emails.add(0, newEmail);
    }

    public List<MailModel> getEmails(){
         Checkdelete();
         setEmails(getEmailsFromMap());
         return getEmailsFromMap();
    }
    public void Checkdelete(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String toDelete=LocalDateTime.now().minusMinutes(5).format(formatter);
        Iterator<Map.Entry<String, MailModel>> iterator = deletedmMails.entrySet().iterator();
        while (iterator.hasNext()) {
        Map.Entry<String, MailModel> entry = iterator.next();
        String key = entry.getKey();
        if (key.compareTo(toDelete) <= 0) {
            iterator.remove();
        }
    }
}
    
    
    public List<MailModel> getEmailsFromMap(){ 
        System.out.println(deletedmMails.keySet());
        Checkdelete();
       List<MailModel>Mails=new ArrayList<>(deletedmMails.values());     
       return Mails;
    }
   
  

    public Map<String,MailModel> getDeletedmMails() {
        return this.deletedmMails;
    }

    public void setDeletedmMails(Map<String,MailModel> deletedmMails) {
        this.deletedmMails = deletedmMails;
    }

    public trashModel deletedmMails(Map<String,MailModel> deletedmMails) {
        setDeletedmMails(deletedmMails);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof trashModel)) {
            return false;
        }
        trashModel trashModel = (trashModel) o;
        return Objects.equals(deletedmMails, trashModel.deletedmMails);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
            " deletedmMails='" + getDeletedmMails() + "'" +
            "}";
    }

   
    
}
