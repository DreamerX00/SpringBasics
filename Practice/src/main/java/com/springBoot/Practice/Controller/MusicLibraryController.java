package com.springBoot.Practice.Controller;

import com.springBoot.Practice.Entity.MusicLibrary;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Music")
public class MusicLibraryController {
    public final List<MusicLibrary> myMusicLibrary = new ArrayList<>();
    @GetMapping("/getAll")
    public List<MusicLibrary> getAll(){
        return myMusicLibrary;
    }

    @GetMapping("/getById/{id}")
    public MusicLibrary getById(@PathVariable int id){
        id -=1;
        return myMusicLibrary.get(id);
    }

    @PostMapping("/addMusic")
    public String addMusic(@RequestBody MusicLibrary musicLibrary){
        myMusicLibrary.add(musicLibrary);
        return "Data Added Successfully";
    }

    @PostMapping("/addMultipleMusic")
    public String addMultipleMusic(@RequestBody List<MusicLibrary> list){
        myMusicLibrary.addAll(list);
        return "Data Added Successfully";
    }

    @PutMapping("/editMusicById/{id}")
    public String editMusicById(@PathVariable int id,@RequestBody MusicLibrary edited){
        id-=1;
        myMusicLibrary.set(id,edited);
        return "Edited Successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        myMusicLibrary.clear();
        return "All Data Deleted Successfully";
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id){
        id-=1;
        myMusicLibrary.remove(id);
        return "Id : "+id+" Deleted Successfully";
    }

}
