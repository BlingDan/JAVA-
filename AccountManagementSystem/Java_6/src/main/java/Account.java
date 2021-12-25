public abstract class Account {
    private
    String id;	//帐号
    double balance;	//余额
    static double total = 0; //所有账户的总金额
    protected
        //供派生类调用的构造函数，id为账户
    Account(final Date date, final String id) {
        this.id = id;
        this.balance = 0;
        date.show();
        System.out.println("\t#" + id + " created");
    }
    //记录一笔帐，date为日期，amount为金额，desc为说明
    void record(final Date date, double amount, final String desc) {
        amount = (amount * 100 + 0.5) / 100;	//保留小数点后两位
        balance += amount;
        total += amount;
        date.show();
        System.out.printf("\t#%s\t%.2f\t%f\t%s\n", id, amount, balance, desc);
    }
    //报告错误信息
    final void error(String msg) {
        System.out.println("Error(#" + id + "): " + msg);
    }
    public
    final String getId() { return id; }
    double getBalance()  { return balance; }
    static double getTotal() { return total; }
    //存入现金，date为日期，amount为金额，desc为款项说明
    abstract void deposit(final Date date, double amount, final String desc);
    //取出现金，date为日期，amount为金额，desc为款项说明
    abstract void withdraw(final Date date, double amount,final String desc);
    //结算（计算利息、年费等），每月结算一次，date为结算日期
    abstract void settle(final Date date);
    //显示账户信息
    void show() {
        System.out.print(id + "\tBalance: " + balance);
    } // virtual
}
