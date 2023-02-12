package com.berk.service;

import com.berk.repository.CommentRepository;
import com.berk.repository.FollowRepository;
import com.berk.repository.entity.Comment;
import com.berk.repository.entity.Follow;
import com.berk.utility.MyFactoryService;

public class FollowService extends MyFactoryService<FollowRepository, Follow,Long> {
    public FollowService() {
        super(new FollowRepository());
    }
}
