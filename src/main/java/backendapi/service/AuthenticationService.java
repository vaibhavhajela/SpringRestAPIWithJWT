package backendapi.service;



import backendapi.model.UserAuthTokenEntity;
import backendapi.repository.UserAuthTokenRepository;
import backendapi.repository.UserRepository;
import backendapi.model.UserEntity;
import backendapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthTokenRepository userAuthTokenRepository;

    @Autowired
    private UserService userService;


    @Transactional
    public UserAuthTokenEntity authenticate(final String username, final String password) throws Exception {
        UserEntity userEntity = userService.getUser(username);

        if(userEntity == null){
            throw new Exception( "User not found");
        }

        if(password.equals(userEntity.getPassword())){
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(password);
            UserAuthTokenEntity userAuthToken = new UserAuthTokenEntity();
            userAuthToken.setUsername(userEntity.getUsername());
            userAuthToken.setToken(jwtTokenProvider.generateToken(userEntity.getUsername()));

            userAuthTokenRepository.save(userAuthToken);

            return userAuthToken;
        }
        else{
            throw new Exception("Password Failed");
        }

    }

    @Transactional
    public boolean isAuthorized(String username, String authorization) {
        UserAuthTokenEntity userAuthTokenEntity = userAuthTokenRepository.findByUsername(username);
        return userAuthTokenEntity!=null && userAuthTokenEntity.getToken().equals(authorization);
    }


}
