package app.mailserver.models;
import java.util.Objects;

public class AttachmentModel {
    private String name;
    private String type;
    private String url;

    public AttachmentModel() {
    }

    public AttachmentModel(String name, String type, String url) {
        this.name = name;
        this.type = type;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AttachmentModel name(String name) {
        setName(name);
        return this;
    }

    public AttachmentModel type(String type) {
        setType(type);
        return this;
    }

    public AttachmentModel url(String url) {
        setUrl(url);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AttachmentModel)) {
            return false;
        }
        AttachmentModel attachmentModel = (AttachmentModel) o;
        return Objects.equals(name, attachmentModel.name) && Objects.equals(type, attachmentModel.type) && Objects.equals(url, attachmentModel.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, url);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }
  
    
}
