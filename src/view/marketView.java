package view;

public class marketView {

    private marketView(){}
    private static final marketView instance = new marketView();
    public marketView getInstance(){
        return instance;
    }


}
