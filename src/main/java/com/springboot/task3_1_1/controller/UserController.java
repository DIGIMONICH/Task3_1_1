package com.springboot.task3_1_1.controller;


import com.springboot.task3_1_1.model.User;
import com.springboot.task3_1_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping( "/")
    public String showAllUsers (Model model ) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "start";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users/";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "addPage";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users/";
    }
    @GetMapping("/updateUser")
    public String updateUser(@RequestParam(value = "id") long id, Model model) {

        model.addAttribute("user", userService.readUser(id));
        return "editPage";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") long id) {
        userService.deleteUser(id);

        return "redirect:/users/";
    }

}
