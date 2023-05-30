package com.example.demo.GroupService;

import com.example.demo.model.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GroupService implements GroupServiceInterface{

    private static final Map<Integer, Group> GROUP_MAP = new HashMap<>();
    private static final AtomicInteger GROUP_ID_HOLDER = new AtomicInteger();
    @Override
    public void create(Group group) {
        final int groupID = GROUP_ID_HOLDER.incrementAndGet();
        group.setId(groupID);
        GROUP_MAP.put(groupID,group);
    }

    @Override
    public List<Group> readAll() {
        return new ArrayList<>(GROUP_MAP.values());
    }

    @Override
    public Group read(int id) {
        return GROUP_MAP.get(id);
    }

    @Override
    public boolean update(Group group, int id) {
        if (GROUP_MAP.containsKey(id)){
            group.setId(id);
            GROUP_MAP.put(id,group);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return GROUP_MAP.remove(id)!=null;
    }
}
