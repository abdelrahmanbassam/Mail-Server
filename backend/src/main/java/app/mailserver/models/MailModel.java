package app.mailserver.models;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import java.util.Objects;

public class MailModel {
    private String Attachment;
    private String sender;
    private List<String> receivers;//change it receivers reciver in all program 
    private String Subject;
    private String body;
    private LocalDate date;
    private String importance;
    
    
        public List<String> getRecivers() {
            return receivers;
        }

    public MailModel() {
    }

    @Builder
    public MailModel(List<String> receivers, String sender, String Subject,String body,String Attachment , String type) {
        this.receivers=receivers;
        this.sender=sender;
        this.Subject = Subject;
        this.body=body;
        this.Attachment=Attachment;
        // this.date = date.now();
    }
    public String getAttachment() {
        return this.Attachment;
    }

    public void setAttachment(String Attachment) {
        this.Attachment = Attachment;
    }

    public String getsender() {
        return this.sender;
    }

    public void setsender(String sender) {
        this.sender = sender;
    }

    public List<String> getreceivers() {
        return this.receivers;
    }

    public void setreceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public String getSubject() {
        return this.Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

  

    public String getImportance() {
        return this.importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

 

    public MailModel(String Attachment, String sender, List<String> receivers, List<String> recivers, String Subject, String body, LocalDate date, String type, String importance) {
        this.Attachment = Attachment;
        this.sender = sender;
        this.receivers = receivers;
        this.Subject = Subject;
        this.body = body;
        this.date = date;
        
        this.importance = importance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MailModel)) {
            return false;
        }
        MailModel mailModel = (MailModel) o;
        return Objects.equals(Attachment, mailModel.Attachment) && Objects.equals(sender, mailModel.sender) && Objects.equals(receivers, mailModel.receivers) &&  Objects.equals(Subject, mailModel.Subject) && Objects.equals(body, mailModel.body) && Objects.equals(date, mailModel.date) && Objects.equals(importance, mailModel.importance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Attachment, sender, receivers, Subject, body, date, importance);
    }

    @Override
    public String toString() {
        return "{" +
            " Attachment='" + getAttachment() + "'" +
            ", sender='" + getsender() + "'" +
            ", receivers='" + getreceivers() + "'" +
            ", Subject='" + getSubject() + "'" +
            ", body='" + getBody() + "'" +
            ", date='" + getDate() + "'" +
            ", importance='" + getImportance() + "'" +
            "}";
    }

 
   
}

