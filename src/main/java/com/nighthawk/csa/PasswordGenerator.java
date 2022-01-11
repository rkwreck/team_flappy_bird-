package com.nighthawk.csa;
import java.util.Random;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    private static int passwordsGenerated =0;

    private static Random random = new Random();

    private String prefix;

    private int length;

    public PasswordGenerator(int i, String chs) {
    }

    public String PasswordGenerator(int length,String prefix) {

        this.prefix = prefix;

        this.length = length;

        return prefix;
    }

    public String PasswordGenerator(int length) {

        this.prefix = "A";

        this.length = length;

        return this.prefix;
    }

    public String pwGen(){

        String pwd= this.prefix+".";

        for(int i=1;i<=this.length;i++){

            pwd+=random.nextInt(10);

        }

        passwordsGenerated+=1;

        return pwd;

    }

    public int pwCount(){

        return passwordsGenerated;

    }

    public static void main(String[] args) {

        PasswordGenerator pw1 = new PasswordGenerator(4,"adi");

        System.out.println(pw1.pwCount());

        System.out.println(pw1.pwGen());

        System.out.println(pw1.pwGen());

        System.out.println(pw1.pwCount());

        PasswordGenerator pw2 = new PasswordGenerator(6, "hi");

        System.out.println(pw2.pwCount());

        System.out.println(pw2.pwGen());

        System.out.println(pw2.pwCount());

        System.out.println(pw1.pwCount());

    }
}
