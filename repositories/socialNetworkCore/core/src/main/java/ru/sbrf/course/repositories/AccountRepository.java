package ru.sbrf.course.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.course.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
