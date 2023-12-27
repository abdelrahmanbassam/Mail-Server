package app.mailserver.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Builder;
import java.util.Objects;


public class MailModel implements Cloneable {
    private String from;
    private List<String> to;//change it to reciver in all program 
    private String subject;
    private String body;
    private List<AttachmentModel> attachments;
    private String importance;
    private String date=new String();
    
    
    public List<String> getTo() {
        return to;
    }

    public MailModel() {
      
    }

    @Builder
    public MailModel(List<String> to, String from, String subject, String body, List<AttachmentModel> attachments, String importance, String date) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
        this.importance = importance;
        this.date = date;
    }

    @Override
    public MailModel clone() {
        try {
            return (MailModel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); 
        }
    }
    public List<AttachmentModel> getAttachments() {
        return this.attachments;
    }

    public void setattachments(List<AttachmentModel> attachments) {
        this.attachments = attachments;
    }

    public String getfrom() {
        return this.from;
    }

    public void setfrom(String from) {
        this.from = from;
    }

    

    public void setTo(List<String> to) {
        this.to = to;
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
  
    public void setDate(String date) {
        this.date=date;
    }
    public void setnewDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        date=LocalDateTime.now().format(formatter);
    }

  

    public String getImportance() {
        return this.importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

 

    // public MailModel(String attachments, String from, List<String> to, List<String> recivers, String subject, String body, LocalDateTime date, String type, String importance) {
    //     this.attachments = attachments;
    //     this.from = from;
    //     this.to = to;
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
        return Objects.equals(attachments, mailModel.attachments) && Objects.equals(from, mailModel.from) && Objects.equals(to, mailModel.to) &&  Objects.equals(subject, mailModel.subject) && Objects.equals(body, mailModel.body) && Objects.equals(date, mailModel.date) && Objects.equals(importance, mailModel.importance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachments, from, to, subject, body, date, importance);
    }

    @Override
    public String toString() {
        return "{" +
        " from='" + getfrom() + "'" +
        ", to='" + getTo() + "'" +
        ", subject='" + getsubject() + "'" +
        ", body='" + getBody() + "'" +
        ", attachments='" + getAttachments() + "'" +
        ", importance='" + getImportance() + "'" +
        ", date='" + getDate() + "'" +
            "}";
    }

 
   
}

