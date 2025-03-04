package com.ApiRest.ApiRest.Controllers;

import com.ApiRest.ApiRest.Entitys.Persona;
import com.ApiRest.ApiRest.Entitys.Usuario;
import com.ApiRest.ApiRest.Repository.PersonaRepository;
import com.ApiRest.ApiRest.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class ControllerBasic {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/insertar")
    public ResponseEntity<String> insertarPersona(@RequestBody Persona persona){
        System.out.println(persona.toString());
        personaRepository.save(persona);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Persona creado correctamente");

    }

    @PostMapping("/insertarusuario")
    public ResponseEntity<String> insertarUsuario(@RequestBody Usuario usuario){

        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");

    }
}
