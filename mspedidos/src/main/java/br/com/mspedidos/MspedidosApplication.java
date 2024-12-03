package br.com.mspedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MspedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspedidosApplication.class, args);
    }

}
