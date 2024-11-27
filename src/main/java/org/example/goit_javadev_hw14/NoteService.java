package org.example.goit_javadev_hw14;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private Map<Long, Note> notes = new HashMap<>();
    private long currentId = 1;

    public List<Note> listAll() {
        return notes.values().stream().collect(Collectors.toList());
    }

    public Note add(Note note) {
        note.setId(currentId++);
        notes.put(note.getId(), note);
        return note;
    }

     public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note not found");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new RuntimeException("Note not found");
        }
        notes.put(note.getId(), note);
    }

    public Note getById(long id) {
        Note note = notes.get(id);
        if (note == null) {
            throw new RuntimeException("Note not found");
        }
        return note;
    }
}
