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

    public boolean check (String logging, String inDatabase)
    {
        return BCrypt.checkpw(logging, inDatabase);
    }

}
