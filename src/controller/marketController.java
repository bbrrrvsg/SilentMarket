package controller;

import model.dao.marketDao;
import model.dto.marketDto;

import java.util.ArrayList;

public class marketController {

    private marketController(){}
    private static final marketController instance = new marketController();
    public static marketController getInstance(){
        return instance;
    }

    private marketDao md = marketDao.getInstance();


    //등록
    public boolean add(String nick, String pname ,String pcommnet, int price, String pwd,String pnumber){
        boolean result = md.add(nick,pname,pcommnet,price,pwd,pnumber);
        return result;
    }

    //조회
    public ArrayList<marketDto>findAll(){
        ArrayList<marketDto>pd=md.findAll();
        return pd;
    }

    //수정
    public boolean update(int pid, String pwd, String pname, String pcomment, int price,String pnumber){
        boolean result = md.update(pid, pwd, pname, pcomment, price,pnumber);
        return result;
    }
    //삭제
    public boolean delete(int pid,String pwd){
        boolean result = md.delete(pid,pwd);
        return result;
    }



} // class end

