package indi.yanss.dls.metadata;

import java.text.SimpleDateFormat;
import java.util.Date;

import indi.yanss.dls.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventTimer {

    public static final String EVENT_NAME = "event test";

    @Autowired
    private EventLock lock;

    @Scheduled(fixedDelay = 1000 * 10)
    public void eventTest() throws InterruptedException {

        Event event = lock.acquire(EVENT_NAME);

        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(now);

        System.out.println(nowTime + " running here.");
        Thread.sleep(5000);

        lock.release(event);
    }
}
