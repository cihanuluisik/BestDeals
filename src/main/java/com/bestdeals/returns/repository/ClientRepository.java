package com.bestdeals.returns.repository;

import com.bestdeals.returns.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
