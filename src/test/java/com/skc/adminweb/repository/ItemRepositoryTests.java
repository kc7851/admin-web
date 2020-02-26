package com.skc.adminweb.repository;

import com.skc.adminweb.model.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {


    }

    @Test
    public void read() {


    }
}