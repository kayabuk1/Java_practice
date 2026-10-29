package jp.ac.funagi.sample;

import java.time.LocalDateTime;

public record MessageData(
    String clientId,
    String body,
    LocalDateTime sentAt
) {}