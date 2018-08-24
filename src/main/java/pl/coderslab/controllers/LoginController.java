package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.EmailSearch;
import pl.coderslab.service.HashPassword;
import pl.coderslab.validatorGroups.RegistrationValidation;

@Controller
@SessionAttributes("loggedUser")
public class LoginController
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    HashPassword hashPassword;

    @Autowired
    EmailSearch emailSearch;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage (Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logInUser(Model model, @Validated({RegistrationValidation.class}) User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "login";
        }
        else
        {
            User user1 = userRepository.getUserByEmail(user.getEmail());
            if(hashPassword.check(user.getPassword(), user1.getPassword()))
            {
                model.addAttribute("loggedUser", user);
                return "redirect:/main";
            }
            else
            {
                return "login";
            }
        }

    }


    @RequestMapping("/registration")
    public String registerPage (Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser (@Validated({RegistrationValidation.class}) User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "register";
        }
        else
        {
            if(emailSearch.isInDatabase(user.getEmail()))
            {
                return "register";
            }
            else
            {
                user.setPassword(hashPassword.hash(user.getPassword()));
                userRepository.save(user);
                return "redirect:/login";
            }
        }
    }
}
