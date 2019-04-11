package indi.yanss.jpatest.metadata;

import indi.yanss.jpatest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/save")
    public User saveUser(@RequestParam(value = "username", required = false, defaultValue = "test") String username,
                         @RequestParam(value = "password", required = false, defaultValue = "123456") String password) {
        User user = new User(username, password);
        return userRepository.save(user);//保存数据到数据表中，并返回
    }

    @GetMapping(value = "/get")
    public List<User> getUser() {
        return userRepository.findAll();
    }
}