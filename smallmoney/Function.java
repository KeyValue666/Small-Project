package smallmoney;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Function {
    private double sal;//余额
    private double money;//收入和支出
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String moneyShow = "---------零钱通明细-----------";//零钱通明细
    Scanner scanner = new Scanner(System.in);

    public Function(double sal) {
        this.sal = sal;//构造器原始金额
    }

    //    1.收益
    public void addMoney() {
        System.out.println("收入的金额为:");
        money = scanner.nextDouble();
        if (money < 0) {
            System.out.println("收入的钱必须大于零");
            return;
        }
        date = new Date();
        sal += money;
        moneyShow += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + "余额\t" + sal;
        System.out.println("零钱已存入余额!");
    }

    //    2.支出
    public void subMoney() {
        System.out.println("支出的金额为:");
        money = scanner.nextDouble();
        if (money > sal) {
            System.out.println("余额不足，无法消费！");
            return;
        }
        sal -= money;
        date = new Date();
        moneyShow += "\n支出\t\t-" + money + "\t" + sdf.format(date) + "\t" + "余额\t" + sal;
        System.out.println("支出成功！");
    }

    //    3.展示余额
    public void showMony() {
        System.out.printf("所剩余额为:\t");
        System.out.print(sal + "元\n");
    }

    //        4.零钱明细
    public void details() {
        System.out.println(moneyShow);
    }
}
