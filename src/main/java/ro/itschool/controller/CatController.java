package ro.itschool.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Cat;
import ro.itschool.repository.CatRepository;

import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
public class CatController {


    @Autowired
    private CatRepository catRepository;


    @GetMapping(value = "/cats")
    public List<Cat> getCat(){
        return catRepository.findAll();
    }

    @PostMapping(value = "/cats")
    public Cat saveCat(@RequestBody Cat cat){
        return catRepository.save(cat);
    }

    @DeleteMapping(value = "/cats/{id}")
    public String deleteCat(@PathVariable Integer id){
        Optional<Cat> cat = catRepository.findById(id);
        if(cat.isPresent()) {
            catRepository.delete(cat.get());
            return String.format("Cat with id %d was deleted",id);
        }
        else
            return String.format("Entity with id %d not found",id);
    }
}
