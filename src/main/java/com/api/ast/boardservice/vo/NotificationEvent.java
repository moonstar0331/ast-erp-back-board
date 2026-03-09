package com.api.ast.boardservice.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationEvent {
    private String userUuid;
    private String type;
    private String title;
    private String content;
    private String linkUrl;
}
