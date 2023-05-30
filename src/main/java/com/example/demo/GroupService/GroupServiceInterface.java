package com.example.demo.GroupService;

import com.example.demo.model.Group;

import java.util.List;

public interface GroupServiceInterface {


    void create(Group group);
    List<Group> readAll();
    Group read(int id);
    boolean update(Group group, int id);
    boolean delete(int id);
}
