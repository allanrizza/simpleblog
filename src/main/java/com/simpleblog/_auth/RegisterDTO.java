package com.simpleblog._auth;

public record RegisterDTO(String username, String email, String password, RoleEnum role) {

}
