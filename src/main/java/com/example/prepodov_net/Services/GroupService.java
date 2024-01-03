package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.GroupEntity;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    void saveGroup(GroupEntity group);
    void deleteGroup(GroupEntity group);
    List<GroupEntity> getAllGroups();
    GroupEntity getGroupById(Long id) throws Exception;

}
