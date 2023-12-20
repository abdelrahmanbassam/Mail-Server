package app.mailserver.models;
import java.util.List;

public class UserFoldersModel {
    FolderModel inbox;
    FolderModel starred;
    FolderModel important;
    FolderModel sentEmails;
    FolderModel trash;
    List<FolderModel>labels;

  // transfeer emalis between folders by folders name
  public void moveEmailsFromTo(List<MailModel> emails,String from,String to){
  
  }

  //dont forget to move it to trash 
  public void deleteEmails(List<MailModel> emails,String from){
  
  }
  
  public void deleteLabel(List<MailModel> emails,String from,String to){

  }
  
  // check if the name is unique in the labels list then add it and return true
  public boolean addLabel(String LabelName){
   return true;
  }

  // check if the newName is unique in the labels list then rename it 
  public void renameLabel(String oldName,String newName){
    
  }

}
