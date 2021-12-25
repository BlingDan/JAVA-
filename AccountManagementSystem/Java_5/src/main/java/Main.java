import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date date = new Date(2008, 11, 1);	//起始日期
        //建立几个账户
        SavingsAccount sa1 = new SavingsAccount(date, "S3755217", 0.015);
        SavingsAccount sa2 = new SavingsAccount(date, "02342342", 0.015);
        CreditAccount ca = new CreditAccount(date, "C5392394", 10000, 0.0005, 50);
        Account[] accounts = new Account[]{sa1, sa2, ca };
        int n = 3;//账户总数

        System.out.println("(d)deposit (w)withdraw (s)show (c)change day (n)next month (e)exit");
        String cmd;
        do {
            //显示日期和总金额
            date.show();
            //System.out.print("\tTotal: " + Account.getTotal() + "\tcommand> ");
            System.out.printf("\tTotal: %.2f\tcommand> ", Account.getTotal());

            int index, day;
            double amount;
            String desc;

            cmd = scanner.nextLine();
            switch (cmd) {
                case "d":	//存入现金
                    index = scanner.nextInt();
                    amount = scanner.nextDouble();
                    desc = scanner.next();
                    accounts[index].deposit(date, amount, desc);
                    break;
                case "w":	//取出现金
                    index = scanner.nextInt();
                    amount = scanner.nextDouble();
                    desc = scanner.next();
                    accounts[index].withdraw(date, amount, desc);
                    break;
                case "s":	//查询各账户信息
                    for (int i = 0; i < n; i++) {
                        System.out.print("[" + i + "] ");
                        accounts[i].show();
                        System.out.println("");
                    }
                    break;
                case "c":	//改变日期
                    day = scanner.nextInt();
                    if (day < date.getDay())
                        System.out.print("You cannot specify a previous day");
                    else if (day > date.getMaxDay())
                        System.out.print("Invalid day");
                    else
                        date = new Date(date.getYear(), date.getMonth(), day);
                    break;
                case "n":	//进入下个月
                    if (date.getMonth() == 12)
                        date = new Date(date.getYear() + 1, 1, 1);
                    else
                        date = new Date(date.getYear(), date.getMonth() + 1, 1);
                    for (int i = 0; i < n; i++)
                        accounts[i].settle(date);
                    break;
            }
        } while (!cmd.equals("e"));
    }
}
