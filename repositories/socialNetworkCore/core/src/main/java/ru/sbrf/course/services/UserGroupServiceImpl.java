package ru.sbrf.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.domain.UserGroup;
import ru.sbrf.course.repositories.UserGroupRepository;

@Service
public class UserGroupServiceImpl implements UserGroupService{

    private UserGroupRepository userGroupRepository;

    @Autowired
    public void setUserGroupRepository(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public Iterable<UserGroup> listAllUserGroups() {
        return userGroupRepository.findAll();
    }

    @Override
    public UserGroup getUserGroupById(Long groupId) {
        return userGroupRepository.findOne(groupId);
    }

    @Override
    public UserGroup saveUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    @Override
    public void deleteUserGroup(Long groupId) {
        userGroupRepository.delete(groupId);
    }
}
