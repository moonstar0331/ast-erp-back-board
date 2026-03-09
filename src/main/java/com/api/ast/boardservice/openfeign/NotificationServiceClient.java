package com.api.ast.boardservice.openfeign;

import com.api.ast.boardservice.vo.NotificationEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "notification-service")
public interface NotificationServiceClient {

    @PostMapping("/api/notifications/broadcast")
    void broadcastNotification(
            @RequestBody NotificationEvent event,
            @RequestParam(name = "excludeUserUuid", required = false) String excludeUserUuid);
}
