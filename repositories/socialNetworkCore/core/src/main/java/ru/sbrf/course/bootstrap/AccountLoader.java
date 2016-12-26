package ru.sbrf.course.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.sbrf.course.domain.Account;
import ru.sbrf.course.domain.UserData;
import ru.sbrf.course.domain.UserGroup;
import ru.sbrf.course.repositories.AccountRepository;
import ru.sbrf.course.repositories.UserGroupRepository;
import ru.sbrf.course.repositories.UserDataRepository;

import java.util.Iterator;
import java.util.Set;

@Component
public class AccountLoader implements ApplicationListener<ContextRefreshedEvent> {

    AccountRepository accountRepository;
    UserDataRepository userDataRepository;
    UserGroupRepository userGroupRepository;


    private Logger log = Logger.getLogger(AccountLoader.class);

    @Autowired
    public void setUserGroupRepository(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository, UserDataRepository userDataRepository) {
        this.accountRepository = accountRepository;
        this.userDataRepository = userDataRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UserData userDataAdmin = new UserData();
        userDataAdmin.setFirstName("Oleg");
        userDataRepository.save(userDataAdmin);

        Account admin = new Account();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setUserDataId(userDataAdmin.getId());
        accountRepository.save(admin);
        userDataAdmin.setAccountId(admin.getAccountId());
        userDataRepository.save(userDataAdmin);

        log.info("Saved admin - id: " + admin.getAccountId() + " admin data id: " + admin.getUserDataId());

        UserData userDataUser = new UserData();
        userDataUser.setFirstName("Gleb");
        userDataRepository.save(userDataUser);

        Account user = new Account();
        user.setLogin("user");
        user.setPassword("user");
        user.setUserDataId(userDataUser.getId());
        accountRepository.save(user);
        userDataUser.setAccountId(user.getAccountId());
        userDataRepository.save(userDataUser);

        log.info("Saved user - id:" + user.getAccountId() + " user data id: " + user.getUserDataId());


        UserData userDataUser2 = new UserData();
        userDataUser2.setFirstName("Gleb2");
        userDataRepository.save(userDataUser2);

        Account user2 = new Account();
        user2.setLogin("user2");
        user2.setPassword("user2");
        user2.setUserDataId(userDataUser2.getId());
        accountRepository.save(user2);
        userDataUser2.setAccountId(user2.getAccountId());
        userDataRepository.save(userDataUser2);

        log.info("Saved user2 - id:" + user2.getAccountId() + " user2 data id: " + user2.getUserDataId());



        UserGroup group = new UserGroup();
        group.setTitle("First");
        group.getUserDataSet().add(userDataAdmin);
        userDataAdmin.getGroupSet().add(group);
        userDataRepository.save(userDataAdmin);
        //userGroupRepository.save(group);

        log.info("Create group - id: " + group.getGroupId()+ " with title = " + group.getTitle());

        UserGroup group2 = new UserGroup();
        group2.setTitle("Second");
        group2.getUserDataSet().add(userDataUser);
        group2.getUserDataSet().add(userDataUser2);
        userDataUser.getGroupSet().add(group2);

        Set<UserData> userDataSet = group2.getUserDataSet();
         Iterator iterator = userDataSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        userDataRepository.save(userDataUser);
        userDataRepository.save(userDataUser2);
        //userGroupRepository.save(group2);

        userDataSet = group2.getUserDataSet();
        iterator = userDataSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        log.info("Create group2 - id: " + group2.getGroupId() + " with title = " + group2.getTitle());
    }
}
