package app.mailserver.service;

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

    private String from = new String();
    private String to = new String();
    private String Subject = new String();

    public messageHeader(String to, String from, String subject) {
        this.to = to;
        this.from = from;
        this.Subject = subject;
    }

    public messageHeader() {
    }
    public String getFrom() {
        return this.from;
    }

    public String getTo() {
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
    private messsageBody messbody = new messsageBody();
    private messageHeader header = new messageHeader();
    private Attachment attachment = new Attachment();

    public message(messageHeader header, messsageBody messbody, Attachment attachment) {
        this.messbody = messbody;
        this.header = header;
        this.attachment = attachment;
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

public class EmailFacade {
    // the user class to make requests to send emails and the security class are
    // needed
    public void CreateMessage(String to, String from, String Subject, String body, String Attachment) {
        messsageBody mbody = new messsageBody(body);
        messageHeader mHeader = new messageHeader(to, from, Subject);
        Attachment mAttachment = new Attachment(Attachment);
        message message = new message(mHeader, mbody, mAttachment);
        // user.Sendmessage(message);

    }

}
