package com.turko.fcm.pushnotification;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties(prefix = "fcm.firebase")
public class FirebaseProperties {
    private Resource serviceAccount;

    public Resource getServiceAccount() {
        return serviceAccount;
    }

    public void setServiceAccount(Resource serviceAccount) {
        this.serviceAccount = serviceAccount;
    }
}

