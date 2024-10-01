package org.verygood.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.verygood.librarymanagement.models.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
