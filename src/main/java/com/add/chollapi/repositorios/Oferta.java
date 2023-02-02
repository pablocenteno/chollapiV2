package com.add.chollapi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Oferta extends JpaRepository<Oferta, Long> {
}
