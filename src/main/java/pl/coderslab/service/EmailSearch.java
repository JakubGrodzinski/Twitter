package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.repository.UserRepository;

@Service
public class EmailSearch
{
    @Autowired
    private UserRepository userRepository;

    public boolean isInDatabase (String email)
    {
        if(userRepository.getUserByEmail(email) == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
