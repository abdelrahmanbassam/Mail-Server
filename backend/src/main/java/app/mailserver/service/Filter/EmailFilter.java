package app.mailserver.service.Filter;

import java.util.ArrayList;
import java.util.List;

import app.mailserver.models.MailModel;

public class EmailFilter {
    private static Criteria criteriaSubject=new CriteriaSubject();  
    private static Criteria criteriaSender=new CriteriaSender();  

   public static List<MailModel> filterEmails(List<MailModel> emails,String subjectFilter,String senderFilter){
    
            List<MailModel> filteredEmails =new ArrayList<MailModel>();
            filteredEmails=emails;

            if(subjectFilter!=""){
            filteredEmails=criteriaSubject.meetCriteria(filteredEmails,subjectFilter);
            } 
            if(senderFilter!=""){
            filteredEmails=criteriaSender.meetCriteria(filteredEmails,senderFilter);
            } 
         return filteredEmails;   
   }
}
