package ru.itgirls.SPRING_PROJECT_1.controller;

import org.springframework.web.bind.annotation.*;
import ru.itgirls.SPRING_PROJECT_1.entity.User;
import ru.itgirls.SPRING_PROJECT_1.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(
            @PathVariable Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String name
    ) {
        userService.update(id, email, name);
    }
}
