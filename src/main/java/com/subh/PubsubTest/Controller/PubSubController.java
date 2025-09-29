package com.subh.PubsubTest.Controller;

import com.subh.PubsubTest.InboundService.PubSubApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class PubSubController {

    @Autowired
    private PubSubApplication.PubsubOutboundGateway messagingGateway;

    @PostMapping("/publishMessage/{message}")
    public String publishMessage(@PathVariable String message) {
        messagingGateway.sendToPubsub(message);
        return "Message Delivered";
    }
}
