package homework;

import homework.UserConfig.Commands.Impl.UserCommandList;

public class Main{
    public static void main(String[] args){
        UserCommandList user = new UserCommandList();
        user.create("A");
        user.report();
        user.save();
    }
}