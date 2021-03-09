package com.mb.springbootjaxrssoap;

import com.mb.springbootjaxrssoap.models.Account;
import com.mb.springbootjaxrssoap.models.Customer;
import com.mb.springbootjaxrssoap.models.TypeAccount;
import com.mb.springbootjaxrssoap.repositories.AccountRepository;
import com.mb.springbootjaxrssoap.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringBootJaxrsSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJaxrsSoapApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository accountRepository, CustomerRepository customerRepository){
        return args -> {

            Customer bedril = customerRepository.save(new Customer(null, "Bedril", "bedril@hotmail.com", null));
            Customer emmanuel = customerRepository.save(new Customer(null, "Emmanuel", "emmanuel@hotmail.com", null));
            accountRepository.save(new Account(null,"Code1",new Date(), TypeAccount.CURRENT,bedril));
            accountRepository.save(new Account(null,"Code2",new Date(), TypeAccount.CURRENT,emmanuel));
            accountRepository.save(new Account(null,"Code3",new Date(), TypeAccount.SAVINGS,bedril));


        };
    }

}
