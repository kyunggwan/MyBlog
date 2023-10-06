import React from "react";
import "./styles.css";
import defaultProfileImage from "assets/image/default-profile-image.png";
import { BoardListItem } from "types/interface";
import { useNavigate } from "react-router-dom";

interface Props {
  top3ListItem: BoardListItem;
}
//              component: Top3 List Item 컴포넌트              //
export default function Top3Item({ top3ListItem }: Props) {
  //              propertyies             //
  const {
    boardNumber,
    title,
    content,
    boardTitleImage,
    favoriteCount,
    commentCount,
    viewCount,
    writeDateTime,
    writerNickname,
    writerProfileImage,
  } = top3ListItem;

  //                function: 네비게이트 함수               //
  //   const navigator = useNavigate();

  //              event handler: 게시물 아이템 클릭 이벤트 처리 함수              //
  const onClickHandler = () => {
    // navigator(boardNumber);
  };

  //              render: Top3 List Item 렌더링              //
  return (
    <div
      className="top-3-list-item"
      style={{ backgroundImage: `url(${boardTitleImage})` }}
      onClick={onClickHandler}
    >
      <div className="top-3-list-item-main-box">
        <div className="top-3-list-item-top">
          <div className="top-3-list-item-profile-box">
            <div
              className="top-3-list-item-profile-image"
              style={{
                backgroundImage: `url(${
                  writerProfileImage ? writerProfileImage : defaultProfileImage
                })`,
              }}
            ></div>
          </div>
          <div className="top-3-list-item-write-box">
            <div className="top-3-list-item-nickname">{writerNickname}</div>
            <div className="top-3-list-item-write-date">{writeDateTime}</div>
          </div>
        </div>
        <div className="top-3-list-item-main-middle">
          <div className="top-3-list-item-title">{title}</div>
          <div className="top-3-list-item-content">{content}</div>
        </div>
        <div className="top-3-list-item-main-bottom">
          <div className="top-3-list-item-counts">{`댓글 ${commentCount} · 좋아요 ${favoriteCount} · 조회수 ${viewCount}`}</div>
        </div>
      </div>
    </div>
  );
}
