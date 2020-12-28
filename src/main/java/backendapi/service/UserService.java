package backendapi.service;


import backendapi.model.UserEntity;
import backendapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vaibhavhajela on 27/12/20.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity getUser(String username){
        return userRepository.findByUsername(username);
    }
}
