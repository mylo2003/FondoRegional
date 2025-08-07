package com.backend.FondoRegional.persistance.jpa;

import com.backend.FondoRegional.persistance.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemJPA extends JpaRepository<Item,Integer> {
}
