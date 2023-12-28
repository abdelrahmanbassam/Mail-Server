package app.mailserver.service.Sorting;

import java.util.ArrayList;
import java.util.List;

import app.mailserver.models.MailModel;

public class EmailSort {
    private static SortingStrategy dateStrategy=new DateStrategy();  
    private static SortingStrategy ImportanceStrategy=new ImportanceStrategy(); 

    public static List<MailModel> SortEmails(List<MailModel> emails,String sortLogic){
           if(sortLogic=="")
             return emails;


            List<MailModel> filteredEmails =new ArrayList<MailModel>();
            filteredEmails=emails;

            if(sortLogic.equals("date")){
                  return dateStrategy.sort(filteredEmails);
            }
            else{
                 return ImportanceStrategy.sort(filteredEmails);
            }

   }
}
