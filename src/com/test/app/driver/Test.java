package com.test.app.driver;

public class Test {

    private int a;

    Test() {
        System.out.println("I am constructor");
    }

    {
        System.out.println("I am IIB");
    }

    public static void main(String[] args) {
        Integer a = new Integer(2);
        Integer b = new Integer(4);

        Test test = new Test();
        test.a = 10;
        /*test.changeVal();

        swap(a, b);

        System.out.println("a" +a);
        System.out.println("b" +b);
        System.out.println("test.a" +test.a);*/
    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        b = a;
        a = temp;
    }

    void changeVal() {
        a = 20;
    }

}
