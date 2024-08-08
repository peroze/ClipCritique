package com.unipi.software.tech.ClipCritique.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "watchhistory")
public class WatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="watchhistory_id")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id",nullable = false)
    private User user;

    @ManyToOne(targetEntity = Video.class)
    @JoinColumn(name = "video_id",referencedColumnName = "video_id",nullable = false)
    private Video video;

    private String text;
    private int rating;

}
