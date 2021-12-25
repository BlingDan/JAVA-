public class SavingsAccount {
    private
    String id;		//帐号
    double balance;		//余额
    double rate;		//存款的年利率
    Date lastDate;		//上次变更余额的时期
    double accumulation;	//余额按日累加之和
    static double total;	//所有账户的总金额

    //记录一笔帐，date为日期，amount为金额，desc为说明
    void record(Date date, double amount, String desc) {
        accumulation = accumulate(date);
        lastDate = date;
        amount = (amount * 100 + 0.5) / 100;	//保留小数点后两位
        balance += amount;
        total += amount;
        date.show();
        System.out.print("\t#" + id + "\t" + amount + "\t" + balance + "\t" + desc + "\n");
    }
    //报告错误信息
    void error(String msg) {
        System.out.print("Error(#" + id + "): " + msg + "\n");
    }
    //获得到指定日期为止的存款金额按日累积值
    double accumulate(Date date)  {
        return accumulation + balance * date.distance(lastDate);
    }

    public
    //构造函数
    SavingsAccount( Date date, String id, double rate) {
        this.id = id;
        this.balance = 0;
        this.rate = rate;
        this.lastDate = date;
        this.accumulation = 0;
        date.show();
        System.out.print("\t#" +id + " created" + "\n");
    }
    String getId() { return id; }
    double getBalance() { return balance; }
    double getRate() { return rate; }
    static double getTotal() { return total; }

    void deposit(Date date, double amount, String desc) {
        record(date, amount, desc);
    }
    //取出现金
    void withdraw(Date date, double amount, String desc){
        if (amount > getBalance())
            error("not enough money");
        else
            record(date, -amount, desc);
    }
    //结算利息，每年1月1日调用一次该函数
    void settle(Date date){
        Date tmp = new Date(date.getYear() - 1, 1, 1);
        double interest = accumulate(date) * rate	//计算年息
                / date.distance(tmp);
        if (interest != 0)
            record(date, interest, "interest");
        accumulation = 0;
    }
    //显示账户信息
    void show() {
        System.out.print(id + "\tBalance: " + balance);
    }
}
