package com.berk;

import com.berk.controller.UserProfileController;

import java.util.Scanner;

public class TweetterApplication {
    public static void main(String[] args) {
      int secim;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************");
            System.out.println("Tweet Uygulaması");
            System.out.println("****************");
            System.out.println();
            System.out.println("1-Uye ol");
            System.out.println("2-Giris yap");
            System.out.println("3-Tweetleri gor");
            System.out.println("0-Cikis Yap");
            System.out.println("Seciniz..: ");
            secim= scanner.nextInt();
            switch (secim) {
                case 1: new UserProfileController().register(); break;
                case 2: new UserProfileController().login();break;
                case 3: break;
            }
      }while (secim!=0);
        System.out.println("Tekrar gorusmek uzere.....");
    }
}