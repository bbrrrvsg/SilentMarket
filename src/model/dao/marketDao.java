package model.dao;

public class marketDao {

    private marketDao(){}
    private static final marketDao instance = new marketDao();
    public marketDao getInstance(){
        return instance;
    }


}
