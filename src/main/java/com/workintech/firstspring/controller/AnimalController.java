package com.workintech.firstspring.controller;

import com.workintech.firstspring.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    Map<Integer, Animal> animals ;

    @PostConstruct
    public void init(){
      animals = new HashMap<>();

    }
@PostMapping("/")
    public Animal createAnimal(@RequestBody Animal animal){
animals.put(animal.getId(),animal);
return  animal;

    }


    @GetMapping("/")
    public List<Animal> findAll() {
        System.out.println("Get all animals");
        return animals.values().stream().toList();
    }

    @GetMapping ("/{id}")
    public Animal findAnimal (@PathVariable int id){

        return animals.get(id);

    }
    @PutMapping("/{id}")
    public Animal updateAnimal (@PathVariable int id , @RequestBody Animal animal){
        animal.setId(id);
        animals.put(animal.getId(),animal);
        return  animal;


    }

    @DeleteMapping ("/{id}")
    public Animal deleteAnimal (@PathVariable int id){
       return animals.remove(id);


    }

}
