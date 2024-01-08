package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.GroupEntity;
import com.example.prepodov_net.Exception.AlreadyHaveGroupException;
import com.example.prepodov_net.Exception.FoundUserException;
import com.example.prepodov_net.Exception.GroupNotFindException;
import com.example.prepodov_net.Exception.GroupUserNotFoundedException;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    void saveGroup(GroupEntity group);
    void deleteGroup(GroupEntity group);
    List<GroupEntity> getAllGroups();
    GroupEntity getGroupById(Long id) throws Exception;
    void addUserToGroup(Long groupId, Long userId) throws FoundUserException, GroupNotFindException, AlreadyHaveGroupException;
    void removeUserFromGroup(Long groupId, Long userId) throws FoundUserException, GroupNotFindException, GroupUserNotFoundedException;
}
