package com.turko.fcm.pushnotification;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
@EnableConfigurationProperties(FirebaseProperties.class)
public class FirebaseConfig {

    private final FirebaseProperties firebaseProperties;

    public FirebaseConfig(final FirebaseProperties firebaseProperties) {
        this.firebaseProperties = firebaseProperties;
    }

    @Bean
    GoogleCredentials googleCredentials() throws IOException {
        try (final InputStream inputStream = firebaseProperties.getServiceAccount().getInputStream()) {
            return GoogleCredentials.fromStream(inputStream);
        }
    }

    @Bean
    public FirebaseApp firebaseApp(GoogleCredentials credentials) {
        final FirebaseOptions firebaseOptions = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();
        return FirebaseApp.initializeApp(firebaseOptions);
    }

    @Bean
    FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }

}