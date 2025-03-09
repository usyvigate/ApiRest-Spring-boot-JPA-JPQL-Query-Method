package com.ApiRest.ApiRest.Repository;

import com.ApiRest.ApiRest.Entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreAndPassword(String nombre, String password);
}
