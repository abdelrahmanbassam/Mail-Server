package app.mailserver.service.Filter;

import java.util.ArrayList;
import java.util.List;

import app.mailserver.models.MailModel;

public class EmailSearch {

    public static List<MailModel> searchEmails(List<MailModel> emails, String searchWord) {
        if(searchWord.equals("")){
           return emails;
        } 
        List<MailModel> matchedEmails = new ArrayList<>();
        String searchWordLower = searchWord.toLowerCase();

        for (MailModel email : emails) {
            if (matchesCriteria(email, searchWordLower)) {
                matchedEmails.add(email);
            }
        }

        return matchedEmails;
    }

    private static boolean matchesCriteria(MailModel email, String searchWordLower) {
        for (String recipient : email.getTo()) {
            if (recipient.toLowerCase().contains(searchWordLower)) {
                return true;
            }
        }

        if (email.getsubject().toLowerCase().contains(searchWordLower)) {
            return true;
        }

        
        return email.getBody().toLowerCase().contains(searchWordLower);
    }

    
}
