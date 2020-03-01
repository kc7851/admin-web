package com.skc.adminweb.controller.api;

import com.oracle.tools.packager.Log;
import com.skc.adminweb.ifs.CurdInterface;
import com.skc.adminweb.model.network.Header;
import com.skc.adminweb.model.network.reponse.UserApiResponse;
import com.skc.adminweb.model.network.request.UserApiRequest;
import com.skc.adminweb.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user/")
public class UserApiController implements CurdInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(
            @RequestBody Header<UserApiRequest> request
    ) {
        log.info("{}", request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        log.info("read id : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(
            @RequestBody Header<UserApiRequest> userApiRequest
    ) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(Long id) {
        return null;
    }

}
