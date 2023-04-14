package com.example.shop.controller;

import com.example.shop.dto.ItemFormDto;
import com.example.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/admin/item/new")
    public String inform(Model model) {
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "/item/itemForm";
    }


    public String itemNew() {


        return "redirect:/";
    }

}
