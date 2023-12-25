package app.mailserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.Sorting.ImportanceStrategy;
import app.mailserver.service.Sorting.DateStrategy;
import app.mailserver.service.Sorting.EmailSort;
import app.mailserver.service.Sorting.SortingStrategy;
import app.mailserver.service.SystemManagement.SystemFolders;
import app.mailserver.service.Filter.Criteria;
import app.mailserver.service.Filter.CriteriaSender;
import app.mailserver.service.Filter.CriteriaSubject;
import app.mailserver.service.Filter.EmailFilter;
import app.mailserver.service.Filter.EmailSearch;


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
    
   public List<MailModel> getEmails(String folderName,String subjectFilter,String senderFilter,String sortLogic,String searchWord){
   
         List<MailModel> folderEmails=SystemFolders.getCurUser().getFolders().findFolder(folderName).getEmails();
         
         List<MailModel> filteredEmails =EmailFilter.filterEmails(folderEmails, subjectFilter, senderFilter);
         
         filteredEmails=EmailSearch.searchEmails(filteredEmails, searchWord);

         filteredEmails=EmailSort.SortEmails(filteredEmails, sortLogic);
      
     return filteredEmails;
   }
  
}