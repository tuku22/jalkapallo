package com.example.Jalkapallo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KenttaRepository extends CrudRepository <Kentta, Long> {

	List<Kentta> findById (int kenttaid);
}
