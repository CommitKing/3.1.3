package springApp.SpringSecApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springApp.SpringSecApp.model.User;
import springApp.SpringSecApp.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String user(Model model, @RequestParam int id) {
        User user = userService.findUserByIdWithRole(id);
        model.addAttribute("user", user);
        return "user/profile";
    }
}