package com.berk.service;


import com.berk.repository.TweetRepository;
import com.berk.repository.entity.Tweet;
import com.berk.repository.entity.UserProfile;
import com.berk.repository.view.VwTweet;
import com.berk.utility.MyFactoryService;

import java.util.ArrayList;
import java.util.List;

public class TweetService extends MyFactoryService<TweetRepository, Tweet,Long> {

    private UserProfileService userProfileService;
    public TweetService() {
        super(new TweetRepository());
        this.userProfileService = new UserProfileService();
    }

    /**
     * !!!!DIKKAT!!!!!!!
     * Bir listeden baska servislerden bılgı cekmesı beklenıyor ıse, bu ıslem her bır kayıt basına bellı
     * bır malıyete sebep olacaktır.b nedenle bu ıslemın yanı her seferınde bır kaydın cekılmesının dogru
     * olmadıgı acıktır. burada cozum olarak karsımıza 2 secenek cıkar
     * 1-Joın kullanarak ıkı tablonun bırlestırılmesı
     * 2-Arama yapılacak lıstenın tumden cekılerek fılter ıle bılgılerının cekılmesı
     * @return
     */
    public List<VwTweet> findAllViewTweet(){
        List<VwTweet> result = new ArrayList<>();
        List<Tweet> tweetList = getRepository().findAll(); // Bütün tweetler çekilir.
        List<UserProfile> userProfileList = userProfileService.findAll();
        tweetList.forEach(t->{
            /**
             * Çok fazla maliyetli bir işlemdir.
             */
            // UserProfile userProfile = userProfileService.findById(t.getUserid()).get();
            UserProfile userProfile = userProfileList.stream()
                    .filter(x->x.getId().equals(t.getUserid()))
                    .findFirst().get();
            VwTweet viewt = VwTweet.builder()
                    .id(t.getId())
                    .image(t.getImage())
                    .content(t.getContent())
                    .shareddate(t.getShareddate())
                    .retweetid(t.getRetweetid())
                    .tweetcomment(t.getTweetcomment())
                    .userid(t.getUserid())
                    .retweet(t.getRetweet())
                    .tweetview(t.getTweetview())
                    .tweetlike(t.getTweetlike())
                    .quotedtweetid(t.getQuotedtweetid())
                    .profileimg(userProfile.getProfileimg())
                    .nickName(userProfile.getName()+" "+userProfile.getSurname())
                    .username(userProfile.getUsername())
                    .build();
            result.add(viewt);
        });
        return result;
    }// findAll Method Sonu
}
