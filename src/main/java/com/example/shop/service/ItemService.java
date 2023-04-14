package com.example.shop.service;

import com.example.shop.dto.ItemFormDto;
import com.example.shop.entity.Item;
import com.example.shop.entity.ItemImg;
import com.example.shop.repository.ItemImgRepository;
import com.example.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemImgRepository itemImgRepository;
    private final ItemImgService itemImgService;
    private final ItemRepository itemRepository;

    public Long saveItem(ItemFormDto itemFormDto,
                         List<MultipartFile> itemImgFileList) throws Exception{

        // register Item
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        // register IMG
        for (int i = 0; i < itemImgFileList.size(); i++) {

            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);
            if (i == 0) {
                itemImg.setRepimgYn("Y");
            }else{
                itemImg.setRepimgYn("N");
            }
            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }
        return item.getId();
    }

}
