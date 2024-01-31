package com.pkk.boardback.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pkk.boardback.entity.CommentEntity;
import com.pkk.boardback.repository.resultSet.GetCommentListResultSet;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    @Query(value = "SELECT " +
            "u.nickname AS nickname, " +
            "u.profile_image AS profileImage, " +
            "c.write_datetime AS writeDatetime, " +
            "c.content AS content " +
            "FROM comment AS c " +
            "INNER JOIN user AS u " +
            "ON c.user_email = u.email " +
            "WHERE c.board_number = ?1 " +
            "ORDER BY writeDatetime DESC", nativeQuery = true)
    List<GetCommentListResultSet> getCommentList(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}
