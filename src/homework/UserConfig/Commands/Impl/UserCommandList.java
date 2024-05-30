package homework.UserConfig.Commands.Impl;

import homework.UserConfig.Commands.UserComm;
import homework.UserConfig.User;

public class UserCommandList implements UserComm {
    User user;
    public void create(String name) {
        this.user = new User(name);
    }
    public void save(){
        System.out.println("Save user: " + user.getName());
    }

    public void report(){
        System.out.println("Report for user: " + user.getName());
    }
}
