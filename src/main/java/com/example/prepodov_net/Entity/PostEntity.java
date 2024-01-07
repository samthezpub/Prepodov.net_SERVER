package com.example.prepodov_net.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Data
@Entity
@Table(name = "post")
public class PostEntity extends Author {

    @Id
    @GeneratedValue
    private Long id;

    private Long authorId;

    private String content;

    @OneToMany(fetch = FetchType.EAGER)
    private List<AttachmentEntity> file;

    @Enumerated(EnumType.STRING)
    private AuthorType authorType;

    @Column(name = "posted_at")
    private LocalDateTime postedAt;

    @Transient
    private String postedAtFormatted;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<CommentEntity> comments;

    public String getPostedAtFormatted() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime postTime = postedAt;

        long secondsDiff = ChronoUnit.SECONDS.between(postTime, now);
        long minutesDiff = ChronoUnit.MINUTES.between(postTime, now);
        long hoursDiff = ChronoUnit.HOURS.between(postTime, now);

        String postedAtFormatted;
        if (secondsDiff < 5) {
            postedAtFormatted = "только что";
        } else if (secondsDiff < 60) {
            postedAtFormatted = String.format("%d секунд назад", secondsDiff);
        } else if (minutesDiff < 60) {
            postedAtFormatted = String.format("%d минут назад", minutesDiff);
        } else if (hoursDiff < 24) {
            postedAtFormatted = String.format("%d часов назад", hoursDiff);
        } else {
            postedAtFormatted = postTime.format(DateTimeFormatter.ofPattern("HH:mm, dd MMMM, yyyy"));
        }

        return postedAtFormatted;
    }

}

