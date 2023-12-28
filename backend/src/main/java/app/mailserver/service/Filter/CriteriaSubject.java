package app.mailserver.service.Filter;

import java.util.ArrayList;
import java.util.List;

import app.mailserver.models.MailModel;

public  class CriteriaSubject implements Criteria {
    
    @Override
    public  List<MailModel> meetCriteria(List<MailModel> emails,String subject){
        List<MailModel> filteredEmails =new ArrayList<MailModel>();
        
        for (MailModel email : emails) {

            if ((email.getsubject().toLowerCase()).equals(subject.toLowerCase())) { 
                    filteredEmails.add(email);
            }
        }
        return filteredEmails;
    }
}
