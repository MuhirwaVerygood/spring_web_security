package org.verygood.librarymanagement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.verygood.librarymanagement.models.Library;
import org.verygood.librarymanagement.repositories.LibraryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryServices {
    private final LibraryRepository libraryRepository;

    public List<Library> getLibraries() {
        return libraryRepository.findAll();
    }

    public ResponseEntity<String> addLibrary(Library library) {
        return ResponseEntity.ok("Library added successfully");

    }

    public ResponseEntity<String> deleteLibrary(Long id) {
        return ResponseEntity.ok("Library deleted successfully");

    }

    public ResponseEntity<String> updateLibrary(Long id, Library library) {
        return ResponseEntity.ok("Library updated successfully");

    }
}
