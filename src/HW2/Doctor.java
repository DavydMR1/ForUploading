package HW2;

public class Doctor {
    protected Success success;
    public String DoCheckup() {
        success = new Success(8);
        String printer;
        if (success.finalrate == 0) {printer = "You didn't get any help";}
        else if (success.finalrate < 5) {printer = "You didn't get any useful information";}
        else if (success.finalrate < 8) {printer = "you got help";}
        else {printer = "you got great help";}
        return printer;
    }
}
