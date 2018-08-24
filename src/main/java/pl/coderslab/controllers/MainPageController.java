package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class MainPageController
{

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(Model model, HttpSession session)
    {
        User user = (User) session.getAttribute("loggedUser");
        if(user == null)
        {
            return "redirect:/login";
        }
        else
        {
            Tweet tweet = new Tweet();
            model.addAttribute("tweet", tweet);
            return "main";
        }

    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String mainPagePost(HttpSession session, @Valid Tweet tweet, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "main";
        }

        tweet.setCreated(new Date());
        User user = (User)session.getAttribute("loggedUser");
        User user1 = userRepository.getUserByEmail(user.getEmail());
        tweet.setUser(user1);
        tweetRepository.save(tweet);
        return "redirect:/main";
    }

    @ModelAttribute("allTweets")
    public List<Tweet> tweets ()
    {
        return tweetRepository.getCustomTweets();
    }
}
