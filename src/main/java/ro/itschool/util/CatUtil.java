package ro.itschool.util;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.itschool.entity.Cat;
import ro.itschool.entity.Cat;
import ro.itschool.repository.CatRepository;
import ro.itschool.repository.CatRepository;

@Component
public class CatUtil {

    @Autowired
    private CatRepository catRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {

        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat();
            cat.setName(faker.cat().name());
            cat.setOwnersName(faker.name().fullName());
           cat.setBreed(faker.cat().breed());
          cat.setAge(faker.number().numberBetween(1,18));
            catRepository.save(cat);
        }
    }
}
