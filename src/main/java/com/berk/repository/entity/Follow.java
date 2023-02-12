package com.berk.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * Takip edilen -> benım takıp ettıklerım
 * Benım takıp ettıgım kısılerı bulmak ıcın
 * select * from tblfollow where userid=?
 * Benı takıp eden kısılerı bulmak ıcın
 * select * from tblfollow where followingid=?
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblfollow")
public class Follow extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long followerid; // takıp eden kısısi
    Long followingid; // takip edilen kisinin id si
}
