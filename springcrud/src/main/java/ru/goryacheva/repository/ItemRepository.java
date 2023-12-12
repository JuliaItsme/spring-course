package ru.goryacheva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryacheva.model.Item;
import ru.goryacheva.model.Person;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemName(String name);

    List<Item> findByPerson(Person person);
}
