package com.pillopl.messaging.card.infrastructure;

import java.time.Instant;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Jakub Pilimon
 */
interface DomainEventStorage extends CrudRepository<StoredDomainEvent, Long> {
    List<StoredDomainEvent> findAllBySentOrderByTimestampDesc(boolean sent);
}

/**
 * @author Jakub Pilimon
 */
@Entity
class StoredDomainEvent {

    @Id @GeneratedValue Long id;
    private String content;
    private boolean sent;
    private Instant timestamp = Instant.now();

    StoredDomainEvent(String content) {
        this.content = content;
    }

    private StoredDomainEvent() {
    }

    void sent() {
        sent = true;
    }

    String getContent() {
        return content;
    }
}