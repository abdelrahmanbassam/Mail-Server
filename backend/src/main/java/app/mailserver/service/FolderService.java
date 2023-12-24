package app.mailserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.SystemManagement.SystemFolders;


@Service
public class FolderService {
     
    public UserModel addLabel(String labelName){
       UserModel curUserModel=SystemFolders.getCurUser();
       curUserModel.getFolders().addLabel(labelName);
       SystemFolders.updateUser(curUserModel);
       return curUserModel;
    } 
    
    public UserModel renameLabel(String oldName,String newName){
       UserModel curUserModel=SystemFolders.getCurUser();
       curUserModel.getFolders().renameLabel(oldName, newName);
       SystemFolders.updateUser(curUserModel);
       return curUserModel;
    }
    
    public UserModel deleteLabel(String labelName){
       UserModel curUserModel=SystemFolders.getCurUser();
       curUserModel.getFolders().deleteLabel(labelName);
       SystemFolders.updateUser(curUserModel);
       return curUserModel;
    } 
   
    public UserModel deleteEmails(List<MailModel> emails,String from){
       
        UserModel curUserModel=SystemFolders.getCurUser();
       curUserModel.getFolders().deleteEmails(emails,from);
       SystemFolders.updateUser(curUserModel);
       return curUserModel;
    } 
    
    public UserModel moveEmailsFromTo(List<MailModel> emails,String from,String to){
       UserModel curUserModel=SystemFolders.getCurUser();
       curUserModel.getFolders().moveEmailsFromTo(emails, from, to);
       SystemFolders.updateUser(curUserModel);
       return curUserModel;
    }
    
    // public UserModel sortFolder(String FolderName,String sortLogic){
    // }

    // public UserModel filterFolder(String FolderName,String filterLogic){
    // }

    // public UserModel searchFolder(String FolderName,String searchLogic){
    // }
}