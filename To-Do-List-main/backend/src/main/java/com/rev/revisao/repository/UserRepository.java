//essa pasta guarda as interfaces que fazem a comunicação com o bd

package com.rev.revisao.repository;

import com.rev.revisao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { //está criando uma interface chamada userrepository e dizendo que ela herda de jparepository
    boolean existsByEmail(String email); //cria uma consulta que verifica se existe um usuario com o email informado
}
//o jpa é uma interface que facilita acessar e manipular dados no bd de forma simples
