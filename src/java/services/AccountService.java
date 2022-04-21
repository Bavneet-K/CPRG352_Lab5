package services;
import org.apache.catalina.User;
/**
 *
 * @author Bavneet
 */
public class AccountService {
    
    public User login(String username, String password){
        
        if(username == "abe" || username == "abe" && password == "password"){
             
            return new User(username, null);
        }
        else 
                return null;
        
        
    }
}
