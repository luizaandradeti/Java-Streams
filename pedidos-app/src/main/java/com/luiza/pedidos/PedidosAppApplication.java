package com.luiza.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PedidosAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosAppApplication.class, args);
	}

}
