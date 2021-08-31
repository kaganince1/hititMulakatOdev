package com.example.hitit.repository;

import com.example.hitit.model.Tree;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeJpaRepository extends CrudRepository<Tree, Integer> {
    @Modifying
    @Query("delete from Tree t where t.id = ?1")
    void deleteTree(Integer entityId);
}
