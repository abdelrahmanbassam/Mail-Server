package app.mailserver.models;
import java.util.List; 
import java.util.Objects;

public class ContactModel {
  
    private String name;
    private List<String> emailAddresses;
    private List<String> phoneNums;
    private String importance;//we can change it to make string or what ever 
   
    public ContactModel(String name, List<String> emailAddresses, List<String> phoneNums, String importance) {
        this.name = name;
        this.emailAddresses = emailAddresses;
        this.phoneNums = phoneNums;
        this.importance = importance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<String> getPhoneNums() {
        return phoneNums;
    }

    public void setPhoneNums(List<String> phoneNums) {
        this.phoneNums = phoneNums;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public void addEmailAddress(String newAddress) {
         this.emailAddresses.add(newAddress);
    }

    public void addPhoneNum(String newPhoneNum) {
         this.phoneNums.add(newPhoneNum);
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContactModel)) {
            return false;
        }
        ContactModel contactModel = (ContactModel) o;
        return Objects.equals(name, contactModel.name) && Objects.equals(emailAddresses, contactModel.emailAddresses) && Objects.equals(phoneNums, contactModel.phoneNums) && importance == contactModel.importance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emailAddresses, phoneNums, importance);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", emailAddresses='" + getEmailAddresses() + "'" +
            ", phoneNums='" + getPhoneNums() + "'" +
            ", importance='" + getImportance() + "'" +
            "}";
    }
    
}
