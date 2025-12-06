package com.demo.shop._00_common;

import com.demo.shop._00_common.models.CreateResDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class ResponseBuilder {

    public static ResponseEntity postResponse(String depth,Object data) {
        CreateResDTO resp = new CreateResDTO();
        resp.setData(data);
           URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{depth}")
            .buildAndExpand("1")
            .toUri();
        return  ResponseEntity.created(location).body(resp);
    }
}
