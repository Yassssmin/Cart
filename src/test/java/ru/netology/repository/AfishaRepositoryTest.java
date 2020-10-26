package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    @Test
    void findAll() {
        AfishaRepository repository = new AfishaRepository();

        AfishaItem first = new AfishaItem(1, "Test first", "test url", "comedy", 1603734744);
        AfishaItem second = new AfishaItem(2, "Test second", "test url", "comedy", 1603734744);
        AfishaItem third = new AfishaItem(3, "Test third", "test url", "comedy", 1603734744);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void save() {
        AfishaRepository repository = new AfishaRepository();

        AfishaItem first = new AfishaItem(1, "Test first", "test url", "comedy", 1603734744);

        repository.save(first);

        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        AfishaRepository repository = new AfishaRepository();

        AfishaItem first = new AfishaItem(1, "Test first", "test url", "comedy", 1603734744);
        AfishaItem second = new AfishaItem(2, "Test second", "test url", "comedy", 1603734744);
        AfishaItem third = new AfishaItem(3, "Test third", "test url", "comedy", 1603734744);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        AfishaItem actual = repository.findById(2);
        AfishaItem expected = second;

        assertEquals(expected, actual);

        actual = repository.findById(5);
        expected = null;

        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        AfishaRepository repository = new AfishaRepository();

        AfishaItem first = new AfishaItem(1, "Test first", "test url", "comedy", 1603734744);
        AfishaItem second = new AfishaItem(2, "Test second", "test url", "comedy", 1603734744);
        AfishaItem third = new AfishaItem(3, "Test third", "test url", "comedy", 1603734744);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(2);

        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{first, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        AfishaRepository repository = new AfishaRepository();

        AfishaItem first = new AfishaItem(1, "Test first", "test url", "comedy", 1603734744);
        AfishaItem second = new AfishaItem(2, "Test second", "test url", "comedy", 1603734744);
        AfishaItem third = new AfishaItem(3, "Test third", "test url", "comedy", 1603734744);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeAll();

        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{};

        assertArrayEquals(expected, actual);
    }
}