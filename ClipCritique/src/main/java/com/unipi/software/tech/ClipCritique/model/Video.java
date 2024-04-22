package com.unipi.software.tech.ClipCritique.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "videos")
@Getter
@Setter
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long id;
    private String link;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate uploadLocalDate;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User uploader;

    private String name;

    public Video() {}

    public Video(String link, User uploader,String name){
        this.link = link;
        this.uploadLocalDate = LocalDate.now();
        this.uploader = uploader;
        this.name=name;
    }



}
