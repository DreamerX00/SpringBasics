package com.springBoot.Practice.Controller;

import com.springBoot.Practice.Entity.JournalEntryV2;
import com.springBoot.Practice.Service.JournalEntryServiceV2;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/journalV2")
public class JournalEntryControllerV2 {


    private final JournalEntryServiceV2 journalEntryServiceV2;

    public JournalEntryControllerV2(JournalEntryServiceV2 journalEntryControllerV2){
        this.journalEntryServiceV2 = journalEntryControllerV2;
    }

    private Map<String, JournalEntryV2> journalEntryHashMap = new HashMap<>();
    @GetMapping("/all")
    public ResponseEntity<List<JournalEntryV2>> getAll(){
        Optional<List<JournalEntryV2>> lje2 = journalEntryServiceV2.getEntry();
        if (lje2.isPresent()){
            return new ResponseEntity<>(lje2.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/getBy_id/{_id}")
    public ResponseEntity<JournalEntryV2> getBy_id(@PathVariable ObjectId _id){
        Optional<JournalEntryV2> lje2 = journalEntryServiceV2.getEntryBy_Id(_id);
        if (lje2.isPresent()){
            return new ResponseEntity<>(lje2.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getByid/{id}")
    public ResponseEntity<JournalEntryV2> getBy_id(@PathVariable int id){
        Optional<JournalEntryV2> jev2 = journalEntryServiceV2.getEntryById(id);
        if (jev2.isPresent()){
            return new ResponseEntity<>(jev2.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEntry(@RequestBody JournalEntryV2 journalEntry){
        try {
           journalEntryServiceV2.saveEntry(journalEntry);
           return new ResponseEntity<>("New Entry Created",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/addMultiple")
    public ResponseEntity<String> addEntry(@RequestBody List<JournalEntryV2> journalEntry){
            try {
           journalEntryServiceV2.saveAllEntry(journalEntry);
           return new ResponseEntity<>("New Entries Created",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteBy_id/{_id}")
    public ResponseEntity<String> deleteBy_id(@PathVariable ObjectId _id){
        try {
           journalEntryServiceV2.DeleteBy_Id(_id);
           return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteByid/{id}")
    public ResponseEntity<String> deleteBy_id(@PathVariable int id){
        try {
           journalEntryServiceV2.DeleteById(id);
           return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        try {
            journalEntryServiceV2.DeleteAll();
            return new ResponseEntity<>("All journal entries deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateBy_id/{_id}")
    public ResponseEntity<String> updateBy_id(@PathVariable ObjectId _id, @RequestBody JournalEntryV2 journalEntry) {
        Optional<JournalEntryV2> jev2 = journalEntryServiceV2.getEntryBy_Id(_id);
        if (jev2.isPresent()) {
            journalEntryServiceV2.saveEntry(journalEntry);
            return new ResponseEntity<>("Entry with _id " + _id + " updated successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Entry with _id " + _id + " not found",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateByid/{id}")
    public ResponseEntity<String> updateByid(@PathVariable int id, @RequestBody JournalEntryV2 journalEntry) {
        Optional<JournalEntryV2> jev2 = journalEntryServiceV2.getEntryById(id);
        if (jev2.isPresent()) {
            journalEntryServiceV2.saveEntry(journalEntry);
            return new ResponseEntity<>("Entry with id " + id + " updated successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Entry with id " + id + " not found",HttpStatus.NOT_FOUND);
        }
    }
}
