package com.springBoot.Practice.Controller;

import com.springBoot.Practice.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntryHashMap = new HashMap<>();
    @GetMapping("/all")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntryHashMap.values());
    }
    @PostMapping("/add")
    public String addEntry(@RequestBody JournalEntry journalEntry){
        journalEntryHashMap.put(journalEntry.getId(), journalEntry);
        return "Entry added successfully";
    }
    @PostMapping("/addMultiple")
    public String addEntry(@RequestBody List<JournalEntry> journalEntry){
            for(JournalEntry journalEntry1 : journalEntry){
            journalEntryHashMap.put(journalEntry1.getId(), journalEntry1);
        }
            return "Entry added successfully";
    }
    @GetMapping("/id")
    public Map<Long, JournalEntry> getJournalEntry(){
        return journalEntryHashMap;
    }

    @GetMapping("/getById/{id}")
    public JournalEntry getById(@PathVariable Long id){
        return journalEntryHashMap.get(id);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Long id){
        journalEntryHashMap.remove(id);
        return "Entry with id " + id + " deleted successfully";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        journalEntryHashMap.clear();
        return "All journal entries deleted successfully";
    }
    @PutMapping("/updateById/{id}")
    public String updateById(@PathVariable Long id, @RequestBody JournalEntry journalEntry) {
        if (journalEntryHashMap.containsKey(id)) {
            journalEntryHashMap.put(id, journalEntry);
            return "Entry with id " + id + " updated successfully";
        } else {
            return "Entry with id " + id + " not found";
        }
    }
}
