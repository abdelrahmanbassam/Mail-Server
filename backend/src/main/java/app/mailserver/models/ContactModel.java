package app.mailserver.models;
import java.util.List; 

public class ContactModel {
  
    private String name;
    private List<String> emailAddresses;
    private List<String> phoneNums;
    private int importance;//we can change it to make string or what ever 
   
    public ContactModel(String name, List<String> emailAddresses, List<String> phoneNums, int importance) {
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

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public void addEmailAddress(String newAddress) {
         this.emailAddresses.add(newAddress);
    }

    public void addPhoneNum(String newPhoneNum) {
         this.phoneNums.add(newPhoneNum);
    }
}
