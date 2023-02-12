package com.berk.repository;

import com.berk.repository.entity.Comment;
import com.berk.repository.entity.Tweet;
import com.berk.utility.MyFactoryRepository;

public class TweetRepository extends MyFactoryRepository<Tweet,Long> {

    public TweetRepository() {
        super(new Tweet());
    }
}
