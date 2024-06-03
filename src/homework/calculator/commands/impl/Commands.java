package homework.calculator.commands.impl;

import homework.calculator.Numbers;
import homework.calculator.commands.Comms;
import homework.calculator.dao.impl.FileOperation;

public class Commands implements Comms {
    private final Numbers num;
    FileOperation fileOperation;
    public Commands(Numbers numbers) {
        this.num = numbers;
    }

    public void save() {
        fileOperation.saveLog(num.toString());
    }

    @Override
    public void plus() {
        System.out.println((num.Geta() + num.Getb()) + " + " + (num.Getai() + num.Getbi()) + "i");
        //fileOperation.saveLog(String.format("%s + %si", num.Geta() + num.Getb(), num.Getai() + num.Getbi()));
    }

    @Override
    public void minus() {
        System.out.println((num.Geta() - num.Getb()) + " + " + (num.Getai() - num.Getbi()) + "i");
        //fileOperation.saveLog(String.format("%s + %si", num.Geta() - num.Getb(), num.Getai() - num.Getbi()));
    }

    @Override
    public void multiply() {
        System.out.println((num.Geta() * num.Getb() - num.Getai() * num.Getbi()) + " + " + (num.Geta() * num.Getbi() + num.Getai() * num.Getb()) + "i");
        //fileOperation.saveLog(String.format("%s + %si",num.Geta() * num.Getb() - num.Getai() * num.Getbi() ,num.Geta() * num.Getbi() + num.Getai() * num.Getb()));
    }

    @Override
    public void divide() {
        System.out.println(((num.Geta() * num.Getb() + num.Getai() * num.Getbi()) / (num.Getb() * num.Getb() + num.Getbi() * num.Getbi())) +
                " + " + ((num.Getb() * num.Getai() - num.Geta() * num.Getbi()) / (num.Getb() * num.Getb() + num.Getbi() * num.Getbi())) + "i");
        //fileOperation.saveLog(String.format("%s + %si",(num.Geta() * num.Getb() + num.Getai() * num.Getbi()) / (num.Getb() * num.Getb() + num.Getbi() * num.Getbi()),
        //        ((num.Getb() * num.Getai() - num.Geta() * num.Getbi()) / (num.Getb() * num.Getb() + num.Getbi() * num.Getbi()))));
    }
}
