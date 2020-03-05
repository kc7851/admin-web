package com.skc.adminweb.service;

import com.skc.adminweb.ifs.CurdInterface;
import com.skc.adminweb.model.entity.Item;
import com.skc.adminweb.model.network.Header;
import com.skc.adminweb.model.network.reponse.ItemApiResponse;
import com.skc.adminweb.model.network.request.ItemApiRequest;
import com.skc.adminweb.repository.ItemRepository;
import com.skc.adminweb.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ItemApiLogicService implements CurdInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

        ItemApiRequest body = request.getData();

        Item item = Item.builder()
                .status(body.getStatus())
                .name(body.getName())
                .title(body.getTitle())
                .content(body.getContent())
                .price(body.getPrice())
                .brandName(body.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(body.getPartnerId()))
                .build();

        Item save = itemRepository.save(item);

        return response(save);
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        return itemRepository.findById(id)
                .map(item -> response(item))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {

        ItemApiRequest body = request.getData();

        return itemRepository.findById(body.getId())
                .map(entityItem -> {
                    entityItem
                            .setStatus(body.getStatus())
                            .setName(body.getName())
                            .setTitle(body.getTitle())
                            .setContent(body.getContent())
                            .setPrice(body.getPrice())
                            .setBrandName(body.getBrandName())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnregisteredAt())
                    ;

                    return entityItem;
                })
                .map(newEntityItem ->
                        itemRepository.save(newEntityItem))
                .map(item -> response(item))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    itemRepository.delete(item);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"))
        ;
    }

    private Header<ItemApiResponse> response(Item item) {

        ItemApiResponse body = ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getPartner().getId())
                .build();

        return Header.OK(body);
    }

}
