package app.mailserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import app.mailserver.models.UserModel;
import app.mailserver.models.RequestObject;
import app.mailserver.service.UserService;


@RestController
@CrossOrigin
@RequestMapping
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserModel login(@RequestBody RequestObject params) {

        // return userService.login(requestUser.emailAddress, requestUser.password);
        return userService.login((String)params.getByKey("emailAddress"),(String)params.getByKey("password"));

    }

    @PostMapping("/signUp")
    public UserModel signUp(@RequestBody RequestObject params) {

        return userService.signUp((String)params.getByKey("userName"), (String)params.getByKey("emailAddress"),(String)params.getByKey("password"));
    }
    
}
