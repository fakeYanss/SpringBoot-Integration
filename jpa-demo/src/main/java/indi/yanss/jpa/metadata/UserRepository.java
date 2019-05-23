package indi.yanss.jpa.metadata;

import java.util.List;

import indi.yanss.jpa.model.User;
import indi.yanss.jpa.model.UserState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByState(UserState userState);

    // 原生查询，枚举类型需要用 int 传入
    @Query(value = "select * from #{#entityName} where state = :userState", nativeQuery = true)
    List<User> findAllByUserState(int userState);

    List<User> findByStateNot(UserState userState);

    User findByStateIn(List<UserState> states);

}
