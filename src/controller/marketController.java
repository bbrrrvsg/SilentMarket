package controller;

public class marketController {

    private marketController(){}
    private static final marketController instance = new marketController();
    public marketController getInstance(){
        return instance;
    }



}
