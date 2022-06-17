package com.rapsShopping.shopping.controllers;

import com.rapsShopping.shopping.dtos.UserDTO;
import com.rapsShopping.shopping.services.SUser;
import com.rapsShopping.shopping.successPOJO.SuccessPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/raps/users")
public class CUser {

    private final SUser sUser;

    @Autowired
    public CUser(SUser sUser) {
        super();
        this.sUser = sUser;
    }

    @GetMapping(path = "/fetchUsers")
    public List<UserDTO> fetchUsers(){
        return sUser.fetchUsers();
    }

    @PostMapping(path = "/signUp")
    public ResponseEntity<SuccessPOJO> signUp(@RequestBody UserDTO userDTO){
        return sUser.signUp(userDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<SuccessPOJO> login(@Valid @RequestBody UserDTO userDTO) throws Exception {
        return sUser.login(userDTO);
    }

}
