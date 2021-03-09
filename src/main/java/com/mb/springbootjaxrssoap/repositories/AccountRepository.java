package com.mb.springbootjaxrssoap.repositories;

import com.mb.springbootjaxrssoap.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository  extends JpaRepository<Account,Long> {
}
