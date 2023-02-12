package com.berk.controller;

import com.berk.repository.entity.Tweet;
import com.berk.repository.entity.UserProfile;
import com.berk.service.*;

import java.util.Scanner;

public class TweetController {
    private Scanner scanner;
    private UserProfile userProfile;
    private TweetService tweetService;
    private LikeListService likeListService;
    private FollowService followService;
    private CommentService commentService;
    private UserProfileService userProfileService;


   public TweetController(){
       this.commentService = new CommentService();
       this.likeListService = new LikeListService();
       this.tweetService= new TweetService();
       this.followService = new FollowService();
       this.userProfileService = new UserProfileService();

   }
    private int secim(){
       this.scanner = new Scanner(System.in);
       return scanner.nextInt();
    }

    private String ifade(){
       this.scanner=new Scanner(System.in);
       return scanner.nextLine();
    }
    /**
     * Bır kulanıcının akısı seklınde yapıyoruz . bu nedenle logın olan kullanıcının ıd sı uzerınden
     * ıslem yapacagız.
     * @param username
     */
    public void userPage(String username){
        this.userProfile=userProfileService.findByUsername(username).get();
        System.out.println("**********************");
        System.out.println("*** USER PAGE ***");
        System.out.println("**********************");
        int secim;
        do {
            System.out.println("");
            System.out.println("1-Tweet olustur");
            System.out.println("2-Tum tweetleri gor");
            System.out.println("3-Profil duzenle");
            System.out.println("0-<<<< Geri don");
            System.out.println("Seciniz....: ");
            secim=secim();
            switch (secim) {
                case 1: createTweet();break;
                case 2: listTweet();break;
                case 3: break;
        }
        }while (secim!=0);

    }
    private void createTweet(){
        System.out.println("******************");
        System.out.println("   Tweet Olustur  ");
        System.out.println();
        System.out.println("Resim....: ");
        String resim = ifade();
        System.out.println("Tweet....: ");
        String tweetContent = ifade();
        Tweet tweet = Tweet.builder().userid(userProfile.getId()).shareddate(System.currentTimeMillis())
                .image(resim).content(tweetContent).build();
        tweetService.save(tweet);
    }
    private void listTweet(){
        System.out.println("*******************************");
        System.out.println("********Aktif Tweet************");
        System.out.println("*******************************");
        System.out.println();
        tweetService.findAllViewTweet().forEach(t->{
            System.out.println("-------------------");
            System.out.println(t.getNickName()+" -> "+t.getUsername());
            System.out.println();
            System.out.println(t.getContent());
            System.out.println("-------------------");
            System.out.println("-------------------");
            System.out.println("-------------------");
            System.out.println("-------------------");
            System.out.println("-------------------");
            System.out.printf("Y[%s]      R[%s]    L[%s]     W[%s] \n",
                    t.getTweetcomment(),t.getRetweet(),t.getTweetlike(),t.getTweetview());
            System.out.println("-------------------");
            System.out.println();
        });

    }
}
