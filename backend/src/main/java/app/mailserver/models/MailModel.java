package app.mailserver.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import lombok.Builder;

public class MailModel {
    private String Attachment;
    private String from;
    private List<String> to;
    private String Subject;
    private String body;
    private LocalDate date;
    private String type;
    private String importance;


    public MailModel() {
    }

    @Builder
    public MailModel(List<String> to, String from, String Subject,String body,String Attachment ,LocalDate date, String type) {
        this.to=to;
        this.from=from;
        this.Subject = Subject;
        this.body=body;
        this.Attachment=Attachment;
        this.date = date.now();
        this.type = type;
    }

    public String getAttachment() {
        return this.Attachment;
    }

    public void setAttachment(String Attachment) {
        this.Attachment = Attachment;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return this.to;
    }

    public void setTo(List<String> to) {
        this.to = to;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public MailModel CreateMailModel(List<String> to, String from, String Subject, String body, String attachment,
            LocalDate date, String type) {
        MailModel MailModel = new MailModel().builder().to(to).from(from).Subject(Subject).body(body).Attachment(attachment).build();
            // user.SendMailModel(MailModel);
        return MailModel;
    }
   
}

