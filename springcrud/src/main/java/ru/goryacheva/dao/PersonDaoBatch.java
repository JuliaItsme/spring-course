package ru.goryacheva.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.goryacheva.model.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDaoBatch {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoBatch(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void testMultipleUpdate() {
        List<Person> people = createListPerson();
        long before = System.currentTimeMillis();
        for (Person p : people) {
            jdbcTemplate.update("INSERT INTO Person VALUES (?, ?, ?, ?)",
                    p.getId(), p.getName(), p.getAge(), p.getEmail());
        }
        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));
    }

    public void testBatchUpdate() {
        final List<Person> people = createListPerson();
        final long before = System.currentTimeMillis();
        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES (?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, people.get(i).getId());
                ps.setString(2, people.get(i).getName());
                ps.setInt(3, people.get(i).getAge());
                ps.setString(4, people.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        });
        final long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));
    }

    private List<Person> createListPerson() {
        List<Person> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            list.add(new Person(i, "Name" + i, 30, "test" + i + "@mail.ru"));
        }
        return list;
    }
}
