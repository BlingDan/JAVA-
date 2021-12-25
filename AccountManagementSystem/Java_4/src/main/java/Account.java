public class Account {
    private
    String id;	//帐号
    double balance;	//余额
    static double total; //所有账户的总金额
    protected
    //供派生类调用的构造函数，id为账户
    Account(Date date, String id){
        this.id = id;
        this.balance = 0;
        date.show();
    }
    //记录一笔帐，date为日期，amount为金额，desc为说明
    void record( Date date, double amount, String desc){
        amount = (amount * 100 + 0.5) / 100;	//保留小数点后两位
        balance += amount;
        total += amount;


        date.show();
        System.out.printf("\t#%s\t%.2f\t%f\t%s\n", id, amount, balance, desc);
    }
    //报告错误信息
    void error(String msg) {
        System.out.println("Error(#" + id + "): " + msg);
    }
    public
    String getId()  { return id; }
    double getBalance()  { return balance; }
    static double getTotal() { return total; }
    //显示账户信息
    void show(){
        System.out.print(id + "\tBalance: " + balance);
    }
}
