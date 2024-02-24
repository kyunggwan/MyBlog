import React, { useEffect, useState } from "react";
import "./styles.css";
import Top3Item from "components/Top3Item";
import { BoardListItem } from "types/interface";
import top3BoardListMock from "mocks/top-3-list.mocks";

//        component: 메인 화면 컴포넌트        //
export default function Main() {
  //        state: 주간 top3 게시물 리스트 상태        //
  const [top3List, setTop3List] = useState<BoardListItem[]>([]);

  //        effect: 첫 마운트 시 실행될 함수        //
  useEffect(() => {
    setTop3List(top3BoardListMock);
  }, []);
  //        component: 메인 화면 상단 컴포넌트        //
  const MainTop = () => {
    return (
      <div id="main-top-wrapper">
        <div className="main-top-container">
          <div className="main-top-intro">
            {"Gwani board에서 \n 다양한 이야기를 나눠보세요"}
          </div>
          <div className="main-top-contents-box">
            <div className="main-top-contents-title">{"주간 TOP 3 게시글"}</div>
            <div className="main-top-contents">
              {top3List.map((top3ListItem) => (
                <Top3Item top3ListItem={top3ListItem} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  };
  //        component: 메인 화면 하단 컴포넌트        //

  const MainBottom = () => {
    return <div></div>;
  };
  //        render: 메인 화면 컴포넌트 렌더링        //
  return (
    <>
      <MainTop />
      <MainBottom />
    </>
  );
}
