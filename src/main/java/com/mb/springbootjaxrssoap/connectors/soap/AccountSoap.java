package com.mb.springbootjaxrssoap.connectors.soap;

import com.mb.springbootjaxrssoap.models.Account;
import com.mb.springbootjaxrssoap.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class AccountSoap {

    @Autowired
    AccountRepository accountRepository;

    @WebMethod(operationName = "findAccount")
    public Account getAccount(@WebParam(name = "id") Long id){
        return accountRepository.findById(id).get();
    }

    @WebMethod
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @WebMethod
    public Account create(@WebParam(name = "account") Account account ){
        return accountRepository.save(account);
    }

    @WebMethod
    public Account update(@WebParam(name = "id") Long id, @WebParam(name = "account") Account account ){
        accountRepository.findById(id).orElseThrow(NotFoundException::new);
        account.setId(id);
        return accountRepository.save(account);
    }

    @WebMethod
    public void delete(@WebParam(name = "id") Long id ){
        accountRepository.findById(id).orElseThrow(NotFoundException::new);
        accountRepository.deleteById(id);
    }
}
