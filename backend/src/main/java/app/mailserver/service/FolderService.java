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
import app.mailserver.service.SystemManagement.SystemManager;
import app.mailserver.service.Filter.EmailFilter;
import app.mailserver.service.Filter.EmailSearch;


@Service
public class FolderService {
   private SystemManager systemManager; // Field to store the singleton instance

   public FolderService() {
       this.systemManager = SystemManager.getInstance(); // Initialize the singleton instance
   }
  
    public Map<String, List<String>> addLabel(String labelName){
       UserModel curUserModel=systemManager.getCurUser();
       curUserModel.getFolders().addLabel(labelName);

       systemManager.updateUser(curUserModel);
       return getlabelsNames();
    } 
    
    public Map<String, List<String>> renameLabel(String oldName,String newName){
       UserModel curUserModel=systemManager.getCurUser();
       curUserModel.getFolders().renameLabel(oldName, newName);
       systemManager.updateUser(curUserModel);
       return getlabelsNames();
    }
    
    public Map<String, List<String>> deleteLabel(String labelName){
       UserModel curUserModel=systemManager.getCurUser();
       curUserModel.getFolders().deleteLabel(labelName);
       systemManager.updateUser(curUserModel);
       return getlabelsNames();
    } 
   
    public List<MailModel> deleteEmails(List<MailModel> emails,String from){
       
      UserModel curUserModel=systemManager.getCurUser();
      curUserModel.getFolders().deleteEmails(emails,from);
      systemManager.updateUser(curUserModel);
      return curUserModel.getFolders().findFolder(from).getEmails();
    } 
    
    public List<MailModel> moveEmailsFromTo(List<MailModel> emails,String from,String to){
      UserModel curUserModel=systemManager.getCurUser();
      curUserModel.getFolders().moveEmailsFromTo(emails, from, to);
      systemManager.updateUser(curUserModel);
      return curUserModel.getFolders().findFolder(from).getEmails();
    }
    
    public List<MailModel> filterEmails(String folderName,String subjectFilter,String senderFilter,String sortLogic,String searchWord){
   
         List<MailModel> folderEmails=systemManager.getCurUser().getFolders().findFolder(folderName).getEmails();
        
         List<MailModel> filteredEmails =EmailFilter.filterEmails(folderEmails, subjectFilter, senderFilter);
         
         filteredEmails=EmailSearch.searchEmails(filteredEmails, searchWord);

         filteredEmails=EmailSort.SortEmails(filteredEmails, sortLogic);
      
     return filteredEmails;
   }
   
    public List<MailModel> getEmails(String folderName){
      return systemManager.getCurUser().getFolders().findFolder(folderName).getEmails();
   }
   
   public Map<String, List<String>> getlabelsNames() {
      List<FolderModel> labels=systemManager.getCurUser().getFolders().getLabels();
      Map<String, List<String>> labelsNames = new HashMap<>();
      List<String> namesList = new ArrayList<>();
      
      for (var x : labels) {
          namesList.add(x.getName());
      }
      labelsNames.put("labelsNames", namesList);
      
      return labelsNames;
  }
  
}