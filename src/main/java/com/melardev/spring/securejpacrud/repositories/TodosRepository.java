package com.melardev.spring.securejpacrud.repositories;


import com.melardev.spring.securejpacrud.entities.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByCompleted(boolean done);

    Page<Todo> findByCompleted(Pageable pageable, boolean done);

    List<Todo> findAll();

    Page<Todo> findAll(Pageable pageRequest);


    List<Todo> findByCompletedTrue();

    List<Todo> findByCompletedFalse();

    List<Todo> findByCompletedIsTrue();

    Page<Todo> findByCompletedIsTrue(Pageable pageable);

    List<Todo> findByCompletedIsFalse();

    List<Todo> findByTitleContains(String title);

    List<Todo> findByDescriptionContains(String description);

    Page<Todo> findByCompletedTrue(PageRequest pageRequest);

    Page<Todo> findByCompletedFalse(Pageable pageRequest);

    @Query("select t from Todo t where t.completed = :completed")
    Page<Todo> findByHqlCompletedIs(Pageable pageRequest, boolean completed);

    @Query("select t from Todo t where t.title like %:word%")
    Page<Todo> findByHqlTitleLike(Pageable pageRequest, String word);


    @Query("SELECT t FROM Todo t WHERE title = :title and description  = :description")
    List<Todo> findByHqlTitleAndDescription(String title, String description);

    @Query("select t FROM Todo t WHERE title = ?0 and description  = ?1")
    List<Todo> findByTHqlTitleAndDescription(String title, String description);

/*
    // for deferred execution
    Flux<Todo> findByDescription(Mono<String> description);

    Mono<Todo> findByTitleAndDescription(Mono<String> title, String description);
    */
}