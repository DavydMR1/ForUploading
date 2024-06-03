package homework;

import homework.calculator.dao.impl.FileOperation;
import homework.userview.UserView;

import static homework.util.LogConnector.Log_PATH;
import static homework.util.LogConnector.createlogfile;

public class Main{
    public static void main(String[] args){
        createlogfile();
        FileOperation fileOperation = new FileOperation(Log_PATH);
        UserView begin = new UserView();
        begin.run();
    }
}