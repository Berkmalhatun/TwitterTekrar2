package com.berk.repository;

import com.berk.repository.entity.Comment;
import com.berk.repository.entity.LikeList;
import com.berk.utility.MyFactoryRepository;

public class LikeListRepository extends MyFactoryRepository<LikeList,Long> {

    public LikeListRepository() {
        super(new LikeList());
    }
}
