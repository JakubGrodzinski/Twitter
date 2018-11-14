package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TweetRepository extends JpaRepository<Tweet, Long>
{
    @Query("select t from Tweet t order by t.created desc")
    List<Tweet> getCustomTweets();

    @Query("select t from Tweet t where t.user=:user order by t.created desc ")
    List<Tweet> getCustomTweetsByUser (@Param("user") User user);

    List<Tweet> getAllByUserIdOrderByCreatedDesc (Long id);


}
