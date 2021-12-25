package core;

public class Account{ //储蓄账户类
    private
    int id;				//账号
    double balance;		//余额
    double rate;		//存款的年利率
    int lastDate;		//上次变更余额的时期
    double accumulation;	//余额按日累加之和
    static double total;	//所有账户的总金额

    //记录一笔帐，date为日期，amount为金额，desc为说明
    void record(int date, double amount)
    {
        accumulation = accumulate(date);
        lastDate = date;
        amount = (amount * 100 + 0.5) / 100;	//保留小数点后两位
        balance += amount;
        total += amount;
        System.out.printf("%d\t#%d\t%.2f\t%f\n", date, id, amount, balance);
    }
    //获得到指定日期为止的存款金额按日累积值
    double accumulate(int date) {
        return accumulation + balance * (date - lastDate);
    }

    public
        //构造函数
    Account(int date, int id, double rate)
    {
        lastDate = date;
        this.id = id;
        this.rate = rate;
    }
    int getId()  { return id; }
    double getBalance()  { return balance; }
    double getRate()  { return rate; }
    static double getTotal() { return total; }

    //存入现金
    void deposit(int date, double amount)
    {
        record(date, amount);
    }
    //取出现金
    void withdraw(int date, double amount)
    {
        if (amount > getBalance())
            System.out.println("Error: not enough money\n");
        else
            record(date, -amount);
    }
    //结算利息，每年1月1日调用一次该函数
    void settle(int date)
    {
        double interest = accumulate(date) * rate / 365;	//计算年息
        if (interest != 0)
            record(date, interest);
        accumulation = 0;
    }
    //显示账户信息
    void show()
    {
        System.out.printf("#%d\tBalance: %f\n", id, balance);
    }
};

