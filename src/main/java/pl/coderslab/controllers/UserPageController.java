package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserPageController
{
    @Autowired
    TweetRepository tweetRepository;

    @RequestMapping("/userPage")
    public String showUserPage()
    {
        //TODO
        return "fdd";
    }


    @ModelAttribute("tweetsByUser")
    public List<Tweet> getTweetsByUser (HttpSession session)
    {
        return tweetRepository.getCustomTweetsByUser((User)session.getAttribute("loggedUser"));
    }
}
