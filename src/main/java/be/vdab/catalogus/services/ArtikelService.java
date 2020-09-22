package be.vdab.catalogus.services;

import be.vdab.catalogus.domain.Artikel;

import java.util.Optional;

public interface ArtikelService {
    void create(Artikel artikel);
    Optional<Artikel> findById(long id);
}
