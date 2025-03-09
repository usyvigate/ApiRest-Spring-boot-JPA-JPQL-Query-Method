package com.ApiRest.ApiRest.Repository;

import com.ApiRest.ApiRest.Entitys.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("SELECT p.nombre From Persona p")
    List<String> listNombre();
}
