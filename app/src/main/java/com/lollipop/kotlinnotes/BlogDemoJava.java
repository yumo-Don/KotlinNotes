package com.lollipop.kotlinnotes;

import com.lollipop.test.A;

/**
 * @Author: lollipop
 * @Document:
 */

class BlogDemoJava {


    public static void main(String[] args) {
        AA a = new AA("lollipop");

        change(a);
        System.out.println(a.name);

        changeAgain(a);
        System.out.println(a.name);

        setNull(a);
        System.out.println(a.name);

        String zz = ".1";
        System.out.println(Double.parseDouble(zz));


    }
    public static void change(AA a){
        a.name = "YM";
    }

    public static void changeAgain(AA a){
        a = new AA("是啥呢");
    }

    public static void setNull(AA a){
        a.name = "你猜";
        a = null;
    }
}

class AA{
    public String name;
    public AA(String name) {
        this.name = name;
    }
}












