package com.example.chapter_2.controller;

import com.example.chapter_2.entity.Burger;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    List<Burger> burgers = Arrays.asList(
            Burger.builder().id(1).name("Burger 1").favor("Spicy").isHidden(false).build(),
            Burger.builder().id(2).name("Burger 2").favor("Tasty").isHidden(false).build(),
            Burger.builder().id(3).name("Burger 3").favor("Sweet").isHidden(false).build(),
            Burger.builder().id(4).name("Burger 4").favor("Vegan").isHidden(false).build(),
            Burger.builder().id(5).name("Burger 5").favor("Extreme spicy").isHidden(false).build(),
            Burger.builder().id(6).name("Burger 6").favor("Spicy").isHidden(false).build(),
            Burger.builder().id(7).name("Burger 7").favor("Spicy").isHidden(false).build()
    );
    
    @GetMapping("/menu")
    public List<Burger> menu (){
        return burgers;
    }
    
    @PatchMapping("/{burgerId}")
    public boolean hideBurger (@PathVariable Integer id , @RequestParam Boolean isHidden){
        burgers.forEach(burger ->{
            if(burger.getId() == id){
                burger.setIsHidden(isHidden);
            }
        });
        return true;
    }
    
    @PostMapping
    public Burger createburger(@RequestBody Burger burger){
        burger.setId(burgers.size());
        burgers.add(burger);
        return burger;
    }
    
    @PutMapping("/{burgerId}")
    public Burger updateBurger(@PathVariable Integer burgerId , @RequestBody Burger updatedBurger){
        for(var burger : burgers){
            if(burger.getId() == burgerId){
                burger.setName(updatedBurger.getName());
                burger.setFavor(updatedBurger.getFavor());
                burger.setIsHidden(updatedBurger.getIsHidden());
                updatedBurger.setId(burger.getId());
            }
        }
        return updatedBurger;
    }

    
    
    
}
