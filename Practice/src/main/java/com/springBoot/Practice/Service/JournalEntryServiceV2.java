package com.springBoot.Practice.Service;

import com.springBoot.Practice.Entity.JournalEntryV2;
import com.springBoot.Practice.Repository.JournalEntryRepositoryV2;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryServiceV2 {
    @Autowired
    private JournalEntryRepositoryV2 journalEntryRepositoryV2;

//  Create Operations
    public void saveEntry(JournalEntryV2 jounrnalEntry){
        journalEntryRepositoryV2.save(jounrnalEntry);
    }
    public void saveAllEntry(List<JournalEntryV2> journalEntry){
        journalEntryRepositoryV2.saveAll(journalEntry);
    }

//  Read Operations
    public Optional<List<JournalEntryV2>> getEntry(){
        return Optional.of(journalEntryRepositoryV2.findAll());
    }
    public Optional<JournalEntryV2> getEntryBy_Id(ObjectId id){
        return journalEntryRepositoryV2.findById(id);
    }
    public Optional<JournalEntryV2> getEntryById(int id){
        return journalEntryRepositoryV2.findById(String.valueOf(id));
    }

//  Update Operations

//  Delete Operations
    public void DeleteBy_Id(ObjectId id){
        journalEntryRepositoryV2.deleteById(id);
    }

    public void DeleteById(int id){
        journalEntryRepositoryV2.deleteById(String.valueOf(id));
    }

    public void DeleteAll(){
        journalEntryRepositoryV2.deleteAll();
    }
}
