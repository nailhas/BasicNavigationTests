package com.cbt.utilities;

public class getOS {
    //To get my PC OS name:
    public static String myOS(){
        String os = System.getProperty("os.name");
        System.out.println(os);
        return os;
    }

    public static void main(String[] args) {
        myOS(); //Windows 10
    }
}
