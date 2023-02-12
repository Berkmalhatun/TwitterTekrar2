package com.berk.repository;

import com.berk.repository.entity.Comment;
import com.berk.utility.MyFactoryRepository;

public class CommentRepository extends MyFactoryRepository<Comment,Long> {

    public CommentRepository() {
        super(new Comment());
    }
}
