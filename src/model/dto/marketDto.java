package model.dto;

public class marketDto {
    private int pid;          // auto_increment PK
    private String nick;
    private String pname;
    private String pcomment;
    private int price;
    private String pwd;
    private String pnumber;
    private String state;
    private String pdate;

    public marketDto() {}

    public marketDto(int pid, String nick, String pname, String pcomment, int price, String pwd, String pnumber, String state,String pdate) {
        this.pid = pid;
        this.nick = nick;
        this.pname = pname;
        this.pcomment = pcomment;
        this.price = price;
        this.pwd = pwd;
        this.pnumber = pnumber;
        this.state = state;
        this.pdate = pdate;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcomment() {
        return pcomment;
    }

    public void setPcomment(String pcomment) {
        this.pcomment = pcomment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    @Override
    public String toString() {
        return "marketDto{" +
                "pid=" + pid +
                ", nick='" + nick + '\'' +
                ", pname='" + pname + '\'' +
                ", pcomment='" + pcomment + '\'' +
                ", price=" + price +
                ", pwd='" + pwd + '\'' +
                ", pnumber='" + pnumber + '\'' +
                ", state='" + state + '\'' +
                ", pdate='" + pdate + '\'' +
                '}';
    }
}
