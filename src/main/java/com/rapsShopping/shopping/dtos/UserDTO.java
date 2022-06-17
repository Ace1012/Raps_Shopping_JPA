package com.rapsShopping.shopping.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rapsShopping.shopping.models.EUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;

    @NotNull(message = "Must have a username")
    @NotBlank(message = "Must not be blank")
    private String username;

    @NotNull(message = "Must have a username")
    @NotBlank(message = "Must not be blank")
    private String password;

    public UserDTO(EUser eUser) {
        this.id = eUser.getId();
        this.username = eUser.getUsername();
        this.password = eUser.getPassword();
    }
}
