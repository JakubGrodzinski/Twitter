package pl.coderslab.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.User;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>
{
   User getUserByEmail(String email);
}
