package com.example.jpa.SpringJpa.mvc;

import com.example.jpa.SpringJpa.aspect.LoggingControllerAdvice;
import com.example.jpa.SpringJpa.Exception.ConflictException;
import com.example.jpa.SpringJpa.Service.UserService;
import com.example.jpa.SpringJpa.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping
public class UserMvcController {
    @Autowired
    private final UserService userService;


    public UserMvcController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String displayUser(@RequestParam(value = "id") Long id, Model model) {
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/listusers")
    public ModelAndView displayAllUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("usersList", userService.findAllUsers());
        return modelAndView;
    }

    @PostMapping(value = "/addUser")
    public String addUser(User user, @RequestParam("file") MultipartFile file) {

        try {

            if(file!= null && !file.isEmpty()){
                System.out.println(file.getOriginalFilename());
               user = userService.register(user, file);
            }else{
                user = userService.register(user);
            }

        } catch (ConflictException e) {
            e.printStackTrace();
        }

        return "redirect:user?id=" + user.getId();
    }

    @GetMapping(value = "/addUser")
    public String addForm(User user, Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
//    @PostMapping (value="/addUser")
//    public String addImage (@RequestParam("image")MultipartFile file) throws IOException {
//        BufferedImage src= ImageIO.read(new ByteArrayInputStream(file.getBytes()));
//        File destination=new File("C:/SpringJpa/src/main/resources/uploads");
//        ImageIO.write (src, "png", destination);
//        return "users";
//    }

}
