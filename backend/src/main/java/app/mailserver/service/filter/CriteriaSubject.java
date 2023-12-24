package app.mailserver.service.filter;

import java.util.ArrayList;
import java.util.List;

import app.mailserver.models.MailModel;

public class CriteriaSubject implements Criteria {
    
    @Override
    public List<MailModel> meetCriteria(List<MailModel> emails,List<String>subjects){
        List<MailModel> filteredEmails =new ArrayList<MailModel>();
        
        for (MailModel email : emails) {
            for (String subject : subjects) {
                if (email.getsubject().equals(subject.toLowerCase())) { 
                    filteredEmails.add(email);
                    break; 
                }
            }
        }
        return filteredEmails;
    }
}
