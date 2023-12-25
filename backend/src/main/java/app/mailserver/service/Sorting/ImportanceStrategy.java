package app.mailserver.service.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.mailserver.models.MailModel;

public class ImportanceStrategy implements SortingStrategy {

    private static final Map<String, Integer> importanceMap = new HashMap<>();
    static {
        importanceMap.put("low", 1);
        importanceMap.put("mid", 2);
        importanceMap.put("high", 3);
        importanceMap.put("very high", 4);
    }

    @Override
    public List<MailModel> sort(List<MailModel> emails) {
        List<MailModel> sortedEmails = new ArrayList<>(emails);
        
        sortedEmails.sort(new Comparator<MailModel>() {
            @Override
            public int compare(MailModel m1, MailModel m2) {
                Integer importance1 = importanceMap.getOrDefault(m1.getImportance().toLowerCase(), 0);
                Integer importance2 = importanceMap.getOrDefault(m2.getImportance().toLowerCase(), 0);
                return importance2.compareTo(importance1);
            }
        });

        return sortedEmails;
    }
}
