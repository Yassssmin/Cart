package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager = new AfishaManager(repository);

    @Test
    public void shouldAddAfishaItem() {
        AfishaItem item = new AfishaItem(1, "Test item", "test url", "comedy", 1603734744);

        manager.add(item);

        verify(repository).save(item);
    }

    @Test
    public void shouldGetLast10Items() {
        AfishaItem[] afishaItems = new AfishaItem[15];

        for (int i = 0; i < afishaItems.length; i++) {
            AfishaItem cinemaItem = new AfishaItem(i + 1, "Cinema " + i, "test url", "comedy", 1603734744);

            afishaItems[i] = cinemaItem;
        }

        doReturn(afishaItems).when(repository).findAll();

        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[10];

        for (int i = afishaItems.length; i > (afishaItems.length - expected.length); i--) {
            expected[afishaItems.length - i] = afishaItems[i - 1];
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastItemsCustom() {
        manager = new AfishaManager(repository,5);

        AfishaItem[] afishaItems = new AfishaItem[15];

        for (int i = 0; i < afishaItems.length; i++) {
            AfishaItem cinemaItem = new AfishaItem(i + 1, "Cinema " + i, "test url", "comedy", 1603734744);

            afishaItems[i] = cinemaItem;
        }

        doReturn(afishaItems).when(repository).findAll();

        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[5];

        for (int i = afishaItems.length; i > (afishaItems.length - expected.length); i--) {
            expected[afishaItems.length - i] = afishaItems[i - 1];
        }

        assertArrayEquals(expected, actual);
    }
}
