package com.skc.adminweb.controller.api;

import com.skc.adminweb.ifs.CurdInterface;
import com.skc.adminweb.model.network.Header;
import com.skc.adminweb.model.network.reponse.ItemApiResponse;
import com.skc.adminweb.model.network.request.ItemApiRequest;
import com.skc.adminweb.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item/")
public class ItemApiController implements CurdInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping("")
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return itemApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return itemApiLogicService.delete(id);
    }

}
