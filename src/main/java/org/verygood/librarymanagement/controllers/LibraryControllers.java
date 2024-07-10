package org.verygood.librarymanagement.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.verygood.librarymanagement.models.Library;
import org.verygood.librarymanagement.services.LibraryServices;

import java.util.List;

@RestController
@RequestMapping(path =  "/api/v1/library")
@RequiredArgsConstructor
@Tag(name = "Library")
public class LibraryControllers {
    private final LibraryServices libraryServices;
    @GetMapping
    public List<Library> getLibraries(){
        return libraryServices.getLibraries();
    }



    @PostMapping
    public ResponseEntity<String>  addLibrary(@RequestBody Library library){

       return libraryServices.addLibrary(library);
    }

    @DeleteMapping(path = "{libraryId}")
    public ResponseEntity<String> deleteLibrary(@PathVariable("libraryId") Long id){
       return libraryServices.deleteLibrary(id);
    }

    @PutMapping(path = "{libraryId}")
    public ResponseEntity<String>  updateLibrary(@PathVariable("libraryId") Long id, @RequestBody Library library){
       return libraryServices.updateLibrary(id, library);
    }
}
