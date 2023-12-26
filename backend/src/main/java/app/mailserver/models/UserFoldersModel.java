package app.mailserver.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
// import app.mailserver.models.*;
// import org.springframework.boot.context.properties.PropertyMapper.Source;

public class UserFoldersModel {
  private  FolderModel inbox;
  private  FolderModel draft;
  private  FolderModel starred;
  private  FolderModel important;
  private  FolderModel send;
  private  FolderModel trash;
  private  List<FolderModel>labels;
    
  public UserFoldersModel(){
      this.inbox= new FolderModel("inbox", new ArrayList<MailModel>(), new ArrayList<FolderModel>());
      this.draft= new FolderModel("draft", new ArrayList<MailModel>(), new ArrayList<FolderModel>());
      this.starred=new FolderModel("starred", new ArrayList<MailModel>(), new ArrayList<FolderModel>());
      this.important=new FolderModel("important", new ArrayList<MailModel>(), new ArrayList<FolderModel>());
      this.send=new FolderModel("send", new ArrayList<MailModel>(), new ArrayList<FolderModel>());
      this.trash=new FolderModel("trash", new ArrayList<MailModel>(), new ArrayList<FolderModel>());
      this.labels=new ArrayList<>();
      labels=new ArrayList<>();
    }
  // transfeer emalis between folders by folders name
  public void moveEmailsFromTo(List<MailModel> emails,String from,String to){
    FolderModel source=findFolder(from);
    FolderModel destination=findFolder(to);
    for(var email:emails){
      source.deleteEmail(email);
      destination.addEmail(email);
    }
  }

  //dont forget to move it to trash 
  public void deleteEmails(List<MailModel> emails,String from){
    FolderModel source=findFolder(from);
    for(var email:emails){
      trash.addEmail(email);
      source.deleteEmail(email);
    }
  
  }
  
  public void deleteLabel(String from){
    for(int i=0;i<labels.size();i++){
      if(labels.get(i).getName().equals(from)){
        labels.remove(i);
      }
    }
  }
  
  // check if the name is unique in the labels list then add it and return true
  public boolean addLabel(String LabelName){
    for(var check:labels){
      if(check.getName().equals(LabelName)){
        System.out.println("Label name is in use: "+LabelName);
        return false;
        
      }
    }
    labels.add(new FolderModel(LabelName, new ArrayList<MailModel>(0), new ArrayList<FolderModel>(0)));
   return true;
  }
  // check if the newName is unique in the labels list then rename it 
  public void renameLabel(String oldName,String newName){
    for(var check:labels){
      if(check.getName().equals(newName)){
        System.err.println("new name must be unique");
      }
    }
    for(int i=0;i<labels.size();i++){
      if(labels.get(i).getName().equals(oldName)){
        labels.get(i).SetName(newName);
        break;
      }
    }
    
  }

  public FolderModel findFolder(String folderName){
    switch (folderName) {
      case "inbox":
        return inbox;
      case "starred":
        return starred;
      case "important":
        return important;
      case "send":
        return send;
      case "draft":
        return draft;
      case "trash":
        return trash;
      default:
        break;
    }
    for(var x: labels){
      if(x.getName().equals(folderName)){
        return x;
      }
    }
    return null;
  }
  
  public void addEmailTo(String folderName,MailModel newEmail){
    findFolder(folderName).addEmail(newEmail);
  }

  public UserFoldersModel(FolderModel inbox, FolderModel draft, FolderModel starred, FolderModel important, FolderModel send, FolderModel trash, List<FolderModel> labels) {
    this.inbox = inbox;
    this.draft = draft;
    this.starred = starred;
    this.important = important;
    this.send = send;
    this.trash = trash;
    this.labels = labels;
  }

  public FolderModel getInbox() {
    return this.inbox;
  }

  public void setInbox(FolderModel inbox) {
    this.inbox = inbox;
  }

  public FolderModel getDraft() {
    return this.draft;
  }

  public void setDraft(FolderModel draft) {
    this.draft = draft;
  }

  public FolderModel getStarred() {
    return this.starred;
  }

  public void setStarred(FolderModel starred) {
    this.starred = starred;
  }

  public FolderModel getImportant() {
    return this.important;
  }

  public void setImportant(FolderModel important) {
    this.important = important;
  }

  public FolderModel getSend() {
    return this.send;
  }

  public void setSend(FolderModel send) {
    this.send = send;
  }

  public FolderModel getTrash() {
    return this.trash;
  }

  public void setTrash(FolderModel trash) {
    this.trash = trash;
  }

  public List<FolderModel> getLabels() {
    return this.labels;
  }

  public void setLabels(List<FolderModel> labels) {
    this.labels = labels;
  }
  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserFoldersModel)) {
            return false;
        }
        UserFoldersModel userFoldersModel = (UserFoldersModel) o;
        return Objects.equals(inbox, userFoldersModel.inbox) && Objects.equals(draft, userFoldersModel.draft) && Objects.equals(starred, userFoldersModel.starred) && Objects.equals(important, userFoldersModel.important) && Objects.equals(send, userFoldersModel.send) && Objects.equals(trash, userFoldersModel.trash) && Objects.equals(labels, userFoldersModel.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inbox, draft, starred, important, send, trash, labels);
  }

  @Override
  public String toString() {
    return "{" +
      " inbox='" + getInbox() + "'" +
      ", draft='" + getDraft() + "'" +
      ", starred='" + getStarred() + "'" +
      ", important='" + getImportant() + "'" +
      ", send='" + getSend() + "'" +
      ", trash='" + getTrash() + "'" +
      ", labels='" + getLabels() + "'" +
      "}";
  }
  
}
