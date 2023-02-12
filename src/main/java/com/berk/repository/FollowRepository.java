package com.berk.repository;

import com.berk.repository.entity.Comment;
import com.berk.repository.entity.Follow;
import com.berk.utility.MyFactoryRepository;

public class FollowRepository extends MyFactoryRepository<Follow,Long> {

    public FollowRepository() {
        super(new Follow());
    }
}
