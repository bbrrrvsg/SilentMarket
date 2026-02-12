package view;

import controller.marketController;
import model.dto.marketDto;

import java.util.ArrayList;
import java.util.Scanner;

public class marketView {

    private marketView(){}
    private static final marketView instance = new marketView();
    public static marketView getInstance(){
        return instance;
    }
    private marketController mc = marketController.getInstance();



    private Scanner scan = new Scanner(System.in);

    public void index(){

        for(;;){
            System.out.print("1.등록 2.조회 3.수정 4.삭제  선택 >");int ch = scan.nextInt();
            if(ch==1){add();}
            else if(ch==2){findAll();}
            else if(ch==3){update();}
            else if(ch==4){delete();}
            else{
                System.out.println(" 다시 ");
            }

        }
    } //  m end

    public void add(){
        scan.nextLine();
        System.out.print("닉네임 : "); String nick = scan.nextLine();
        System.out.print("물품명 : "); String pname = scan.nextLine();
        System.out.print("설명 : "); String pcommnet = scan.nextLine();
        System.out.print("가격 : "); int price = scan.nextInt(); scan.nextLine();
        System.out.print("비밀번호 : "); String pwd = scan.nextLine();
        System.out.print("연락처 : "); String pnumber = scan.nextLine();

        boolean result = mc.add(nick,pname,pcommnet,price,pwd,pnumber);

        if(result){
            System.out.println("등록 성공");
        }
        else {
            System.out.println("등록 실패");
        }
    }//m end



    public void findAll(){
        ArrayList<marketDto>pd = mc.findAll();
        for(marketDto md : pd){
            System.out.printf(
                    "번호 : %d , 작성자 : %s , 상품명 : %s , 가격 : %d , 상태 : %s , 연락처 : %s , 내용 : %s , 등록일 : %s \n",
                    md.getPid(),
                    md.getNick(),
                    md.getPname(),
                    md.getPrice(),
                    md.getState(),
                    md.getPnumber(),
                    md.getPcomment(),
                    md.getPdate()
            );
        }

    }// m end

    public void update(){

        System.out.print("수정할 게시물 번호 : ");
        int pid = scan.nextInt(); scan.nextLine();

        System.out.print("비밀번호 : ");
        String pwd = scan.nextLine();

        System.out.print("새 상품명 : ");
        String pname = scan.nextLine();

        System.out.print("새 설명 : ");
        String pcomment = scan.nextLine();

        System.out.print("새 가격 : ");
        int price = scan.nextInt(); scan.nextLine();

        System.out.print("새 연락쳐 : ");
        String pnumber = scan.nextLine();

        boolean result = mc.update(pid, pwd, pname, pcomment, price,pnumber);

        if(result){
            System.out.println("수정 성공");
        }else{
            System.out.println("번호가 없거나 비밀번호가 틀렸습니다.");
        }
    }// m end

    public void delete(){
        scan.nextLine();
        System.out.print("삭제할게시물번호 : ");int pid = scan.nextInt();scan.nextLine();
        System.out.print("비밀번호 : ");String pwd = scan.nextLine();
        boolean result = mc.delete(pid,pwd);

        if(result){
            System.out.println("삭제 성공");
        }
        else{
            System.out.println("번호가 없거나 비밀번호가 틀렸습니다.");
        }

    }// m end


} // class end
