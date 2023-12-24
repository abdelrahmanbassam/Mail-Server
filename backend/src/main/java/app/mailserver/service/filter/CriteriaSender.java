package app.mailserver.service.filter;

import java.util.ArrayList;
import java.util.List;

import app.mailserver.models.MailModel;

public class CriteriaSender implements Criteria {
    
    @Override
    public List<MailModel> meetCriteria(List<MailModel> emails,List<String>addresses){
        List<MailModel> filteredEmails =new ArrayList<MailModel>();
        
        for (MailModel email : emails) {
            if (addresses.contains(email.getfrom())) {
              filteredEmails.add(email);
            }
        }
        return filteredEmails;
    }
}
