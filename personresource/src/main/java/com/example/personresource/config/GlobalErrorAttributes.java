package com.example.personresource.config;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request,
                                                  boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(
                request, includeStackTrace);
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("message", "Wrong Input Type or Chekc URL Manual");
        return map;
    }

}