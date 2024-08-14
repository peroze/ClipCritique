package com.unipi.software.tech.ClipCritique.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questionnaire")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private VideoCategory category1;
    private VideoCategory category2;
    private VideoCategory category3;

    private Long prefer_songs1;
    private Long prefer_songs2;
    private Long prefer_songs3;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User uploader;


    public Questionnaire(VideoCategory category1, VideoCategory category2, VideoCategory category3, Long prefer_songs1, Long prefer_songs2, Long prefer_songs3, User uploader) {
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.prefer_songs1 = prefer_songs1;
        this.prefer_songs2 = prefer_songs2;
        this.prefer_songs3 = prefer_songs3;
        this.uploader = uploader;
    }
}
