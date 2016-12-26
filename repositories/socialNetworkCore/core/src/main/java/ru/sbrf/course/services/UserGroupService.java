package ru.sbrf.course.services;

import ru.sbrf.course.domain.UserGroup;

public interface UserGroupService {
    Iterable<UserGroup> listAllUserGroups();

    UserGroup getUserGroupById(Long accountId);

    UserGroup saveUserGroup(UserGroup userGroup);

    void deleteUserGroup(Long groupId);
}

