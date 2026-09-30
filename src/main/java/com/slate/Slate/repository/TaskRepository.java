package com.slate.Slate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slate.Slate.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
