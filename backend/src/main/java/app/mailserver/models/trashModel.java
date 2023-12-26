package app.mailserver.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class trashModel extends FolderModel {
    Map <String,List<MailModel>> DeletedmMails=new HashMap<String,List<MailModel>>();
    public trashModel(){
        trashModel s=new trashModel();
        DeletedmMails.put(setbeginDate(), s.getEmails());
    }
    
    public void Checkdelete(){
        trashModel s=new trashModel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String toDelete=LocalDateTime.now().minusDays(30).format(formatter);
        if(DeletedmMails.containsKey(toDelete)){
            for(int i=0;i<DeletedmMails.get(toDelete).size();i++){
            s.deleteEmail(DeletedmMails.get(toDelete).get(i));
            }
        }

    }
    public String setbeginDate() {
        String ddate=new String();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       ddate=LocalDateTime.now().format(formatter);
       return ddate;
    }
    public List<MailModel> getEmails(){
       List<MailModel>Mails=new ArrayList<>();
       return Mails;
    }

}
