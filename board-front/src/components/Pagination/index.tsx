import React from "react";
import "./style.css";

//        component: 페이지네이션 컴포넌트        //
export default function Pagination() {
  //        render: 페이지네이션 컴포넌트 렌더링        //
  return <div id='pagination-wrapper'>
    <div className="pageination-change-link-box"></div>
    <div className="pagination-divider">{'\|'}</div>
    
    <div className="pagination-divider">{'\|'}</div>
    <div className="pagination-change-link-box"></div>
  </div>;
}
