package com.example.shop.repository;

import com.example.shop.entity.Item;
import com.example.shop.entity.ItemSellStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;


    @Test
    @Transactional
    public void test2(){
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setItemName("test"+i);
            item.setPrice(1000+i);
            item.setItemDetail("~~~test des "+i);
            item.setItemSellStatus(ItemSellStatus.SOLD_OUT);

            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item saved = itemRepository.save(item);
            System.out.println("saved = " + saved);
        }

        for (int i = 0;  i < 10; i++) {
            List<Item> itemList = itemRepository.findByItemName("test1");

            for (Item item : itemList) {
                System.out.println(itemList.toString());
            }

        }
    }

    @Test
    @Transactional
    public void test() {
        Item item = new Item();
        item.setItemName("test");
        item.setPrice(1000);
        item.setItemDetail("~~~DFDfdfd");
        item.setItemSellStatus(ItemSellStatus.SOLD_OUT);

        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item saved = itemRepository.save(item);
        System.out.println("saved = " + saved);

    }

}