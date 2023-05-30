package com.example.demo.controller;



import com.example.demo.GroupService.GroupServiceInterface;
import com.example.demo.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private final GroupServiceInterface groupServiceInterface;

    @Autowired
    public GroupController(GroupServiceInterface groupServiceInterface){
        this.groupServiceInterface = groupServiceInterface;
    }


    @PostMapping(value = "/groups")
    public ResponseEntity<?> create(@RequestBody Group group){
        groupServiceInterface.create(group);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/groups")
    public ResponseEntity<List<Group>>read(){
        final List<Group> groups = groupServiceInterface.readAll();

        return  groups!=null && !groups.isEmpty()
                ? new ResponseEntity<>(groups,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/groups/{id}")
    public  ResponseEntity<Group>read(@PathVariable(name = "id") int id){
        final Group group = groupServiceInterface.read(id);
        return group!=null
                ? new ResponseEntity<>(group,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/groups/{id}")
    public  ResponseEntity<?>read(@PathVariable(name = "id") int id , @RequestBody Group group){
        final boolean updated = groupServiceInterface.update(group, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }


    @DeleteMapping(value = "/groups/{id}")
    public  ResponseEntity<?>delete(@PathVariable(name = "id") int id ){
        final boolean deleted = groupServiceInterface.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
