package app.mailserver.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Builder;
import java.util.Objects;

public class MailModel {
    private String sender="ahmed";
    private List<String> receivers;//change it receivers reciver in all program 
    private String subject;
    private String body;
    private String Attachment;
    private String importance;
    private String date=setDate();
    
    
    public List<String> getReceivers() {
        return receivers;
    }

    public MailModel() {
      
    }

    // @Builder
    // public MailModel(List<String> receivers, String sender, String subject,String body,String Attachment , String type) {
    //     this.receivers=receivers;
    //     this.sender=sender;
    //     this.subject = subject;
    //     this.body=body;
    //     this.Attachment=Attachment;
    //     this.date = date.now();
    // }
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

    

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public String getsubject() {
        return this.subject;
    }

    public void setsubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return this.body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    public String getDate() {
        return date; 
    }
  
    public String setDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

  

    public String getImportance() {
        return this.importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

 

    // public MailModel(String Attachment, String sender, List<String> receivers, List<String> recivers, String subject, String body, LocalDateTime date, String type, String importance) {
    //     this.Attachment = Attachment;
    //     this.sender = sender;
    //     this.receivers = receivers;
    //     this.subject = subject;
    //     this.body = body;
    //     this.date = date;
        
    //     this.importance = importance;
    // }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MailModel)) {
            return false;
        }
        MailModel mailModel = (MailModel) o;
        return Objects.equals(Attachment, mailModel.Attachment) && Objects.equals(sender, mailModel.sender) && Objects.equals(receivers, mailModel.receivers) &&  Objects.equals(subject, mailModel.subject) && Objects.equals(body, mailModel.body) && Objects.equals(date, mailModel.date) && Objects.equals(importance, mailModel.importance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Attachment, sender, receivers, subject, body, date, importance);
    }

    @Override
    public String toString() {
        return "{" +
        " sender='" + getsender() + "'" +
        ", receivers='" + getReceivers() + "'" +
        ", subject='" + getsubject() + "'" +
        ", body='" + getBody() + "'" +
        ", Attachment='" + getAttachment() + "'" +
        ", importance='" + getImportance() + "'" +
        ", date='" + getDate() + "'" +
            "}";
    }

 
   
}

