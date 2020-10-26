package ru.netology.manager;

import ru.netology.domain.CinemaItem;

import java.util.concurrent.Callable;

public class CinemaManager {
    private int lastCount = 10;

    private CinemaItem[] items = new CinemaItem[0];

    public CinemaManager() {
    }

    public CinemaManager(int lastCount) {
        this.lastCount = lastCount;
    }

    public void add(CinemaItem item) {
      int length = items.length + 1;
      CinemaItem[] tmp = new CinemaItem[length];

      System.arraycopy(items, 0, tmp, 0, items.length);

      int lastIndex = tmp.length - 1;
      tmp[lastIndex] = item;
      items = tmp;
    }

    public CinemaItem[] getLastItems() {
        int maxCount = Math.min(this.lastCount, items.length);

        CinemaItem[] result = new CinemaItem[maxCount];

        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }

        return result;
    }

}
