package ch.csbe.uek295_boilerplate.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("""
    SELECT c.id FROM Category c WHERE c.name = :name AND c.active = 1""")
    Long getCategoryIdByName(@Param("name") String name);

    @Query("""
    SELECT c.name FROM Category c WHERE c.id = :id AND c.active = 1""")
    Long getCategoryNameById(@Param("name") String name);

    Category findByName(String name);

}


