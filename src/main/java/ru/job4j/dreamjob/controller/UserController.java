package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam("email") String email,
                                 @RequestParam("name") String name,
                                 @RequestParam("password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        userService.save(user);

        ModelAndView modelAndView = new ModelAndView("redirect:/users/register");
        return modelAndView;
    }
}
