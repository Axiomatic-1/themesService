package com.microsevriceslesson.plateService.controller.dto;

public enum SocialProvider {

    GOOGLE("google"), GITHUB("github"), LOCAL("local");

    private final String providerType;

    public String getProviderType() {
        return providerType;
    }

    SocialProvider(String providerType) {
        this.providerType = providerType;
    }
}
