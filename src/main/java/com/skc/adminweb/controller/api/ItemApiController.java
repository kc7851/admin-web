package com.skc.adminweb.controller.api;

import com.skc.adminweb.ifs.CurdInterface;
import com.skc.adminweb.model.network.Header;
import com.skc.adminweb.model.network.reponse.ItemApiResponse;
import com.skc.adminweb.model.network.request.ItemApiRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item/")
public class ItemApiController implements CurdInterface<ItemApiRequest, ItemApiResponse> {

    @Override
    @PostMapping("")
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    @GetMapping("{id}")
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }

}
