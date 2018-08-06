package lt.bt.messager.messanger.controller;


import lt.bt.messager.messanger.dto.User;
import lt.bt.messager.messanger.repository.UserRepository;
import lt.bt.messager.messanger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User createMessage(@RequestBody User user) {

        userService.createUser(user);

        return user;
    }

    @RequestMapping()
    public List<User> getUsers() {
        return userService.fetchUsers();
    }
}
