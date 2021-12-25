public class Date {
    private
    int year;		//年
    int month;		//月
    int day;		//日
    int totalDays;	//该日期是从公元元年1月1日开始的第几天

    public
    int[] DAYS_BEFORE_MONTH = new int[]{ 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

    Date(int year, int month, int day) {
        if (day <= 0 || day > getMaxDay()) {
            System.out.print("Invalid date: ");
            show();
            System.out.println("");
        }
        int years = year - 1;
        totalDays = years * 365 + years / 4 - years / 100 + years / 400
                + DAYS_BEFORE_MONTH[month - 1] + day;
        if (isLeapYear() && month > 2) totalDays++;
    }	//用年、月、日构造日期
    int getYear() { return year;}
    int getMonth() { return month;}
    int getDay() { return day;}
    int getMaxDay()
    {
        if (isLeapYear() && month == 2)
            return 29;
        else if (month == 0)
            return 0;
        else
            return DAYS_BEFORE_MONTH[month]- DAYS_BEFORE_MONTH[month - 1];

    }//获得当月有多少天
    boolean isLeapYear() {	//判断当年是否为闰年
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    void show() {
        System.out.print(getYear() + getMonth() + "-" + getDay());
    }			//输出当前日期
    //计算两个日期之间差多少天

    /**
     * java不支持运算符重载
    int operator - (Date date) {
        return totalDays - date.totalDays;
     直接用字段实现
     */
    }

