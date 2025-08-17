package com.backend.FondoRegional.repository.fondoregional;

import com.backend.FondoRegional.entity.fondoregional.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {
}
