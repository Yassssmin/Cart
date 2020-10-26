package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CinemaItem {
    private int cinemaId;
    private String title;
    private String iconUrl;
    private String genre;
    private int releaseDate;
}
