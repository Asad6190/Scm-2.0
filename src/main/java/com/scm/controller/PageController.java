package com.scm.controller;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home() {
        System.out.println("Home Page handler");
        return "home";
    }

    @GetMapping("/services")
    public String services() {
        System.out.println("Services Page handler");
        return "services";
    }

    @GetMapping("/about")
    public String about() {
        System.out.println("About Page handler");
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        System.out.println("Contact Page handler");
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Login Page handler");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();

        model.addAttribute("userForm", userForm);
        System.out.println("Register Page handler");
        return "register";
    }

    //processing form
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, HttpSession session) {


        System.out.println("Process Register Page");
        //fetch form data

        //validate form data
        if (bindingResult.hasErrors()){
            return "register";
        }


        //save to database
//        UserForm --> User

        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .about(userForm.getAbout())
                .phoneNumber(userForm.getPhoneNumber())
                .profilePic("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vecteezy.com%2Ffree-vector%2Fdefault-profile-picture&psig=AOvVaw0nAabHFYNXOQhxYVKw9cV_&ust=1723717172242000&source=images&cd=vfe&opi=89978449&ved=0CBcQjhxqFwoTCLi7ioGh9IcDFQAAAAAdAAAAABAE")
                .build();

//        User user = new User();
//        user.setName(userForm.getName());
//        user.setEmail(userForm.getEmail());
//        user.setPassword(userForm.getPassword());
//        user.setAbout(userForm.getAbout());
//        user.setPhoneNumber(userForm.getPhoneNumber());
//        user.setProfilePic("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vecteezy.com%2Ffree-vector%2Fdefault-profile-picture&psig=AOvVaw0nAabHFYNXOQhxYVKw9cV_&ust=1723717172242000&source=images&cd=vfe&opi=89978449&ved=0CBcQjhxqFwoTCLi7ioGh9IcDFQAAAAAdAAAAABAE");
        User savedUser = userService.saveUser(user);
        System.out.println("User Saved!");

        //message="Registration Success"

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);


        //redirected to
        return "redirect:/register";
    }
}
