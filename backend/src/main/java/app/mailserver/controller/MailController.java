package app.mailserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.mailserver.models.MailModel;
import app.mailserver.models.UserModel;
import app.mailserver.service.MailService;

@RestController
@CrossOrigin
@RequestMapping
public class MailController {
     @Autowired
    private MailService mailService;

    @PostMapping("/sendEmail")
    public UserModel sendEmail(@RequestBody MailModel newEmail) {
        return mailService.sendEmail(newEmail);
        
    }
    
    @PostMapping("/toDraft")
    public UserModel draft(@RequestBody MailModel newEmail) {
        return mailService.addToDraft(newEmail);
        
    }
}
