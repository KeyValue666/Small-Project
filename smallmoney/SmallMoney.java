package smallmoney;

import java.util.Scanner;

public class SmallMoney {
    public static void main(String[] args) {
        boolean loop=true;
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        Function function = new Function(0);
        while (loop){
            System.out.println("========零钱通=========");
            System.out.println("-------1.收益---------");
            System.out.println("-------2.支出---------");
            System.out.println("-------3.余额---------");
            System.out.println("-------4.明细---------");
            System.out.println("-------5.退出---------");
            System.out.println("========零钱通=========");
            System.out.println("输入你的选项：");
            key=scanner.nextLine().charAt(0);
            switch (key){
                case '1':
                    function.addMoney();
                    break;
                case'2':
                    function.subMoney();
                    break;
                case '3':
                    function.showMony();
                    break;
                case '4':
                    function.details();
                    break;
                case '5':
                    System.out.println("系统已退出！");
                    loop=false;
                    break;
                default:
                    System.out.println("输入的内容不合法，请重新输入！");
                    break;
            }
        }
    }
}

