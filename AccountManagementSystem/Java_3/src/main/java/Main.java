public class Main {
    public static void main(String[] args) {
        Date date = new Date(2008, 11, 1);	//起始日期
        //建立几个账户
        SavingsAccount[] accounts = new SavingsAccount[2];
        accounts[0] = new SavingsAccount(date, "S3755217", 0.015);
        accounts[1] = new SavingsAccount(date, "02342342", 0.015);
        int n = 2; //账户总数
        //11月份的几笔账目
        accounts[0].deposit(new Date(2008, 11, 5), 5000, "salary");
        accounts[1].deposit(new Date(2008, 11, 25), 10000, "sell stock 0323");
        //12月份的几笔账目
        accounts[0].deposit(new Date(2008, 12, 5), 5500, "salary");
        accounts[1].withdraw(new Date(2008, 12, 20), 4000, "buy a laptop");

        //结算所有账户并输出各个账户信息
        System.out.println("");
        for (int i = 0; i < n; i++) {
            accounts[i].settle(new Date(2009, 1, 1));
            accounts[i].show();
            System.out.println("");
        }
        System.out.print("Total: " + SavingsAccount.getTotal() + "\n");
    }
}
