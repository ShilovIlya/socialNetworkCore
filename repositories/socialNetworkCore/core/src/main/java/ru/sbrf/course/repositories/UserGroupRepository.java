package ru.sbrf.course.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.course.domain.UserGroup;

public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {
}
