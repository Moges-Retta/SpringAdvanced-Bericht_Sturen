package be.vdab.catalogus.messaging;

import be.vdab.catalogus.domain.ArtikelGemaaktTable;
import be.vdab.catalogus.events.ArtikelGemaakt;
import be.vdab.catalogus.repositories.ArtikelGemaaktRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@Component
class MessageSender {
    private final ArtikelGemaaktRepository repository;
    private final AmqpTemplate template;

    MessageSender(ArtikelGemaaktRepository repository, AmqpTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    @Scheduled(fixedDelay = 5_000)
    @Transactional
    void verstuurMessages() {
        var artikelsGemaakt = repository.findAll();
        for (ArtikelGemaaktTable gemaakt : artikelsGemaakt) {
            template.convertAndSend("catalogus", null, gemaakt);
        }
        repository.deleteAll(artikelsGemaakt);
    }
}
