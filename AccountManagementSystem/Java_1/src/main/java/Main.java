public class Main {
    public static void main(String[] args) {

        ////建立几个账户
        SavingAccount sa0 = new SavingAccount(1, 21325302, 0.015);
        SavingAccount sa1 = new SavingAccount(1, 58320212, 0.015);

        //几笔账目
        sa0.deposit(5, 5000);
        sa1.deposit(25, 10000);
        sa0.deposit(45, 5500);
        sa1.withdraw(60, 4000);

        //开户后第90天到了银行的计息日，结算所有账户的年息
        sa0.settle(90);
        sa1.settle(90);

        sa0.show();
        System.out.println("");
        sa1.show();
        System.out.println("");
    }
}
