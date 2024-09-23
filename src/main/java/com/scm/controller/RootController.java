//package com.scm.controller;
//
//import com.scm.entities.User;
//import com.scm.helpers.Helper;
//import com.scm.services.UserService;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@ControllerAdvice
//public class RootController {
//
//    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private UserService userService;
//
//    @ModelAttribute
//    public void addLoggedInUserInformation(Model model, Authentication authentication) {
//        System.out.println("Adding Logged in User information to the model");
//        String username = Helper.getEmailOfLoggedInUser(authentication);
//        logger.info("User Logged in  : {}", username);
//        User user = userService.getUserByEmail(username);
//        if (user != null) {
//
//        } else {
//            System.out.println(user.getName());
//            System.out.println(user.getEmail());
//            model.addAttribute("LoggedInUser", user);
//        }
//    }
//}
