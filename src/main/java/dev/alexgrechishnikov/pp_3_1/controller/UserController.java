package dev.alexgrechishnikov.pp_3_1.controller;

import dev.alexgrechishnikov.pp_3_1.model.User;
import dev.alexgrechishnikov.pp_3_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(ModelMap model) {
        List<User> users = userService.getUsersList();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/{id}")
    public String getUser(ModelMap model, @PathVariable(name = "id") long id) {
        User user = userService.get(id);
        model.addAttribute(user);
        return "user";
    }

    @GetMapping(value = "/new")
    public String getNewUser(@ModelAttribute("user")User user) {
        return "new";
    }


    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String getEditUser(ModelMap modelMap, @PathVariable("id") long id) {
        modelMap.addAttribute("user", userService.get(id));
        return "edit";
    }

    @PatchMapping()
    public String updateUser(@ModelAttribute(name = "user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute(name = "user") User user, @PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}