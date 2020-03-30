package com.course.HelloSpring2.dao;

import com.course.HelloSpring2.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {
}
