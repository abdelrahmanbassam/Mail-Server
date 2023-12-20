package app.mailserver.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MailModel {
    private String Sender = new String();
    private String Reciver = new String();
    private String Subject = new String();
    private String Body = new String();
    private byte[] Attachment;
    private int importance;

    public String getSender() {
        return this.Sender;
    }

    public void setSender(String Sender) {
        this.Sender = Sender;
    }

    public String getReciver() {
        return this.Reciver;
    }

    public void setReciver(String Reciver) {
        this.Reciver = Reciver;
    }

    public String getSubject() {
        return this.Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getBody() {
        return this.Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }

    public byte[] getAttachment() {
        return this.Attachment;
    }

    public void setAttachment(byte[] Attachment) {
        this.Attachment = Attachment;
    }

    public int getImportance() {
        return this.importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public byte[] addAttachment(Path path) throws IOException {
        byte[] file = Files.readAllBytes(path);
        return file;
    }

}