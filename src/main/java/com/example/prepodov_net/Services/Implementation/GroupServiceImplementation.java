package com.example.prepodov_net.Services.Implementation;

import com.example.prepodov_net.Entity.GroupEntity;
import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Exception.AlreadyHaveGroupException;
import com.example.prepodov_net.Exception.FoundUserException;
import com.example.prepodov_net.Exception.GroupNotFindException;
import com.example.prepodov_net.Exception.GroupUserNotFoundedException;
import com.example.prepodov_net.Repository.GroupRepository;
import com.example.prepodov_net.Repository.UserRepository;
import com.example.prepodov_net.Services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GroupServiceImplementation implements GroupService {

    private GroupRepository groupRepository;
    private UserRepository userRepository;

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

    @Override
    public void addUserToGroup(Long userId, Long groupId) throws FoundUserException, GroupNotFindException, AlreadyHaveGroupException {
        UserEntity user = userRepository.getUserById(userId)
                .orElseThrow(() -> new FoundUserException("Пользователь не найден"));


        GroupEntity groupEntity = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFindException("Группа не найдена!"));

        if (groupEntity.getUsers().contains(user)){
            throw new AlreadyHaveGroupException("У группы уже есть такой пользователь");
        }

        groupEntity.getUsers().add(user);
        groupRepository.save(groupEntity);
    }

    @Override
    public void removeUserFromGroup(Long groupId, Long userId) throws FoundUserException, GroupNotFindException, GroupUserNotFoundedException {
        UserEntity user = userRepository.getUserById(userId)
                .orElseThrow(() -> new FoundUserException("Пользователь не найден"));


        GroupEntity groupEntity = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFindException("Группа не найдена!"));

        if (!groupEntity.getUsers().contains(user)){
            throw new GroupUserNotFoundedException("У группы нет такого пользователя");
        }

        groupEntity.getUsers().remove(user);
        groupRepository.save(groupEntity);
    }
}
