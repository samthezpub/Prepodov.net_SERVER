package com.example.prepodov_net.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "files")
@Entity
public class AttachmentEntity {
    @Id
    private Long id;

    @ManyToOne
    private PostEntity post;

    private String attachment;

    @Enumerated(EnumType.STRING)
    private AttachmentType attachmentType;
}

enum AttachmentType {
    PICTURE,
    VIDEO,
    AUDIO,
    OTHER_FILE
}