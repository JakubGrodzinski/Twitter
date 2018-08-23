package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HashPassword
{
    public String hash (String password)
    {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
