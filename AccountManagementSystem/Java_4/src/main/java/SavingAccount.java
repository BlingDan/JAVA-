class SavingAccount extends Account{
    private
    Accumulator acc;	//辅助计算利息的累加器
    double rate;		//存款的年利率

    public
    SavingAccount(Date date, String id, double rate) {
        super(date, id);
        this.acc = new Accumulator(date, 0);
        this.rate = rate;
    }

    double getRate() { return rate; }
    //存入现金
    void deposit(Date date, double amount, String desc){
        record(date, amount, desc);
        acc.change(date, getBalance());
    }
    //取出现金
    void withdraw(Date date, double amount, String desc){
        if (amount > getBalance()) {
            error("not enough money");
        } else {
            record(date, -amount, desc);
            acc.change(date, getBalance());
        }
    }
    //结算利息，每年1月1日调用一次该函数
    void settle(Date date){
        double interest = acc.getSum(date) * rate	//计算年息
                / date.distance(new Date(date.getYear() - 1, 1, 1));
        if (interest != 0)
            record(date, interest, "interest");
        acc.reset(date, getBalance());
    }
}
