package com.springBoot.Practice.Entity;

import com.springBoot.Practice.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicLibrary {
    private int id;
    private String name;
    private String Artist;
    private Genre genre;
    private String duration;
}

