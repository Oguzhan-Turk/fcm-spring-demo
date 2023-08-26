package com.turko.fcm.pushnotification;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirebaseController {

    private final FirebaseService firebaseService;

    public FirebaseController(final FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/firebase/{topic}")
    public ResponseEntity<String> firebaseNotify(@PathVariable("topic") final String topic, @RequestBody final String payload) {
        String messageId = firebaseService.notify(topic, payload);
        return new ResponseEntity<>(messageId, HttpStatus.ACCEPTED);
    }

}
