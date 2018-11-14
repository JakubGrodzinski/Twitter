package pl.coderslab.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.validatorGroups.FullValidation;
import pl.coderslab.validatorGroups.RegistrationValidation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(groups = FullValidation.class)
    @NotBlank(groups = FullValidation.class)
    private String username;

    @NotNull(groups = {FullValidation.class, RegistrationValidation.class})
    @NotBlank(groups = {FullValidation.class, RegistrationValidation.class})
    private String password;

    @NotNull(groups = {FullValidation.class})
    private boolean enabled;

    @NotNull(groups = {FullValidation.class, RegistrationValidation.class})
    @Email(groups = {FullValidation.class, RegistrationValidation.class})
    @NotBlank(groups = {FullValidation.class, RegistrationValidation.class})
    @Column(unique = true)
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tweet> tweets;

    @OneToMany
    private List<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
