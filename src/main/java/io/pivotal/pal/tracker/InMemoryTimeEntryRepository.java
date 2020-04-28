package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    HashMap<Long,TimeEntry> hash =new HashMap<Long,TimeEntry>();
    long counter=1l;
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(counter);

        hash.put(counter,timeEntry) ;
        counter++;
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {

        return hash.get(id);



    }

    @Override
    public List<TimeEntry> list() {


        return new ArrayList<>(hash.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (find(id) == null) return null;

        TimeEntry updatedEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        hash.replace(id, updatedEntry);
        return updatedEntry;
    }
    @Override
    public void delete(long id) {

        hash.remove(id);
    }
}
