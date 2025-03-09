package com.ApiRest.ApiRest.Services;

import com.ApiRest.ApiRest.Repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<String> obtenerNombre(){
        return personaRepository.listNombre();
    }
}
