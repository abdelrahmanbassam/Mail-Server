package app.mailserver.models;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;

public class MailModel {

    private String sender;
    private List<String> receivers;//change it receivers reciver in all program 
    private String Subject;
    private String body;
    private LocalDate date;
    private String importance;
    private String Attachment;
    

  

    public MailModel() {
    }

    @Builder
    public MailModel(List<String> receivers, String sender, String Subject,String body,String Attachment,String importance) {
        this.receivers=receivers;
        this.sender=sender;
        this.Subject = Subject;
        this.body=body;
        this.Attachment=Attachment;
        this.importance=importance;
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

    public List<String> getReceivers() {
        return this.receivers;
    }

    public void setReceivers(List<String> receivers) {
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

    // public MailModel CreateMailModel(List<String> receivers, String sender, String Subject, String body, String attachment, String type) {
    //     MailModel MailModel = new MailModel().builder().receivers(receivers).sender(sender).Subject(Subject).body(body).Attachment(attachment).build();
    //         // user.SendMailModel(MailModel);
    //     return MailModel;
    // }
   
}

