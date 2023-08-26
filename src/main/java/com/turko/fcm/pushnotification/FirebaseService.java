package com.turko.fcm.pushnotification;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseService(final FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public String notify(final String topic, final String payload) {
        Message message = Message.builder()
                .setTopic(topic)
                .putData("payload", payload)
                .build();
        try {
            return firebaseMessaging.send(message);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
