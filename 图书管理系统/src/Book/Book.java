package Book;

import java.util.Scanner;

public class Book {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookList bookList = new BookList();//用于管理书籍的单链表
        boolean flag = true;
        while (flag) {
            System.out.println("~~~~~~~~~~~~~~~图书管理系统~~~~~~~~~~~~~~~");
            System.out.println("***********   a:增加书籍    *************");
            System.out.println("***********   b:删除书籍    *************");
            System.out.println("***********   c:查找书籍    *************");
            System.out.println("***********   d:更新书籍    *************");
            System.out.println("***********   e:查看书籍量  *************");
            System.out.println("***********   f:展示书籍    *************");
            System.out.println("***********   g:退出系统    *************");
            System.out.println("~~~~~~~~~~~~~~~图书管理系统~~~~~~~~~~~~~~~");
            System.out.println("请选择:");
            char key = scanner.nextLine().charAt(0);
            switch (key) {
                case 'a': {
                    System.out.println("请输入书籍的名称：");
                    String bookName = scanner.nextLine();
                    System.out.println("请输入书籍的价格：");
                    double bookPrice = scanner.nextDouble();
                    scanner.nextLine();//用于吸收换行符
                    System.out.println("请输入书籍的编号：");
                    String bookNumber = scanner.nextLine();
                    //申请一个节点
                    BookContent bookContent = new BookContent(bookName, bookPrice, bookNumber);
                    bookList.addBook(bookContent);
                    System.out.println("添加成功！");
                    break;
                }
                case 'b': {
                    /*bug：当为空表时程序报空指针异常*/
                    System.out.println("请输入要删除书籍的名称：");
                    String bookName = scanner.nextLine();
                    bookList.delBook(bookName);
                    break;
                }
                case 'c': {
                    System.out.println("请输入要查找书籍的名称：");
                    String bookName = scanner.nextLine();
                    System.out.println(bookList.serchBook(bookName));
                    break;
                }
                case 'd': {
                    System.out.println("请输入要更新书籍的名字：");
                    String bookName=scanner.nextLine();
                    bookList.updateBook(bookName);
                    break;
                }
                case 'e': {
                    bookList.getBookLength();

                    break;
                }
                case 'f': {
                    bookList.showBook();
                    break;
                }
                case 'g': {
                    System.out.println("系统已退出！");
                    flag = false;
                    break;
                }
                default:
                    System.out.println("输入选项错误！请重新输入！");
            }

        }

    }
}

//创建书籍链表，用于管理书籍
class BookList {
    Scanner scanner = new Scanner(System.in);
    //建立书的头节点
    private BookContent bookHead = new BookContent("", 0, "");

    /*0.判断书籍是否为空*/
    public boolean blankBook() {
        if (bookHead.next == null) {
            return true;
        } else {
            return true;
        }
    }

    /*1.添加书籍*/
    public void addBook(BookContent bookContent) {
        BookContent temp = bookHead;
        //找到链表的最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = bookContent;

    }

    /*2.删除书籍*/
    public void delBook(String bookName) {
        //如果链表为空，直接退出
        if (bookHead.next == null) {
            System.out.println("没有书籍！");
            return;
        }
        BookContent temp = bookHead;
        boolean flag = false;//用于显示书籍是否找到
        while (true) {
            if (temp.next==null){
                /*当temp为最后一个数据项时，temp.next为空指针，防止出现空指针异常*/
                break;
            }
            if (temp.next.getBookName().equals(bookName)) {
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            System.out.println("删除成功！");
        } else {
            System.out.println("要删除的书籍不存在！");
        }
    }

    /*3.查找书籍*/
    public BookContent serchBook(String bookName) {
        if (bookHead.next == null) {
            System.out.println("书籍列表为空！");
            return null;
        }
        BookContent temp = bookHead;
        boolean flag = false;//用于是否查找到书籍
        while (true) {
            if (temp.next==null){
                break;
            }
            if (temp.next.getBookName().equals(bookName)) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            return temp.next;
        } else {
            System.out.println("查找的书籍不存在！");
            return null;
        }

    }

    /*4.更新书籍*/
    public void updateBook(String bookName) {
        if (bookHead.next==null){
            System.out.println("书籍列表为空！");
            return;
        }
        BookContent temp=bookHead;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }
            if(temp.next.getBookName().equals(bookName)){
                System.out.println("请重新输入书的名字：");
                String s=scanner.nextLine();
                temp.next.setBookName(s);
                System.out.println("请重新输入书的价格：");
                double p=scanner.nextDouble();
                temp.next.setBookPrice(p);
                scanner.nextLine();//用于吸收scanner.nextDouble()产生的回车键
                System.out.println("请重新输入书的编号：");
                String n=scanner.nextLine();
                temp.next.setBookNumber(n);
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("修改成功！");
        }else {
            System.out.println("未找到要更新的书籍！");
        }


    }

    /*5.展示书籍个数*/
    public void getBookLength() {
        if (bookHead.next == null) {
            System.out.println("书籍的数目为 0 本。");
            return;
        }
        BookContent temp = bookHead.next;
        int size = 0;
        while (true) {
            if (temp == null) {
                break;
            } else {
                size++;
                temp = temp.next;
            }

        }
        System.out.println("共有书籍有 "+size+" 本。");
    }

    /*6.展示书籍*/
    public void showBook() {
        if (bookHead.next == null) {
            System.out.println("书籍列表为空！");
        }
        BookContent temp = bookHead.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }


}

//创建书籍的节点属性
class BookContent {
    private String bookName;//书名
    private double bookPrice;//书的价格
    private String bookNumber;//书的编号
    public BookContent next;//链接


    public BookContent(String bookName, double bookPrice, String bookNumber) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookNumber = bookNumber;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "BookContent{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookNumber='" + bookNumber + '}';
    }
}