package model.dao;

import model.dto.marketDto;

import java.sql.*;
import java.util.ArrayList;

public class marketDao {

    private marketDao(){connect();}
    private static final marketDao instance = new marketDao();
    public static marketDao getInstance(){return instance;}


    //db
    private String url ="jdbc:mysql://localhost:3306/market";
    private String user ="root";
    private String password ="1234";
    Connection conn;

    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연동 성공");
        }catch (Exception e){
            System.out.println("데이터베이스 연동 실패");
        }

    }


    // 등록
    public boolean add(String nick, String pname ,String pcommnet, int price, String pwd,String pnumber){
        try{
            String sql ="INSERT INTO product (nick, pname, pcomment, price, pwd, pnumber) VALUES\n" +
                    "(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,nick);
            ps.setString(2,pname);
            ps.setString(3,pcommnet);
            ps.setInt(4,price);
            ps.setString(5,pwd);
            ps.setString(6,pnumber);

            int count = ps.executeUpdate();

            if(count==1){return true;}
            else{return false;}


        }catch (SQLException e){
            System.out.println("sql 문법 오류 ");
        }
        return false;
    } // m end

    //조회
    public ArrayList<marketDto>findAll(){
        ArrayList<marketDto>pd = new ArrayList<>();

        try{
            String sql ="select*from product";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int pid = rs.getInt("pid");
                String nick = rs.getString("nick");
                String pname = rs.getString("pname");
                String pcomment = rs.getString("pcomment");
                int price = rs.getInt("price");
                String pwd = rs.getString("pwd");
                String pnumber = rs.getString("pnumber");
                String state = rs.getString("state");
                String pdate = rs.getString("pdate");

                marketDto marketdto = new marketDto(pid,nick,pname,pcomment,price,pwd,pnumber,state,pdate);

                pd.add(marketdto);

            }
        }catch (SQLException e){
            System.out.println("sql 문법 오류 "+e);
        }
        return pd;
    }// m end

    //수정
    public boolean update(int pid, String pwd, String pname, String pcomment, int price,String pnumber){
        try{
            String sql = "UPDATE product SET pname=?, pcomment=?, price=?, pnumber=? WHERE pid=? AND pwd=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pname);
            ps.setString(2, pcomment);
            ps.setInt(3, price);
            ps.setString(4, pnumber);
            ps.setInt(5, pid);
            ps.setString(6, pwd);

            int count = ps.executeUpdate();

            if(count==1){return true;}
        }catch (SQLException e){
            System.out.println("sql 문법 오류");
        }
        return false;

    }//m end

    //삭제
    public boolean delete(int pid, String pwd){
        try{
            String sql ="delete from product where pid=? and pwd=?";
            PreparedStatement ps =conn.prepareStatement(sql);

            ps.setInt(1,pid);
            ps.setString(2,pwd);

            int count =ps.executeUpdate();

            if(count==1){return true;}
            else{return false;}

        }catch (SQLException e){
            System.out.println("sql 문법 오류");
        }
        return false;
    }








}// class end
