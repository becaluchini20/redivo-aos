package com.rev.revisao.controller;

import com.rev.revisao.dto.UserDto;
import com.rev.revisao.model.User;
import com.rev.revisao.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//
@RequestMapping("/api/users") //define o caminho base q sera utilizado
public class UserController {

    
    private UserRepository userRepository;
    //cria um novo usuario(post)
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) { //cria uma entidade string
        if (userRepository.existsByEmail(userDto.getEmail())) { // busca o novo usuario pelo email, caso o email já esteja em uso, envia um aviso
            return ResponseEntity.badRequest().body("Email already in use.");
        }
        // usuario criado com nome e email e salvo
        User user = new User(userDto.getName(), userDto.getEmail());
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully.");
    }
    //lista os usuarios que foram buscados no repositorio
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //esta buscando o usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) { //busca o usuario atraves do id dele pelo repositorio, caso nao ache, ele cria uma entidade de resposta notfound
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
//Procuramos um usuario non qual, caso seja achado, podemos alterar para um novo 
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) { //recebe o id do usuario junto com os novos dados (nome e email)
        return userRepository.findById(id) //tenta buscar o id no bando de dados
                .map(user -> { 
                    user.setName(userDto.getName());
                    user.setEmail(userDto.getEmail()); //atualiza os dados desse usuario
                    userRepository.save(user); // salva os dados atualizados 
                    return ResponseEntity.ok("User updated.");
                })
                .orElse(ResponseEntity.notFound().build()); //usuario nao foi encontrado, entao nao pode ser atualizado 
    }
    // deleta o usuario mapeado atraves do id
    @DeleteMapping("/{id}") //esta chamando um metodo (delete)
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) { //ele verifica se o usuario com esse id existe no banco de dados
            return ResponseEntity.notFound().build(); // ele indica que o usuario nn foi encontrado
        }
        userRepository.deleteById(id); 
        return ResponseEntity.ok("User deleted."); //caso o usuario exista, ele é deletado e é enviado essa mensagem 
    }
}

