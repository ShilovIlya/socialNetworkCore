package ru.sbrf.course.services;

import ru.sbrf.course.domain.UserData;

public interface UserDataService    {
    Iterable<UserData> listAllUserDatas();

    UserData getUserDataById(Long id);

    UserData saveUserData(UserData userData);

    void deleteAccount(Long id);
}
