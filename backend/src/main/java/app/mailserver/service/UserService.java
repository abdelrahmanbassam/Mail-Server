package app.mailserver.service;

import app.mailserver.models.UserModel;

public class UserService {
   private UserModel curUser;

   public UserModel getCurUser() {
      return this.curUser;
   }

   public void setCurUser(UserModel curUser) {
      this.curUser = curUser;
   }

}
