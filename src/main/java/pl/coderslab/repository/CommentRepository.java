package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Comment;
import pl.coderslab.model.Tweet;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long>
{
    List<Comment> findAllByTweetOrderByCreatedDesc (Tweet tweet);
    List<Comment> findAllByTweetIdOrderByCreatedDesc (Long id);
}
