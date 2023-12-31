package ru.goryacheva.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.goryacheva.model.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDaoJdbcTemplate {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    //в jdbcTemplate по умолчанию используется prepareStatement. В аргументе метода передаются значения для запроса
    public Person show(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM Person WHERE id = ?", new BeanPropertyRowMapper<>(Person.class), id)
                .stream().findAny().orElse(null);
    }
    public Optional<Person> show(String email) {
        return jdbcTemplate.query(
                "SELECT * FROM Person WHERE email = ?", new BeanPropertyRowMapper<>(Person.class), email)
                .stream().findAny();
    }
    public void save(Person person) {
        jdbcTemplate.update(
                "INSERT INTO Person(name, age, email) VALUES (?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail()
        );
    }

    public void update(int id, Person personUpdate) {
        jdbcTemplate.update("UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?",
                personUpdate.getName(), personUpdate.getAge(), personUpdate.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }
}
