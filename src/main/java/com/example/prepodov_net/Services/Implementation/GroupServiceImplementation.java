package com.example.prepodov_net.Services.Implementation;

import com.example.prepodov_net.Entity.GroupEntity;
import com.example.prepodov_net.Repository.GroupRepository;
import com.example.prepodov_net.Services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GroupServiceImplementation implements GroupService {

    private GroupRepository groupRepository;

    @Override
    public void saveGroup(GroupEntity group) {
        groupRepository.save(group);
    }

    @Override
    public void deleteGroup(GroupEntity group) {
        groupRepository.delete(group);
    }

    @Override
    public List<GroupEntity> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public GroupEntity getGroupById(Long id) throws Exception {
        return groupRepository.findById(id).orElseThrow(() -> new Exception("Группа не найдена!"));
    }
}
