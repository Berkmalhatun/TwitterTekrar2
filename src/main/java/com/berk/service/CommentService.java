package com.berk.service;

import com.berk.repository.CommentRepository;
import com.berk.repository.entity.Comment;
import com.berk.utility.MyFactoryService;

public class CommentService extends MyFactoryService<CommentRepository, Comment,Long> {

    public CommentService() {
        super(new CommentRepository());
    }
}
