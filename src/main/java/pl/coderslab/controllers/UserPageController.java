package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserPageController
{
    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/userPage")
    public String showUserPage()
    {
        return "user";
    }


    @ModelAttribute("tweetsByUser")
    public List<Tweet> getTweetsByUser (HttpSession session)
    {
        User user = ((User)session.getAttribute("loggedUser"));
        User user1 = userRepository.getUserByEmail(user.getEmail());
        return tweetRepository.getCustomTweetsByUser(user1);
    }
}
