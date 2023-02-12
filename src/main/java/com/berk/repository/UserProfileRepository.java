package com.berk.repository;

import com.berk.repository.entity.Comment;
import com.berk.repository.entity.UserProfile;
import com.berk.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class UserProfileRepository extends MyFactoryRepository<UserProfile,Long> {

    public UserProfileRepository() {
        super(new UserProfile());
    }

    public boolean existByUsername(String username){
        TypedQuery<Boolean> typedQuery = getEntityManager()
                .createNamedQuery("UserProfile.existByUsername", Boolean.class);
        typedQuery.setParameter("username",username);
        Boolean result = typedQuery.getSingleResult();
        return result;
    }
    public boolean doLogin(String username,String password){
        TypedQuery<Boolean> typedQuery = getEntityManager()
                .createNamedQuery("UserProfile.doLogin", Boolean.class);
        typedQuery.setParameter("username",username);
        typedQuery.setParameter("password",password);
        Boolean result = typedQuery.getSingleResult();
        return result;
    }


    public Optional<UserProfile> findByUsername(String username){
        TypedQuery<UserProfile> typedQuery =getEntityManager()
                .createNamedQuery("UserProfile.findByUsername", UserProfile.class);
        typedQuery.setParameter("username",username);
        try {
       return Optional.of(typedQuery.getSingleResult());
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
