package ru.sbrf.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.domain.UserData;
import ru.sbrf.course.repositories.UserDataRepository;

@Service
public class UserDataServiceImpl implements UserDataService {

    private UserDataRepository userDataRepository;

    @Autowired
    public void setUserDataRepository(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }
    @Override
    public Iterable<UserData> listAllUserDatas() {
        return userDataRepository.findAll();
    }

    @Override
    public UserData getUserDataById(Long id) {
        return userDataRepository.findOne(id);
    }

    @Override
    public UserData saveUserData(UserData userData) {
        return userDataRepository.save(userData);
    }

    @Override
    public void deleteAccount(Long id) {
        userDataRepository.delete(id);
    }
}
