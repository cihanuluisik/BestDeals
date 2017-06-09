package com.bestdeals.returns.repository;

import com.bestdeals.returns.domain.Deal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  DealRepository extends CrudRepository<Deal, Integer>{

    List<Deal> findByClientId(Integer id);

}
