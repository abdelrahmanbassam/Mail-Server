package app.mailserver.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class trashModel extends FolderModel {
    Map <LocalDateTime,MailModel> deletedmMails=new HashMap<LocalDateTime,MailModel>();
    public trashModel(){
        SetName("trash");
    }
    public void toMap(List <MailModel> Deleted){
        for(var x:Deleted){
        deletedmMails.put(LocalDateTime.now(),x);
        }
    }
    public void addEmail(MailModel newEmail){
        getEmails().add(0, newEmail);
    }
    
    public void Checkdelete(){
        LocalDateTime toDelete=LocalDateTime.now().minusMinutes(5);
        System.out.println(toDelete);
        for(Map.Entry<LocalDateTime, MailModel> x:deletedmMails.entrySet()){
            if(x.getKey().isBefore(toDelete)){
                deletedmMails.remove(toDelete);
            }
        }
    }
    public String setbeginDate() {
        String ddate=new String();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       ddate=LocalDateTime.now().format(formatter);
       System.out.println(ddate);
       return ddate;
    }
    
    public List<MailModel> getEmail(){ 
        System.out.println(deletedmMails.keySet());
        Checkdelete();
       List<MailModel>Mails=new ArrayList<>(deletedmMails.values());     
       return Mails;
    }
    public trashModel(Map<LocalDateTime,MailModel> deletedmMails) {
        SetName("trash");
        this.deletedmMails = deletedmMails;
    }

    public Map<LocalDateTime,MailModel> getDeletedmMails() {
        return this.deletedmMails;
    }

    public void setDeletedmMails(Map<LocalDateTime,MailModel> deletedmMails) {
        this.deletedmMails = deletedmMails;
    }

    public trashModel deletedmMails(Map<LocalDateTime,MailModel> deletedmMails) {
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
