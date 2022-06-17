package com.rapsShopping.shopping.services;

import com.rapsShopping.shopping.dtos.UserDTO;
import com.rapsShopping.shopping.models.EUser;
import com.rapsShopping.shopping.repositories.UserRepository;
import com.rapsShopping.shopping.successPOJO.SuccessPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SUser {

    private final UserRepository userRepository;

    @Autowired
    public SUser(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    //GET all users
    public List<UserDTO> fetchUsers(){
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //Add user
    public ResponseEntity<SuccessPOJO> signUp(UserDTO userDTO){

        System.out.println("User is: " + userDTO);

        String hashed = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(4));

        EUser eUser = new EUser();
        eUser.setUsername(userDTO.getUsername());
        eUser.setPassword(hashed);

        userRepository.save(eUser);

        return new ResponseEntity<>(new SuccessPOJO("Successfully added user!"), HttpStatus.OK);
    }

    //Login
    public ResponseEntity<SuccessPOJO> login(UserDTO userDTO) throws Exception {

        EUser eUser = userRepository.fetchUserByUsername(userDTO.getUsername());
        if(eUser == null){
            throw new Exception("User not found!");
        }else{
            if(!BCrypt.checkpw(userDTO.getPassword(),eUser.getPassword())){
                throw new Exception("Wrong password!");
            }else{
                return new ResponseEntity<>(new SuccessPOJO("Successfully logged in!", true), HttpStatus.OK);
            }
        }
    }

    //Convert to UserDTO
    private UserDTO convertToDTO(EUser eUser){
        return new UserDTO(eUser);
    }

}
