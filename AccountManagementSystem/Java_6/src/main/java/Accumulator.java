public class Accumulator {
    private
    Date lastDate;	//上次变更数值的时期
    double value;	//数值的当前值
    double sum;		//数值按日累加之和

    public
    //构造函数，date为开始累加的日期，value为初始值
    Accumulator(final Date date, double value) {
        this.lastDate = date;
        this.value = value;
        this.sum = 0;
    }

    //获得到日期date的累加结果
    final double getSum(final Date date) {
        return sum + value * (date.totalDays - lastDate.totalDays);
    }

    //在date将数值变更为value
    void change(final Date date, double value) {
        sum = getSum(date);
        lastDate = date;
        this.value = value;
    }

    //初始化，将日期变为date，数值变为value，累加器清零
    void reset(final Date date, double value) {
        lastDate = date;
        this.value = value;
        sum = 0;
    }
}

