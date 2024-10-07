package com.nt.bindings;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserBinding {
	private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Role role;
    
   
 
}
