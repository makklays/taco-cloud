package com.techmatrix18.data;

import com.techmatrix18.model.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.net.ContentHandler;
import java.util.List;

/**
 * TacoRepository
 *
 * @author Alexander Kuziv
 * @company TechMatrix18
 * @version 1.0
 * @since 2024-06-01
 */
@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> { // For Pagable Jpa or CrudRepository<Taco, Long>
    //

}

