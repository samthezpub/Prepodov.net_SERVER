package com.example.prepodov_net.Services.Implementation;

import com.example.prepodov_net.Entity.AttachmentEntity;
import com.example.prepodov_net.Repository.AttachmentRepository;
import com.example.prepodov_net.Services.AttachmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AttachmentServiceImplementation implements AttachmentService {

    private AttachmentRepository attachmentRepository;

    @Override
    public void saveAttachment(AttachmentEntity attachmentEntity) {
        attachmentRepository.save(attachmentEntity);
    }

    @Override
    public void deleteAttachment(AttachmentEntity attachmentEntity) {
        attachmentRepository.delete(attachmentEntity);
    }

    @Override
    public List<AttachmentEntity> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    @Override
    public AttachmentEntity getAttachmentById(Long id) throws Exception {
        return attachmentRepository.getReferenceById(id);
    }
}
