public class SavingsAccount extends Account{
    private
    Accumulator acc;	//辅助计算利息的累加器
    double rate;		//存款的年利率
    public
        //构造函数
    SavingsAccount( Date date, String id, double rate) {
        super(date, id);
        this.rate = rate;
        acc = new Accumulator(date, 0);
    }
    double getRate()  { return rate; }

    @Override
    void deposit(final Date date, double amount, final String desc) {
        record(date, amount, desc);
        acc.change(date, getBalance());
    }

    @Override
    void withdraw(final Date date, double amount, final String desc) {
        if (amount > getBalance()) {
            error("not enough money");
        } else {
            record(date, -amount, desc);
            acc.change(date, getBalance());
        }
    }

    @Override
    void settle(final Date date) {
        if (date.getMonth() == 1) {	//每年的一月计算一次利息
            double interest = acc.getSum(date) * rate
                    / (date.totalDays - new Date(date.getYear() - 1, 1, 1).totalDays);
            if (interest != 0)
                record(date, interest, "interest");
            acc.reset(date, getBalance());
        }
    }
}
