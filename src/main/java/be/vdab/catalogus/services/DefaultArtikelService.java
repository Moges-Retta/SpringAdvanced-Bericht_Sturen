package be.vdab.catalogus.services;

import be.vdab.catalogus.domain.Artikel;
import be.vdab.catalogus.domain.ArtikelGemaaktTable;
import be.vdab.catalogus.events.ArtikelGemaakt;
import be.vdab.catalogus.repositories.ArtikelGemaaktRepository;
import be.vdab.catalogus.repositories.ArtikelRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
class DefaultArtikelService implements ArtikelService {
    private final ArtikelRepository repository;
    //private final AmqpTemplate template;
    private final ArtikelGemaaktRepository artikelGemaaktRepository;

    DefaultArtikelService(ArtikelRepository repository, ArtikelGemaaktRepository artikelGemaaktRepository) {
        this.artikelGemaaktRepository=artikelGemaaktRepository;
        this.repository = repository;
        //this.template = template;
    }

    @Override
    public void create(Artikel artikel) {
        repository.save(artikel);
        artikelGemaaktRepository.save(new ArtikelGemaaktTable(artikel));
        //template.convertAndSend("catalogus", null, new ArtikelGemaakt(artikel));
    }

    @Override
    public Optional<Artikel> findById(long id) {
        return repository.findById(id);
    }
}
