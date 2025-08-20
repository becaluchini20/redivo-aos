package com.rev.revisao.dto;
//construtor
public class UserDto {
    
    private String name;
    private String email; //atributos da classe

    public UserDto() {}

    public UserDto(String name, String email) { //aqui o construtos esta com os parametros, permite criar um usuariocom nome e email definido
        this.name = name;
        this.email = email;
    }
    //getters e setters
    public String getName() { return name; } 

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; } 
    /*
    get- retornam os valores atuais
    set- permitem alterar os valores */
}

