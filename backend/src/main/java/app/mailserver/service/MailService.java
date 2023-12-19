package app.mailserver.service;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

/**
 * MailService
 */
class messsageBody {

    private String body = new String();

    public messsageBody() {
    }

    @Builder
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

    public messageHeader() {
    };

    @Builder
    public messageHeader(List<String> to, String from, String subject) {
        this.to = to;
        this.from = from;
        this.Subject = subject;
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

    public Attachment() {
    }

    public String getAttachment() {
        return this.Attachment;
    }

    @Builder
    public Attachment(String Attachment) {
        this.Attachment = Attachment;
    }

}

class message {
    private messsageBody messbody;
    private messageHeader header;
    private Attachment attachment;
    private LocalDate date;
    private String type;

    public message() {
    }

    @Builder
    public message(messageHeader header, messsageBody messbody, Attachment attachment, LocalDate date, String type) {
        this.messbody = messbody;
        this.header = header;
        this.attachment = attachment;
        this.date = date.now();
        this.type = type;
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
    public message CreateMessage(List<String> to, String from, String Subject, String body, String attachment,
            LocalDate date, String type) {
        messageHeader header = new messageHeader().builder().to(to).from(from).subject(Subject).build();
        message message = new message().builder()
                .header(header)
                .messbody(messsageBody.builder().body(body).build())
                .attachment(Attachment.builder().Attachment(attachment).build())
                .date(date).type(type).build();
            // user.Sendmessage(message);
        return message;
    }
}