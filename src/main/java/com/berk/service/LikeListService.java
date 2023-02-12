package com.berk.service;

import com.berk.repository.CommentRepository;
import com.berk.repository.LikeListRepository;
import com.berk.repository.entity.Comment;
import com.berk.repository.entity.LikeList;
import com.berk.utility.MyFactoryService;

public class LikeListService extends MyFactoryService<LikeListRepository, LikeList,Long> {


    public LikeListService() {
        super(new LikeListRepository());
    }
}
