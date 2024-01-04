package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.AttachmentEntity;

import java.util.List;

public interface AttachmentService {

    void saveAttachment(AttachmentEntity attachmentEntity);
    void deleteAttachment(AttachmentEntity attachmentEntity);
    List<AttachmentEntity> getAllAttachments();
    AttachmentEntity getAttachmentById(Long id) throws Exception;
}
