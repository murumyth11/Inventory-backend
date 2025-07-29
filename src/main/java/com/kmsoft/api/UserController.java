package com.kmsoft.api;

import com.kmsoft.model.User;
import com.kmsoft.repository.UserRepository;
import com.kmsoft.security.AuthResponse;
import com.kmsoft.security.JwtUtil;
import com.kmsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.webauthn.api.AuthenticatorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class UserController {

    @Autowired
    UserService registerationService;

    @Autowired
    UserRepository registrationrepo;

    @Autowired
    private JwtUtil jwtUtil;

//    @Autowired
//    private AuthenticationManager authManager;

    /// /@CrossOrigin("*")
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {

        String tempemail = user.getUserEmail();
        if (tempemail != null && !"".equals(tempemail)) {
            Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(tempemail);
            User userObj = null;
            if (matcher.matches()) {
                userObj = registerationService.fetchByemail(tempemail);
            } else {
                throw new Exception("Inavlid email address");
            }
            if (userObj != null) {
                throw new Exception("User with " + tempemail + "already exist");
            }
        }

        User userreg = registrationrepo.findByRoles("admin");

        User userobj = null;
        if (userreg == null) {
            userobj = registrationrepo.save(user);
        } else {
            throw new Exception("user already registered");
        }
        return userobj;

    }

    //@CrossOrigin("*")
    @PostMapping("/registerRole")
    public User registerRole(@RequestBody User user) throws Exception {
        String tempUserName = user.getUserName();
        if (tempUserName != null && !"".equals(tempUserName)) {

            User userObj = registerationService.fetchByusername(tempUserName);
            if (userObj != null) {
                throw new Exception("User with " + tempUserName + "already exist");
            }
        }
        User userobj = null;
        userobj = registrationrepo.save(user);
        return userobj;

    }

    //@CrossOrigin("*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws Exception {


        String tempusername = user.getUserName();
        String temppassword = user.getPassword();

        User userObj = null;

        if (temppassword != null && tempusername != null) {

            userObj = registerationService.findByUserNameAndPassword(tempusername, temppassword);
        } else {
            throw new Exception("wrong credentials");
        }

        final String jwt = jwtUtil.generateToken(user);
        AuthResponse response = new AuthResponse();
        response.setToken(jwt);
        response.setUsername(userObj.getUserName());
       // response.setEmail(userDetails.getEmail());
        response.setRoles(userObj.getRoles());
        return ResponseEntity.ok(response);
    }

    //@CrossOrigin("*")
    @GetMapping("/userRoles")
    public List<User> getAllUser() {
        return registrationrepo.findAll();
    }

    //@CrossOrigin("*")
    @DeleteMapping("/userRoles/delete/{id}")
    public void deleteUserRole(@PathVariable int id) {
        registrationrepo.deleteById(id);
    }

}
