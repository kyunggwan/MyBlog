import React, { useState } from 'react'
import './styles.css';
import defaultProfileImage from 'assets/image/default-profile-image.png';

//              component: 게시물 상세 화면 컴포넌트               //
export default function BoardDetail() {


    //              component: 게시물 상세 상단 컴포넌트               //
    const BoardDetailTop = () => {

        //              state: nire 버튼 상태               //
        const [showMore, setShowMore] = useState<boolean>(false);

        //              event handler: more 버튼 클릭 이벤트 처리               //
        const onMoreButtonClickHandler = () => {
            setShowMore(!showMore);
        }
        return (
            <div id='board-detail-top'>
                <div className='board-detail-top-header'>
                    <div className='board-detail-title'>{'title'}</div>
                    <div className='board-detail-top-sub-box'>
                        <div className='board-detil-write-info-box'></div>
                        <div className='board-detail-writer-profile-image' style={{ backgroundImage: `url(${defaultProfileImage})` }}></div>
                        <div className='board-detail-writer-nickname'>{'nickname'}</div>
                        <div className='board-detail-writer-info-divider'>{'/'}</div>
                        <div className='board-detail-write-date'>{'날짜'}</div>
                    </div>
                    <div className='icon-button' onClick={onMoreButtonClickHandler}>
                        <div className='icon more-icon'></div>
                    </div>
                    {showMore && <div className='board-detail-more-box'>
                        <div className='board-detail-update-button'>{'수정'}</div>
                        <div className='divider'>{'/'}</div>
                        <div className='board-detail-delete-button'>{'삭제'}</div>
                    </div>
                    }

                </div>
                <div className='divider'></div>
                <div className='board-detail-top-main'>
                    <div className='board-detail-main-text'>{'main text'}</div>
                    {/* <div className='board-detail-main-image' style={{backgroundImage=`url(${})`}}> */}

                    {/* </div> */}
                </div>
            </div>
        );
    }

    //              component: 게시물 상세 하단 컴포넌트               //
    const BoardDetailBottom = () => {
        return (
            <div className='board-detail-bottom'>
                <div className='board-detail-bottom-button-box'>
                    <div className='board-detail-bottom-button-group'>
                        <div className='icon-button'>
                            <div className='icon favorite-fill-icon'></div>
                        </div>
                    </div>
                </div>
                <div className='board-detail-bottom-favoeite-box'></div>
                <div className='board-detail-bottom-comment-box'></div>
            </div>
        );
    }

    //              render: 게시물 상세 화면 컴포넌트 렌더링               //
    return (
        <div id='board-detail-wrapper'>
            <div className='bord-detail-container'>
                <BoardDetailTop />
                <BoardDetailBottom />
            </div>
        </div>
    )
}
