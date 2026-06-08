package com.sena.database_connection.dtos;

import com.sena.database_connection.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private String username;
    private String description;
    private User user;
    
}