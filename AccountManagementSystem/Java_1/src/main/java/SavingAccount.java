public class SavingAccount {
    private int id;
    double balance;
    double rate;
    int lastDate;
    double accumulation;

    void record(int var1, double var2) {
        this.accumulation = this.accumulate(var1);
        this.lastDate = var1;
        var2 = (var2 * 100.0D + 0.5D) / 100.0D;
        this.balance += var2;
        System.out.printf("%d\t#%d\t%f\t%f\n", var1, this.id, var2, this.balance);
    }

    double accumulate(int var1) {
        return this.accumulation + this.balance * (double)(var1 - this.lastDate);
    }

    public SavingAccount(int var1, int var2, double var3) {
        this.id = var2;
        this.balance = 0.0D;
        this.rate = var3;
        this.lastDate = var1;
        this.accumulation = 0.0D;
        System.out.printf("%d\t#%d is created \n", var1, var2);
    }

    int getId() {
        return this.id;
    }

    double getBalance() {
        return this.balance;
    }

    double getRate() {
        return this.rate;
    }

    void deposit(int var1, double var2) {
        this.record(var1, var2);
    }

    void withdraw(int var1, double var2) {
        if (var2 > this.getBalance()) {
            System.out.println("Error: not enough money");
        } else {
            this.record(var1, -var2);
        }

    }

    void settle(int var1) {
        double var2 = this.accumulate(var1) * this.rate / 365.0D;
        if (var2 != 0.0D) {
            this.record(var1, var2);
        }

        this.accumulation = 0.0D;
    }

    void show() {
            System.out.printf("#%d\tBalance: %f", this.id, this.balance);
        }
}
