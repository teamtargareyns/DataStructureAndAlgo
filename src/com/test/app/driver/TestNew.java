package com.test.app.driver;


class TestBase {

    static {
        System.out.println("I am SIB");
    }

    {
        System.out.println("I am IIB");
    }

    TestBase() {
        System.out.println("Testbase is invoked");
    }

}

public class TestNew extends TestBase {

    TestNew() {
        this(1);
        System.out.println("TestNew is invoked");
    }

    TestNew(int i) {
        System.out.println("TestNew is invoked : " + i);
    }

    public static void main(String[] args) {
        /*TestNew obj = new TestNew();
        TestNew obj1 = new TestNew();*/


        //String s2 = new String("abc");
        String s2 = "abc";
        String s1 = new String("abc");

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode() == s2.hashCode());


        System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''''");


        System.out.println(10/2);
        System.out.println(10%2);
        System.out.println(15/2);
        System.out.println(15%2);
        System.out.println(15/30);
        System.out.println(15%30);

    }

}
