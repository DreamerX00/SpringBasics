package com.springBoot.Practice.Service;

import com.springBoot.Practice.Controller.MusicLibraryController;
import com.springBoot.Practice.Enum.Genre;
import com.springBoot.Practice.Entity.MusicLibrary;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MusicSampleData {
    private final MusicLibraryController musicLibraryController;

    public MusicSampleData(MusicLibraryController musicLibraryController) {
        this.musicLibraryController = musicLibraryController;
    }

    @PostConstruct
    public void init(){musicLibraryController.addMusic(new MusicLibrary(1, "Pyaar", "Naam Sujal", Genre.HIP_HOP, "4:00"));
    musicLibraryController.addMusic(new MusicLibrary(2, "Thunder Road", "Steel Horizon", Genre.ROCK, "4:15"));
    musicLibraryController.addMusic(new MusicLibrary(3, "Neon Lights", "Pulse Theory", Genre.POP, "3:42"));
    musicLibraryController.addMusic(new MusicLibrary(4, "Smooth Drift", "Jazz Junction", Genre.JAZZ, "5:20"));
    musicLibraryController.addMusic(new MusicLibrary(5, "Moonlight Sonata Reimagined", "Orchestra Nova", Genre.CLASSICAL, "7:10"));
    musicLibraryController.addMusic(new MusicLibrary(6, "Street Echo", "Urban Flow", Genre.HIP_HOP, "3:58"));
    musicLibraryController.addMusic(new MusicLibrary(7, "Digital Mirage", "Synth Surge", Genre.ELECTRONIC, "4:33"));
    musicLibraryController.addMusic(new MusicLibrary(8, "Dusty Trails", "Cactus Creek", Genre.COUNTRY, "4:05"));
    musicLibraryController.addMusic(new MusicLibrary(9, "Island Vibes", "Rasta Rhythm", Genre.REGGAE, "3:50"));
    musicLibraryController.addMusic(new MusicLibrary(10, "Delta Soul", "Blue River Band", Genre.BLUES, "6:00"));
    musicLibraryController.addMusic(new MusicLibrary(11, "Iron Pulse", "Metal Forge", Genre.METAL, "4:45"));
    musicLibraryController.addMusic(new MusicLibrary(12, "Echo Chamber", "The Static Minds", Genre.ROCK, "3:59"));
    musicLibraryController.addMusic(new MusicLibrary(13, "Velvet Sky", "Dream Pop Society", Genre.POP, "4:12"));
    musicLibraryController.addMusic(new MusicLibrary(14, "Bebop Nights", "Sax Syndicate", Genre.JAZZ, "5:05"));
    musicLibraryController.addMusic(new MusicLibrary(15, "Baroque Breeze", "Chamber Ensemble", Genre.CLASSICAL, "6:30"));
    musicLibraryController.addMusic(new MusicLibrary(16, "Cipher Flow", "Byte Beats", Genre.HIP_HOP, "3:40"));
    musicLibraryController.addMusic(new MusicLibrary(17, "Neural Pulse", "Circuit Symphony", Genre.ELECTRONIC, "4:20"));
    musicLibraryController.addMusic(new MusicLibrary(18, "Prairie Song", "Dust & Denim", Genre.COUNTRY, "4:10"));
    musicLibraryController.addMusic(new MusicLibrary(19, "Roots Revival", "Jah Vibe", Genre.REGGAE, "3:55"));
    musicLibraryController.addMusic(new MusicLibrary(20, "Steel Storm", "Iron Anthem", Genre.METAL, "5:00"));
        System.out.println("Data Added Successfully On Music");
    }
}
