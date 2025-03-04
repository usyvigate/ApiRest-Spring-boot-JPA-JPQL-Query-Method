package com.ApiRest.ApiRest.Repository;

import com.ApiRest.ApiRest.Entitys.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
