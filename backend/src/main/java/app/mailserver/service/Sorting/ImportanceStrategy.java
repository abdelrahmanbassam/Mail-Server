package app.mailserver.service.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import app.mailserver.models.MailModel;

public class ImportanceStrategy implements SortingStrategy {
   
    @Override
    public List<MailModel> sort(List<MailModel> emails) {
        List<MailModel> sortedEmails = new ArrayList<>(emails);
        sortedEmails.sort(Comparator.comparing(MailModel::getImportance)); 
        return sortedEmails;
    }
}
