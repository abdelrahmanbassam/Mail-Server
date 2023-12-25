package app.mailserver.service.Filter;

import java.util.ArrayList;
import java.util.List;

import app.mailserver.models.MailModel;

public class CriteriaSender implements Criteria {
    
    @Override
    public List<MailModel> meetCriteria(List<MailModel> emails,String sender){
        List<MailModel> filteredEmails =new ArrayList<MailModel>();
        
        for (MailModel email : emails) {
            if (email.getfrom().contains(sender)) {
              filteredEmails.add(email);
            }
        }
        return filteredEmails;
    }
}
