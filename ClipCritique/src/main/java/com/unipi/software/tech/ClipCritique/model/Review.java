package com.unipi.software.tech.ClipCritique.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User reviewer;

    @ManyToOne(targetEntity = Video.class)
    @JoinColumn(name = "video_id",referencedColumnName = "video_id",nullable = false)
    private Video video;

    private String text;
    private int rating;

}
