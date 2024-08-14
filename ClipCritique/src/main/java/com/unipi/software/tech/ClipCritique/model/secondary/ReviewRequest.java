package com.unipi.software.tech.ClipCritique.model.secondary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReviewRequest {
    public Long video_id;
    public Long user;
    public Integer rating;
}
