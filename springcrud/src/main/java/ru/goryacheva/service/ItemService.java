package ru.goryacheva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.goryacheva.model.Item;
import ru.goryacheva.model.Person;
import ru.goryacheva.repository.ItemRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> findByItemName(String name){
        return repository.findByItemName(name);
    }

    public List<Item> findByPerson(Person person){
        return repository.findByPerson(person);
    }

}
