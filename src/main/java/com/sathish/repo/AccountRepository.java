package com.sathish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sathish.entity.AccountEntity;
import com.sathish.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Serializable> {

	@Query(value = "select id from admin_tbl where id=:email", nativeQuery = true)
	public boolean checkMail(String email);
	
	 public Account findByPwd(String Pwd); 
}
