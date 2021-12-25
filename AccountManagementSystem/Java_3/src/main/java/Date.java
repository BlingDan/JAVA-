public class Date {
    private
    int year;		//年
    int month;		//月
    int day;		//日
    int totalDays;	//该日期是从公元元年1月1日开始的第几天

    public

        int[] DAYS_BEFORE_MONTH = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
        Date(int year, int month, int day){  //用年、月、日构造日期
        this.year = year;
        this.month = month;
        this.day = day;
        if (day <= 0 || day > getMaxDay()) {
            System.out.println("Invalid date: ");
            show();
            System.out.println("");
        }
        int years = year - 1;
        totalDays = years * 365 + years / 4 - years / 100 + years / 400
                + DAYS_BEFORE_MONTH[month - 1] + day;
        if (isLeapYear() && month > 2) totalDays++;
    }
        int getYear() { return year; }
        int getMonth()  { return month; }
        int getDay()  { return day; }
        int getMaxDay(){ //获得当月有多少天
            if (isLeapYear() && month == 2)
                return 29;
            else
                return DAYS_BEFORE_MONTH[month]- DAYS_BEFORE_MONTH[month - 1];
    }
        boolean isLeapYear()  {	//判断当年是否为闰年
            return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
        void show() {  //输出当前日期
            System.out.println(getYear() + "-" + getMonth() + "-" + getDay());
        }
        //计算两个日期之间差多少天
        int distance(Date date) {
            return totalDays - date.totalDays;
    }
}
