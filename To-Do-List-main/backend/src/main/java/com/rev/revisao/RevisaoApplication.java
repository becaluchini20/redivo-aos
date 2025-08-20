package com.rev.revisao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // classe principal da aplicação springboot (configura o spring, configura tudo automaticamente, encontra seus componentes no projeto)
public class RevisaoApplication {

	public static void main(String[] args) { // metodo principal publico e estático que inicia a aplicação, recebe argumentos e nn retorna nada

		SpringApplication.run(RevisaoApplication.class, args); // O metodo run cria o contexto do spring, configura os componentes e inicia o servidor
	}

}
