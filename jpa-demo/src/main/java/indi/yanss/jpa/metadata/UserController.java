package indi.yanss.jpa.metadata;

import java.util.List;

import indi.yanss.jpa.model.User;
import indi.yanss.jpa.model.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/save")
    public User saveUser(
            @RequestParam(value = "username", required = false, defaultValue = "test")
                    String username,
            @RequestParam(value = "password", required = false, defaultValue = "123456")
                    String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setState(UserState.NORMAL);
        return userRepository.save(user);//保存数据到数据表中，并返回
    }

    @GetMapping(value = "/get")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/get0")
    public List<User> findAllByState() {
        return userRepository.findAllByState(UserState.NORMAL);
    }

    @GetMapping(value = "/get1")
    public List<User> findAllByUserState() {
        return userRepository.findAllByUserState(0);
    }

    @GetMapping(value = "/get2")
    public List<User> findByStateNot() {
        return userRepository.findByStateNot(UserState.DELETED);
    }

    @GetMapping(value = "/get3")
    public User findByStateIn() {
        return userRepository.findByStateIn(UserState.VISIBLE_STATE);
    }
}