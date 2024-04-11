package com.dmm.task.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmm.task.data.entity.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {//JPAのリポジトリ機能を利用するために拡張が必要！(らしい)参照https://terasolunaorg.github.io/guideline/5.0.2.RELEASE/ja/ArchitectureInDetail/DataAccessJpa.html#spring-data
  //  List<Task> findByUsername(String username);
}
