package org.example.goit_javadev_hw14;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

    private final NoteService noteService;

    public TodoApplication(NoteService noteService) {
        this.noteService = noteService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add notes
        Note note1 = new Note("First Note", "This is the first note.");
        Note note2 = new Note("Second Note", "This is the second note.");

        noteService.add(note1);
        noteService.add(note2);

        // View all notes
        noteService.listAll().forEach(note -> System.out.println("Note: " + note.getTitle()));

        // Update note
        note1.setContent("Updated content for the first note.");
        noteService.update(note1);

        // View updated note
        Note updatedNote = noteService.getById(note1.getId());
        System.out.println("Updated Note: " + updatedNote.getContent());

        // Delete note
        noteService.deleteById(note2.getId());

        System.exit(0);
    }
}
