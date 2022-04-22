package com.example.Jalkapallo.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface OtteluRepository extends CrudRepository <Ottelu, Long> {
	
	List<Ottelu> findById(int Id);


}
