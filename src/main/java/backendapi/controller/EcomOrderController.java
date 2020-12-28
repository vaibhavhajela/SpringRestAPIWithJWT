package backendapi.controller;

import backendapi.model.EcomOrder;
import backendapi.model.UserAuthTokenEntity;
import backendapi.service.AuthenticationService;
import backendapi.service.EcomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavhajela on 27/12/20.
 */
@RestController
@RequestMapping("/api")
public class EcomOrderController {

    @Autowired
    EcomOrderService ecomOrderService;

    @Autowired
    AuthenticationService authenticationService;

    //http://localhost:8080/api/ecomorders
    @RequestMapping( method = RequestMethod.GET, value ="/ecomorders")
    public List<EcomOrder> getEcomOrders(@RequestHeader("authorization") String authorization,
                                         @RequestParam String username){

        if (authenticationService.isAuthorized(username,authorization)){
            return ecomOrderService.getEcomOrders();
        }

        return null;
    }

    @RequestMapping( method = RequestMethod.POST, value="/login")
    public String login(@RequestHeader("authorization") String authorization) throws Exception{
        //username:password
        String[] userpass = authorization.split(":");
        String user = userpass[0];
        String pass = userpass[1];

        UserAuthTokenEntity userAuthToken = authenticationService.authenticate(user,pass);
        return userAuthToken.getToken();

    }
}
