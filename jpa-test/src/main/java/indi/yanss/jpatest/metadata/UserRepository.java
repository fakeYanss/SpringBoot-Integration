package indi.yanss.jpatest.metadata;

import indi.yanss.jpatest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
