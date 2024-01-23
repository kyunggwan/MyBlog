package com.pkk.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pkk.boardback.entity.BoardEntity;
import com.pkk.boardback.repository.resultSet.GetBoardResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    boolean existsByBoardNumber(Integer BoardNumber);
    BoardEntity findByBoardNumber(Integer boardNumber);

    // 일반적인 쿼리메소드를 쓸 수 없음
    // 네이티브 쿼리(sql작성), JPQL과 SQL이 있는데 SQL사용
    @Query(value = "SELECT " +
            "b.board_number AS boardNumber, " +
            "b.title AS title," +
            "b.content AS content, " +
            "b.write_datetime AS writeDatetime, " +
            "b.writer_email AS writerEmail, " +
            "u.nickname AS writerNickname, " +
            "u.profile_image AS writerProfileImage " +
            "FROM board AS b " +
            "INNER JOIN user AS u " +
            "ON b.writer_email = u.email " +
            "WHERE board_Number = ?1 ", nativeQuery = true)
    GetBoardResultSet getBoard(Integer boardNumber);
}
