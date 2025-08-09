package com.backend.FondoRegional.domain.service;

import com.backend.FondoRegional.persistance.entity.VistaFondoRegional;
import org.springframework.data.jpa.domain.Specification;

public class VistaFondoRegionalSpecs {
    public static Specification<VistaFondoRegional> buscarEnTodo(String search) {
        return (root, query, cb) -> {
            if (search == null || search.isBlank()) {
                return cb.conjunction();
            }

            String pattern = "%" + search.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("title")), pattern),
                    cb.like(cb.lower(root.get("author")), pattern),
                    cb.like(cb.lower(root.get("abstractText")), pattern)
            );
        };
    }
}
