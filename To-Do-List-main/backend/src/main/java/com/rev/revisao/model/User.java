//serve para organizar as classes que representam as entidades principais do seu sistema (objetos q refletem no bd)

package com.rev.revisao.model;

import jakarta.persistence.*;

@Entity //uma entidade/ uma representaçao de uma tabela em um bd
@Table(name = "users") //essa entidade será mapeada para a tabela de usuarios
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //esta definindo o id como chave primaria dentro da tabela

    private String name; //uma coluna na tabela para o nome do usuario

    @Column(unique = true)
    private String email; //uma tabela para email do usuario, porem nn pode ter dois usuarios com o mesmo email pois ele é unico

    // Construtor
    public User() {

    public User(String name, String email) {
        this.name = name;
        this.email = email; // facilita a criação de um usuario, ja passando o nome e o email
    }

    // Getters e setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
 /*
    get- retornam os valores atuais

    set- permitem alterar os valores */

