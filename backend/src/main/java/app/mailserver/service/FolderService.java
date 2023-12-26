package app.mailserver.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.mailserver.models.FolderModel;
import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.Sorting.EmailSort;
import app.mailserver.service.SystemManagement.SystemFolders;
import app.mailserver.service.Filter.EmailFilter;
import app.mailserver.service.Filter.EmailSearch;


@Service
public class FolderService {
     
    public Map<String, List<String>> addLabel(String labelName){
       UserModel curUserModel=SystemFolders.getCurUser();
       curUserModel.getFolders().addLabel(labelName);

       SystemFolders.updateUser(curUserModel);
       return getlabelsNames(curUserModel.getFolders().getLabels());
    } 
    
    public Map<String, List<String>> renameLabel(String oldName,String newName){
       UserModel curUserModel=SystemFolders.getCurUser();
       curUserModel.getFolders().renameLabel(oldName, newName);
       SystemFolders.updateUser(curUserModel);
       return getlabelsNames(curUserModel.getFolders().getLabels());
    }
    
    public Map<String, List<String>> deleteLabel(String labelName){
       UserModel curUserModel=SystemFolders.getCurUser();
       curUserModel.getFolders().deleteLabel(labelName);
       SystemFolders.updateUser(curUserModel);
       return getlabelsNames(curUserModel.getFolders().getLabels());
    } 
   
    public List<MailModel> deleteEmails(List<MailModel> emails,String from){
       
      UserModel curUserModel=SystemFolders.getCurUser();
      curUserModel.getFolders().deleteEmails(emails,from);
      SystemFolders.updateUser(curUserModel);
      return curUserModel.getFolders().findFolder(from).getEmails();
    } 
    
    public List<MailModel> moveEmailsFromTo(List<MailModel> emails,String from,String to){
      UserModel curUserModel=SystemFolders.getCurUser();
      curUserModel.getFolders().moveEmailsFromTo(emails, from, to);
      SystemFolders.updateUser(curUserModel);
      return curUserModel.getFolders().findFolder(from).getEmails();
    }
    
    public List<MailModel> filterEmails(String folderName,String subjectFilter,String senderFilter,String sortLogic,String searchWord){
   
         List<MailModel> folderEmails=SystemFolders.getCurUser().getFolders().findFolder(folderName).getEmails();
         System.out.println("we are here");
         List<MailModel> filteredEmails =EmailFilter.filterEmails(folderEmails, subjectFilter, senderFilter);
         
         filteredEmails=EmailSearch.searchEmails(filteredEmails, searchWord);

         filteredEmails=EmailSort.SortEmails(filteredEmails, sortLogic);
      
     return filteredEmails;
   }
   
    public List<MailModel> getEmails(String folderName){
      return SystemFolders.getCurUser().getFolders().findFolder(folderName).getEmails();
   }
   
   public Map<String, List<String>> getlabelsNames(List<FolderModel> labels) {
      Map<String, List<String>> labelsNames = new HashMap<>();
      List<String> namesList = new ArrayList<>();
      
      for (var x : labels) {
          namesList.add(x.getName());
      }
      labelsNames.put("labelsNames", namesList);
      
      return labelsNames;
  }
  
}