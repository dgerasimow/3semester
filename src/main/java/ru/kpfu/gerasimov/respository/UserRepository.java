package ru.kpfu.gerasimov.respository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.gerasimov.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
