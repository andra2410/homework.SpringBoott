package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer> {


}
