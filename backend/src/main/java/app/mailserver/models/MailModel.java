package app.mailserver.models;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import java.util.Objects;

public class MailModel {
    private String Attachment;
    private String from;
    private List<String> to;//change it to reciver in all program 
    private List<String> recivers;
    public List<String> getRecivers() {
        return recivers;
    }

    public void setRecivers(List<String> recivers) {
        this.recivers = recivers;
    }
    private String Subject;
    private String body;
    private LocalDate date;
    private String type;
    private String importance;


    public MailModel() {
    }

    @Builder
    public MailModel(List<String> to, String from, String Subject,String body,String Attachment , String type) {
        this.to=to;
        this.from=from;
        this.Subject = Subject;
        this.body=body;
        this.Attachment=Attachment;
        // this.date = date.now();
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

    public String getImportance() {
        return this.importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MailModel(String Attachment, String from, List<String> to, List<String> recivers, String Subject, String body, LocalDate date, String type, String importance) {
        this.Attachment = Attachment;
        this.from = from;
        this.to = to;
        this.recivers = recivers;
        this.Subject = Subject;
        this.body = body;
        this.date = date;
        this.type = type;
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
        return Objects.equals(Attachment, mailModel.Attachment) && Objects.equals(from, mailModel.from) && Objects.equals(to, mailModel.to) && Objects.equals(recivers, mailModel.recivers) && Objects.equals(Subject, mailModel.Subject) && Objects.equals(body, mailModel.body) && Objects.equals(date, mailModel.date) && Objects.equals(type, mailModel.type) && Objects.equals(importance, mailModel.importance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Attachment, from, to, recivers, Subject, body, date, type, importance);
    }

    @Override
    public String toString() {
        return "{" +
            " Attachment='" + getAttachment() + "'" +
            ", from='" + getFrom() + "'" +
            ", to='" + getTo() + "'" +
            ", recivers='" + getRecivers() + "'" +
            ", Subject='" + getSubject() + "'" +
            ", body='" + getBody() + "'" +
            ", date='" + getDate() + "'" +
            ", type='" + getType() + "'" +
            ", importance='" + getImportance() + "'" +
            "}";
    }

    // public MailModel CreateMailModel(List<String> to, String from, String Subject, String body, String attachment, String type) {
    //     MailModel MailModel = new MailModel().builder().to(to).from(from).Subject(Subject).body(body).Attachment(attachment).build();
    //         // user.SendMailModel(MailModel);
    //     return MailModel;
    // }
   
}

