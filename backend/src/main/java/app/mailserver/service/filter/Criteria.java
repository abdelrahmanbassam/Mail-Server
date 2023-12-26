package app.mailserver.service.Filter;

import java.util.List;

import app.mailserver.models.MailModel;

public interface Criteria {
    public  List<MailModel> meetCriteria(List<MailModel> emails,String sender);
} 