package com.berk.service;

import com.berk.repository.UserProfileRepository;
import com.berk.repository.entity.UserProfile;
import com.berk.utility.MyFactoryService;

import java.util.Optional;

public class UserProfileService extends MyFactoryService<UserProfileRepository, UserProfile,Long> {
    private UserProfileRepository userProfileRepository;
    public UserProfileService() {
        super(new UserProfileRepository());
        this.userProfileRepository = new UserProfileRepository();
    }

    public boolean existByUsername(String username){
    return getRepository().existByUsername(username); //myfactoryservice ve repository getter ekle
    }

    public boolean doLogin(String username,String password){
        return getRepository().doLogin(username,password); //myfactoryservice ve repository getter ekle
    }
    public Optional<UserProfile> findByUsername(String username){
        return getRepository().findByUsername(username);
    }
}
