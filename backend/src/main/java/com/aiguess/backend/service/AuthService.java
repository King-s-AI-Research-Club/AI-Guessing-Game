package com.aiguess.backend.service;
import com.aiguess.backend.dto.AuthRequest;
import com.aiguess.backend.model.User;
import com.aiguess.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service        //this says spring that this class contains logic
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String signup(AuthRequest request){
        //checking if username already exists
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            return "This Username is already taken";
        }

        //checking if email already exists
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return "This Email is already taken";
        }

        //Saving a new user to Database
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        return "Signup Successful";
    }

    public String signin(AuthRequest request){
        //finding the user by username
        User user = userRepository.findByUsername(request.getUsername()).orElse(null);

        if(user == null){
            return "User not found!";
        }

        if(!user.getPassword().equals(request.getPassword())){
            return "Wrong password, try again!";
        }

        return "Signin Successful";
    }

}
