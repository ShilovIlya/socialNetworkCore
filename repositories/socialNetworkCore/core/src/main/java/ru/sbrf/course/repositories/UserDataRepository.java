package ru.sbrf.course.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.course.domain.UserData;

public interface UserDataRepository  extends CrudRepository<UserData, Long> {
}

