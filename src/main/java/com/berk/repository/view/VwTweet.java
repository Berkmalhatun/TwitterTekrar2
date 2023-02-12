package com.berk.repository.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VwTweet {
    Long id;
    Long userid;
    String username;
    String nickName;
    String profileimg;
    Long retweetid;
    Long quotedtweetid;
    Long shareddate;
    String image;
    String content;
    int tweetcomment;
    int tweetlike;
    int retweet;
    int tweetview;
}
