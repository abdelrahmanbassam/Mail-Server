package app.mailserver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.mailserver.models.MailModel;
import app.mailserver.models.RequestObject;
import app.mailserver.models.UserModel;
import app.mailserver.service.FolderService;

@RestController
@CrossOrigin
@RequestMapping
public class FolderController {
    @Autowired
    private FolderService folderService;
    @Autowired
    private ObjectMapper objectMapper;
 

    @PostMapping("/addLabel")
    public UserModel addLabel(@RequestBody RequestObject params) {
        
        return folderService.addLabel((String)params.get("labelName"));
    }

    @PostMapping("/getEmails")
    public List<MailModel> getEmails(@RequestBody RequestObject params) {
        
        return folderService.getEmails((String)params.get("folderName") , (String)params.get("subjectFilter"),(String)params.get("senderFilter") , (String)params.get("sort"),(String)params.get("search"));
    }

    @PostMapping("/renameLabel")
    public UserModel renameLabel(@RequestBody RequestObject params) {
        return folderService.renameLabel((String)params.get("oldName"), (String)params.get("newName"));
    }

    @DeleteMapping("/deleteLabel")
    public UserModel deleteLabel(@RequestBody RequestObject params) {
        return folderService.deleteLabel((String)params.get("labelName"));
    }

    @DeleteMapping("/deleteEmails")
    public UserModel deleteEmails(@RequestBody RequestObject params) {

        return folderService.deleteEmails(toEmailList(params), (String)params.get("from"));
    }

    @PostMapping("/moveEmails")
    public UserModel moveEmailsFromTo(@RequestBody RequestObject params) {
        return folderService.moveEmailsFromTo(toEmailList(params), (String)params.get("from"), (String)params.get("to"));
    }

    // @PostMapping("/sortFolder")
    // public List<MailModel> sortEmails(@RequestBody RequestObject params) {

    //     return folderService.sortEmails((String)params.get("from"), (String)params.get("sortLogic"));
    // }

    // @GetMapping("/filterFolder")
    // public UserModel filterFolder(@RequestParam String folderName, @RequestParam String filterLogic) {
    //     // implementation
    // }

    // @GetMapping("/searchFolder")
    // public UserModel searchFolder(@RequestParam String folderName, @RequestParam String searchLogic) {
    //     // implementation
    // }
    public List<MailModel> toEmailList(RequestObject params)throws RuntimeException{
        List<Map<String, Object>> emailsParams = (List<Map<String, Object>>) params.get("emails");
        List<MailModel> emails = new ArrayList<MailModel>();
        for (var x:emailsParams){
          emails.add(objectMapper.convertValue(x, MailModel.class));
        }
        return emails;
    }
}