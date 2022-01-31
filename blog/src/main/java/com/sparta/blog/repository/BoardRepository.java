package com.sparta.blog.repository;

import com.sparta.blog.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
   List<Board> findAllByOrderByCreatedAtDesc();
}