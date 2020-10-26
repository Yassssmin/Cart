package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private int lastCount = 10;

    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int lastCount) {
        this.repository = repository;
        this.lastCount = lastCount;
    }

    public void add(AfishaItem item) {
      repository.save(item);
    }

    public AfishaItem[] getLastItems() {
        AfishaItem[] items = repository.findAll();

        int maxCount = Math.min(this.lastCount, items.length);

        AfishaItem[] result = new AfishaItem[maxCount];

        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }

        return result;
    }

}
