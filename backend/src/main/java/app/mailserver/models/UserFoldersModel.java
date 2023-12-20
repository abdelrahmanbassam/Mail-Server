package app.mailserver.models;
import java.util.List;

public class UserFoldersModel {
    FolderModel inbox;
    FolderModel sentEmails;
    FolderModel trash;
    FolderModel favorites;
    List<FolderModel>labels;

  // transfeer emalis between folders by folders name
  public void moveEmailsFromTo(List<MailModel> emails,String from,String to){

  }
  
  public void deleteLabel(List<MailModel> emails,String from,String to){

  }
  
  public boolean addLabel(String LabelName){
    // check if the name in unique in the labels list then add it and return true
   return true;
  }

  public void renameLabel(String oldName,String newName){
     // check if the newName in unique in the labels list then rename it 
  }

}
