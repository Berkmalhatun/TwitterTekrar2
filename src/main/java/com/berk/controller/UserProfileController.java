package com.berk.controller;

import com.berk.repository.entity.UserProfile;
import com.berk.service.UserProfileService;

import java.util.Scanner;

public class UserProfileController {
    private Scanner scanner;
    private UserProfileService userProfileService;

    private TweetController tweetController; //login methodu ıle gırıs yaptıgımızda bızı tweete gondersın
        //dıye tanımlandı
    public UserProfileController() {
        scanner = new Scanner(System.in);
        userProfileService = new UserProfileService();
        tweetController = new TweetController();
    }

    public void register() {
        System.out.println("");
        System.out.println("***************");
        System.out.println("Register Page");
        System.out.println("***************");
        System.out.println();
        boolean state;
        do {
            System.out.print("Kullanıcı adı.....: ");
            String username = scanner.nextLine();
            System.out.print("Sifre.............: ");
            String password = scanner.nextLine();
            System.out.print("Sifre Doğruluma...: ");
            String repassword = scanner.nextLine();
            if (repassword.equals(password)) {
                boolean isUsernameExist = new UserProfileService().existByUsername(username);
                if (isUsernameExist) {
                    System.out.println("Bu Kullanıcı adı kullanılmaktadır");
                    state = true;
                } else {
                    userProfileService.save(UserProfile.builder().username(username).password(password).build());
                    System.out.println("KULLANICI BASARI İLE KAYIT EDİLDİ.");
                    state = false;
                }
            } else {
                System.out.println("Sifreler uyusmamaktadır.");
                state = true;
            }
        } while (state);
    }
    public void login() {
        System.out.println("");
        System.out.println("***************");
        System.out.println("Login Page");
        System.out.println("***************");
        System.out.println();
        System.out.println("Username....: ");
        String username = scanner.nextLine();
        System.out.println("Password....: ");
        String password = scanner.nextLine();
        /**
      * kullanıcı adı ve sıfre dogrulanırken sıfre yanlıstır bılgısı gecmeyınız.bu guvenlık zafıyetıdır.
         * veya kullanıcı adı bulunmamaktadır. Bu tarz gerı bıldırımler guvenlık zaafıyetıdır.
         */
        boolean login = userProfileService.doLogin(username,password);
        if (login) {
            System.out.print("Giris basarili.");
            tweetController.userPage(username);
        }else {
            System.out.print("Kullanici adi veya sıfre hatalıdır.");
        }
    }
}
