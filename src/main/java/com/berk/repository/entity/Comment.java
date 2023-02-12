package com.berk.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblcomment")


public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long tweetid;
    /**
     * Tweet için yapılan yorum id
     */
    Long commentid;
    /**
     * Tweet e ya da yorum yapan baska bır kısıye yorum yapan kısı
     */
    Long userid;
    @Column(length = 280)
    String comment;
    Long commentdate;
}
