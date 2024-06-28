package com.jug.joker.javadopexample.api;

import com.jug.joker.javadopexample.api.dto.AccessCheckRequest;
import com.jug.joker.javadopexample.service.CompositeAccessResolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/composite-access-resolution")
public class CompositeAccessResolutionController {
    private final CompositeAccessResolutionService compositeAccessResolutionService;

    @PostMapping("/check")
    public boolean checkAccess(@RequestBody AccessCheckRequest accessCheckRequest) {
        return compositeAccessResolutionService.checkAccess(accessCheckRequest);
    }
}