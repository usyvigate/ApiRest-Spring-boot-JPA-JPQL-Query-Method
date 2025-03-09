package com.ApiRest.ApiRest.Controllers;

import com.ApiRest.ApiRest.Entitys.Persona;
import com.ApiRest.ApiRest.Entitys.Usuario;
import com.ApiRest.ApiRest.Repository.PersonaRepository;
import com.ApiRest.ApiRest.Repository.UsuarioRepository;
import com.ApiRest.ApiRest.Services.PersonaService;
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

    @GetMapping("/mostrarpersona")
    public ResponseEntity<?> mostrarPersonas(){
        return ResponseEntity.ok(personaRepository.findAll());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> EliminarPersona(@PathVariable Long id){
        if(personaRepository.existsById(id)){
            personaRepository.deleteById(id);
            return ResponseEntity.ok("Eliminado correctamente");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se proceso correctamente");
        }
    }

    @PostMapping("/insertarusuario")
    public ResponseEntity<String> insertarUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
    }

    @GetMapping("/mostrarusuarios")
    public ResponseEntity<?> mostrarUsuarios(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @DeleteMapping("/eliminarusuario/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Eliminado Correctamente");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el registro");
        }
    }

    @GetMapping("/nombrepersonas")
    public ResponseEntity<?> obtenerNombre(){
        return ResponseEntity.ok(personaRepository.listNombre());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario){
       Usuario encontrar = usuarioRepository.findByNombreAndPassword(
               usuario.getNombre(), usuario.getPassword());
       if (encontrar != null){
           return ResponseEntity.ok(encontrar.getPersona());
       }else{
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales de acceso incorrectas");
       }
    }
}
