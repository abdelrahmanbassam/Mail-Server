package app.mailserver.service;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;

import app.mailserver.MailServerApplication;

/**
 * MailService
 */
class messsageBody {
    private String body = new String();

    public messsageBody() {
    }

    public messsageBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

}

class messageHeader {

    private String from;
    private List<String> to;
    private String Subject;

    public messageHeader(List<String> to, String from, String subject) {
        this.to = to;
        this.from = from;
        this.Subject = subject;
    }

    public messageHeader() {
    }

    public String getFrom() {
        return this.from;
    }

    public List<String> getTo() {
        return this.to;
    }

    public String getSubject() {
        return this.Subject;
    }

}

class Attachment {
    private String Attachment;

    public String getAttachment() {
        return this.Attachment;
    }

    public Attachment(String Attachment) {
        this.Attachment = Attachment;
    }

    public Attachment() {
    }

}

class message {
    private messsageBody messbody;
    private messageHeader header;
    private Attachment attachment;
    private Date date;

    public message(messageHeader header, messsageBody messbody, Attachment attachment, Date date) {
        this.messbody = messbody;
        this.header = header;
        this.attachment = attachment;
        this.date = date;
    }

    public messsageBody getMessbody() {
        return this.messbody;
    }

    public messageHeader getHeader() {
        return this.header;
    }

    public Attachment getAttachment() {
        return this.attachment;
    }
}

public class MailService {
    // the user class to make requests to send emails and the security class are
    // needed
    public message CreateMessage(List<String> to, String from, String Subject, String body, String Attachment,
            Date date) {
        messsageBody mbody = new messsageBody(body);
        messageHeader mHeader = new messageHeader(to, from, Subject);
        Attachment mAttachment = new Attachment(Attachment);
        message message = new message(mHeader, mbody, mAttachment, date);
        // user.Sendmessage(message);
        return message;
    }
}