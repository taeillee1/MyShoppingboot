package com.shop.controller;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {
    @GetMapping("/ex01")
    public String thymeleafExample01(Model model){
        model.addAttribute("data","타임리프예제");
        return "thymeleafEx/thymeleafEx01";
    }

    @GetMapping("/ex02")
    public String thymeleafExample02(Model model){

        List<ItemDto> itemDtoList = new ArrayList<>();
        for(int i=1; i<=10; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품 "+i);
            itemDto.setPrice(10000*i);
            itemDto.setRegTime(LocalDateTime.now());
        }


        model.addAttribute("itemDto", itemDtoList);
        return "thymeleafEx/thymeleafEx02";
    }
}
