package com.mb.springbootjaxrssoap.connectors.rs;

import com.mb.springbootjaxrssoap.models.Account;
import com.mb.springbootjaxrssoap.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/accounts")
public class AccountRS {

    @Autowired
    AccountRepository accountRepository;


    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Account getAccount(@PathParam("id") Long id){
        return accountRepository.findById(id).get();
    }

    @Path("")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @Path("")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Account create(Account account ){
        return accountRepository.save(account);
    }

    @Path("/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Account update(@PathParam("id") Long id,Account account ){
        accountRepository.findById(id).orElseThrow(NotFoundException::new);
        account.setId(id);
        return accountRepository.save(account);
    }

    @Path("/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id ){
        accountRepository.findById(id).orElseThrow(NotFoundException::new);
        accountRepository.deleteById(id);
    }



}
