package com.pkk.boardback.dto.object;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Comment;

import com.pkk.boardback.repository.resultSet.GetCommentListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentListItem {

    private String nickname;
    private String profileImage;
    private String writeDatetime;
    private String content;

    public CommentListItem(GetCommentListResultSet resultSets) {
        this.nickname = resultSets.getNickname();
        this.profileImage = resultSets.getProfileImage();
        this.writeDatetime = resultSets.getWriteDatetime();
        this.content = resultSets.getContent();
    }

    public static List<CommentListItem> copyList(List<GetCommentListResultSet> resultSets) {
        List<CommentListItem> list = new ArrayList<>();

        for (GetCommentListResultSet resultSet : resultSets) {
            CommentListItem commentListItem = new CommentListItem(resultSet);
            list.add(commentListItem);
        }

        return list;

    }
}
