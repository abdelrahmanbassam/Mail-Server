package app.mailserver.service.Sorting;

import java.util.List;

import app.mailserver.models.MailModel;

public interface SortingStrategy {
    
    public List<MailModel> sort(List<MailModel> emails);
}