package com.fiftyfive.springboot;

import com.fiftyfive.springboot.entities.WikimediaData;
import com.fiftyfive.springboot.repositories.WikimediaDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataBaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDataBaseConsumer.class);
    private WikimediaDAO wikimediaDAO;

    public KafkaDataBaseConsumer(WikimediaDAO wikimediaDAO) {
        this.wikimediaDAO = wikimediaDAO;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage) {

        LOGGER.info("Event message received -> %s", eventMessage);
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDAO.save(wikimediaData);

    }
}
