package com.springBoot.Practice.Service;

import com.springBoot.Practice.Controller.JournalEntryController;
import com.springBoot.Practice.Entity.JournalEntry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class JournalSampleData {
    private final JournalEntryController journalEntryController;
    public JournalSampleData(JournalEntryController journalEntryController) {
        this.journalEntryController = journalEntryController;
    }
    @PostConstruct
    public void init(){
        journalEntryController.addEntry(new JournalEntry(101, "Tanisha's Midnight Cravings", "Tanisha secretly orders ramen at 2 AM and pretends it’s for her cat."));
        journalEntryController.addEntry(new JournalEntry(102, "Tanisha and the Lost Sock", "Tanisha believes her washing machine is a portal to a sock-eating dimension."));
        journalEntryController.addEntry(new JournalEntry(103, "Tanisha's Vlog Obsession", "Tanisha binge-watches Japanese vlogs and now bows before opening her fridge."));
        journalEntryController.addEntry(new JournalEntry(104, "Tanisha’s Nap Olympics", "Tanisha once took a 6-hour nap and called it 'a power rest'."));
        journalEntryController.addEntry(new JournalEntry(105, "Tanisha’s Plant Parenting", "Tanisha talks to her succulents in Japanese, hoping they’ll grow fluent."));
        journalEntryController.addEntry(new JournalEntry(106, "Tanisha’s Dream Career", "Tanisha wants to be a professional sleeper with a side hustle in vlog reviewing."));
        journalEntryController.addEntry(new JournalEntry(107, "Tanisha’s Cozy Rituals", "Tanisha wraps herself in three blankets and calls it 'hibernation mode'."));
        journalEntryController.addEntry(new JournalEntry(108, "Tanisha’s Weekend Goals", "Tanisha plans to sleep, snack, and rewatch her favorite Tokyo café vlog."));
        journalEntryController.addEntry(new JournalEntry(109, "Tanisha’s Pillow Philosophy", "Tanisha believes the right pillow can solve 80% of life’s problems."));
        journalEntryController.addEntry(new JournalEntry(110, "Tanisha’s Zen Zone", "Tanisha meditates by watching slow-paced Japanese cleaning vlogs."));
        journalEntryController.addEntry(new JournalEntry(111, "Tanisha’s Blanket Fort", "Tanisha built a blanket fort and declared it her new office."));
        journalEntryController.addEntry(new JournalEntry(112, "Tanisha’s Matcha Ritual", "Tanisha whisks her matcha like a tea master and hums lo-fi beats."));
        journalEntryController.addEntry(new JournalEntry(113, "Tanisha’s Sock Theory", "Tanisha believes socks disappear to start a secret society."));
        journalEntryController.addEntry(new JournalEntry(114, "Tanisha’s Cat Vlog Channel", "Tanisha started filming her cat reacting to Japanese vlogs."));
        journalEntryController.addEntry(new JournalEntry(115, "Tanisha’s Sleep Tracker", "Tanisha’s sleep tracker gave up and called her a legend."));
        journalEntryController.addEntry(new JournalEntry(116, "Tanisha’s Cozy Playlist", "Tanisha curates playlists with rain sounds and ramen slurps."));
        journalEntryController.addEntry(new JournalEntry(117, "Tanisha’s Tokyo Dreams", "Tanisha dreams of opening a nap café in Shibuya."));
        journalEntryController.addEntry(new JournalEntry(118, "Tanisha’s Secret Hobby", "Tanisha folds origami while watching sushi prep videos."));
        journalEntryController.addEntry(new JournalEntry(119, "Tanisha’s Laundry Philosophy", "Tanisha believes laundry is a spiritual reset."));
        journalEntryController.addEntry(new JournalEntry(120, "Tanisha’s Chill Commandments", "Tanisha’s rules: nap often, vlog daily, ramen always."));
        System.out.println("Sample Data Added Successfully On Journal");
    }

}
