package app.mailserver.service.filter;

import java.util.List;

import app.mailserver.models.MailModel;

public interface Criteria {
    public List<MailModel> meetCriteria(List<MailModel> emails,List<String>criterias);
} 