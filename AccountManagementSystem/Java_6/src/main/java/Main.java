import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<Account>();// 创建容器

        Date date = new Date(2008, 11, 1);	//起始日期
        //Array<Account *> accounts(0);	//创建账户数组，元素个数为0
        System.out.println("(a)add account (d)deposit (w)withdraw (s)show (c)change day (n)next month (e)exit");
        String cmd;
        do {
            //显示日期和总金额
            date.show();
            System.out.printf("\tTotal: %.2f\tcommand> ", Account.getTotal());

            String type;
            int index, day;
            double amount, credit, rate, fee;
            String id, desc;
            Account account;

            cmd = scanner.nextLine();
            switch (cmd) {
                case "a":	//增加账户
                    type = scanner.next();
                    id = scanner.next();
                    if (type.equals("s")) {
                        rate = scanner.nextDouble();
                        account = new SavingsAccount(date, id, rate);
                    } else {
                        credit = scanner.nextDouble();
                        rate = scanner.nextDouble();
                        fee = scanner.nextDouble();
                        account = new CreditAccount(date, id, credit, rate, fee);
                    }
                    accounts.add(account);
                    break;
                case "d":	//存入现金
                    index = scanner.nextInt();
                    amount = scanner.nextDouble();
                    desc = scanner.next();
                    accounts.get(index).deposit(date, amount, desc);
                    break;
                case "w":	//取出现金
                    index = scanner.nextInt();
                    amount = scanner.nextDouble();
                    desc = scanner.next();
                    accounts.get(index).withdraw(date, amount, desc);
                    break;
                case "s":	//查询各账户信息
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.print("[" + i + "] ");
                        accounts.get(i).show();
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
                    for (int i = 0; i < accounts.size(); i++)
                        accounts.get(i).settle(date);
                    break;
            }
        } while (!cmd.equals(("e")));

        accounts.clear();

    }
}
