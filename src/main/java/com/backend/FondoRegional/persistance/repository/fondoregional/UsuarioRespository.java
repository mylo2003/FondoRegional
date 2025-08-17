package com.backend.FondoRegional.persistance.repository.fondoregional;

import com.backend.FondoRegional.persistance.entity.fondoregional.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {
}
