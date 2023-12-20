package app.mailserver.models;
import java.util.ArrayList;
import java.util.List;
// import app.mailserver.models.*;
// import org.springframework.boot.context.properties.PropertyMapper.Source;

public class UserFoldersModel {
    FolderModel inbox= new FolderModel("inbox", new ArrayList<MailModel>(0), new ArrayList<FolderModel>(0));
    FolderModel draft= new FolderModel("draft", new ArrayList<MailModel>(0), new ArrayList<FolderModel>(0));
    FolderModel starred=new FolderModel("starred", new ArrayList<MailModel>(0), new ArrayList<FolderModel>(0));
    FolderModel important=new FolderModel("important", new ArrayList<MailModel>(0), new ArrayList<FolderModel>(0));
    FolderModel sentEmails=new FolderModel("sentEmails", new ArrayList<MailModel>(0), new ArrayList<FolderModel>(0));
    FolderModel trash=new FolderModel("trash", new ArrayList<MailModel>(0), new ArrayList<FolderModel>(0));
    List<FolderModel>labels=new ArrayList<>();
    
    public UserFoldersModel(){
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
  
  public void deleteLabel(List<MailModel> emails,String from){
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
      case "sentEmails":
        return sentEmails;
    
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
}
