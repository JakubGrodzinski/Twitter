package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Comment;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class SingleTweetController
{
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/tweet/{id}", method = RequestMethod.GET)
    public String singleTweet (Model model, @PathVariable Long id)
    {
        Comment comment = new Comment();
        Tweet tweet = tweetRepository.findOne(id);
        List<Comment> comments = commentRepository.findAllByTweetIdOrderByCreatedDesc(id);
        model.addAttribute("tweet", tweet);
        model.addAttribute("comment", comment);
        model.addAttribute("comments", comments);
        return "singletweet";
    }

    @RequestMapping(value = "/tweet/{id}", method = RequestMethod.POST)
    public String addComment (@Valid Comment comment, @PathVariable Long id, HttpSession session, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "singletweet";
        }
        User user = (User)session.getAttribute("loggedUser");
        User user1 = userRepository.getUserByEmail(user.getEmail());
        comment.setUser(user1);
        comment.setTweet(tweetRepository.findOne(id));
        comment.setCreated(new Date());
        commentRepository.save(comment);
        return "redirect:/tweet/" + id;
    }
}
