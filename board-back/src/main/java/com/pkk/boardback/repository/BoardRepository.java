package com.pkk.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pkk.boardback.entity.BoardEntity;
import com.pkk.boardback.repository.resultSet.GetBoardResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    BoardEntity findByBoardNumber(Integer boardNumber);

    // 일반적인 쿼리메소드를 쓸 수 없음
    // 네이티브 쿼리(sql작성), JPQL과 SQL이 있는데 SQL사용
    @Query(value = "SELECT " +
            "b.board_number AS board_number, " +
            "b.title AS title," +
            "b.content AS content, " +
            "b.write_datetime AS write_datetime, " +
            "b.writer_email AS writer_email, " +
            "u.nickname AS writer_nickname, " +
            "u.profile_image AS profile_image " +
            "FROM board AS b " +
            "INNER JOIN user AS u " +
            "ON b.writer_email = u.email " +
            "WHERE board_number = ?1 ", nativeQuery = true)
    GetBoardResultSet getBoard(Integer boardNumber);
}
