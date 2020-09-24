package be.vdab.catalogus.repositories;

import be.vdab.catalogus.domain.ArtikelGemaaktTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikelGemaaktRepository extends JpaRepository<ArtikelGemaaktTable,Long> {
}
