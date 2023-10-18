package com.pkk.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pkk.boardback.entity.BoardListViewEntity;

@Repository
public interface BoardListViewRepository extends JpaRepository<BoardListViewEntity, Integer> {

}
