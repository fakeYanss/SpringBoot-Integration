package indi.yanss.dls.metadata;

import indi.yanss.dls.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByName(String name);
}
