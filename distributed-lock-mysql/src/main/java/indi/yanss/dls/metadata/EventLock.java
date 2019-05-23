package indi.yanss.dls.metadata;

import java.util.Date;

import indi.yanss.dls.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventLock {

    @Autowired
    private EventRepository eventRepository;

    public Event acquire(String name) {
        Event event = eventRepository.findByName(name);

        if (event == null) {
            // 没有事件，注册
            event = new Event().setName(name).setStartTime(new Date());
            eventRepository.save(event);
        } else if (event.getFinishTime() == null) {
            // 事件在运行
            throw new RuntimeException("Lock has been acquired.");
        } else if (event.getFinishTime().before(new Date())) {
            // 上一个事件已经完成，开始新事件
            int id = event.getId();
            event = new Event().setId(id).setName(name).setStartTime(new Date());
            eventRepository.save(event);
        }
        return event;
    }

    public void release(Event event) {
        eventRepository.save(event.setFinishTime(new Date()));
    }
}
