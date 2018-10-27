package es.omarall.dialogflow.fulfillment.enums;

public enum Platform {

    UNSPECIFIED(Boolean.FALSE),
    FACEBOOK(Boolean.TRUE),
    SLACK(Boolean.TRUE),
    TELEGRAM(Boolean.TRUE),
    KIK(Boolean.TRUE),
    SKYPE(Boolean.TRUE),
    LINE(Boolean.TRUE),
    VIBER(Boolean.TRUE),
    ACTIONS_ON_GOOGLE(Boolean.TRUE);

    private Boolean supportsRichMessagePlatform;

    private Platform(Boolean supportsRichMessagePlatform) {
        this.supportsRichMessagePlatform = supportsRichMessagePlatform;
    }

    public Boolean supportsRichMessagePlatform() {
        return this.supportsRichMessagePlatform;
    }
}



