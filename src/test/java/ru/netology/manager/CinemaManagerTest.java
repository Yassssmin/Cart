package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.CinemaItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CinemaManagerTest {
    private CinemaManager manager = new CinemaManager();

    @Test
    public void shouldAddCinemaItem() {
        CinemaItem first = new CinemaItem(1, "Test first", "test url", "comedy", 1603734744);
        CinemaItem second = new CinemaItem(2, "Test second", "test url", "comedy", 1603734744);
        CinemaItem third = new CinemaItem(3, "Test third", "test url", "comedy", 1603734744);

        manager.add(first);
        manager.add(second);
        manager.add(third);

        CinemaItem[] actual = manager.getLastItems();
        CinemaItem[] expected = new CinemaItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLast10Items() {
        CinemaItem[] cinemaItems = new CinemaItem[15];

        for (int i = 0; i < cinemaItems.length; i++) {
            CinemaItem cinemaItem = new CinemaItem(i + 1, "Cinema " + i, "test url", "comedy", 1603734744);

            cinemaItems[i] = cinemaItem;

            manager.add(cinemaItem);
        }

        CinemaItem[] actual = manager.getLastItems();
        CinemaItem[] expected = new CinemaItem[10];

        for (int i = cinemaItems.length; i > (cinemaItems.length - expected.length); i--) {
            expected[cinemaItems.length - i] = cinemaItems[i - 1];
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastItemsCustom() {
        manager = new CinemaManager(5);

        CinemaItem[] cinemaItems = new CinemaItem[15];

        for (int i = 0; i < cinemaItems.length; i++) {
            CinemaItem cinemaItem = new CinemaItem(i + 1, "Cinema " + i, "test url", "comedy", 1603734744);

            cinemaItems[i] = cinemaItem;

            manager.add(cinemaItem);
        }

        CinemaItem[] actual = manager.getLastItems();
        CinemaItem[] expected = new CinemaItem[5];

        for (int i = cinemaItems.length; i > (cinemaItems.length - expected.length); i--) {
            expected[cinemaItems.length - i] = cinemaItems[i - 1];
        }

        assertArrayEquals(expected, actual);
    }
}
