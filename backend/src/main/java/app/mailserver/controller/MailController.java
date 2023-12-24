package app.mailserver.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.mailserver.models.MailModel;
import app.mailserver.models.RequestObject;
import app.mailserver.models.UserModel;
import app.mailserver.service.MailService;

@RestController
@CrossOrigin
@RequestMapping
public class MailController {
    @Autowired
    private MailService mailService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/sendEmail")
    public UserModel sendEmail(@RequestBody RequestObject params) {
        
       Map<String, Object> emailParams = (Map<String, Object>) params.getByKey("email");
       MailModel newEmail = objectMapper.convertValue(emailParams, MailModel.class);

      newEmail.setnewDate();

      return mailService.sendEmail(newEmail);
        
    }
    

    @PostMapping("/toDraft")
    public UserModel draft(@RequestBody RequestObject params) {

       Map<String, Object> emailParams = (Map<String, Object>) params.getByKey("email");
       MailModel newEmail = objectMapper.convertValue(emailParams, MailModel.class);
       
      newEmail.setnewDate();

      return mailService.addToDraft(newEmail);
        
    }
}
