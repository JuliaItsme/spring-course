package ru.goryacheva.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters")
    @Column(name="item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person person;

    public Item() {
    }

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public Item(String itemName, Person person) {
        this.itemName = itemName;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", itemName='" + itemName + '\'' + ", person=" + person + '}';
    }
}
