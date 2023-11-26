import React, { ChangeEvent, useEffect, useRef, useState } from 'react'
import './styles.css';
import { useBoardStore } from 'stores';

//              component: 게시물 작성 화면 컴포넌트               //
export default function BoardWrite() {
    //              state: 본문 영역 요소 참조 상태               //
    const contentRef = useRef<HTMLTextAreaElement | null>(null);
    //              state: 이미지 입력 요소 참조 상태               //
    const imageInputRef = useRef<HTMLInputElement | null>(null);
    //              state: 게시물 상태              //
    const { title, setTitle } = useBoardStore();
    const { content, setContent } = useBoardStore();
    const { boardImgFileList, setBoardImgFileList } = useBoardStore();
    const { resetBoard } = useBoardStore();

    //              state: 게시물 이미지 미리보기 URL 상태              //
    const [imageUrls, setImageUrls] = useState<string[]>([]);

    //              event handler: 제목 변경 이벤트 처리                //
    const onTitleChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const { value } = event.target;
    }

    //              effect: 마운트 시 실행할 함수               //
    useEffect(() => {
        resetBoard();
    }, [])

    //              render: 게시물 작성 화면 컴포넌트 렌더링               //
    return (
        <div id='board-write-wrapper'>
            <div className='board-write-container'>
                <div className='board-write-box'>
                    <div className='board-wirte-title-box'>
                        <input className='board-write-title-input' type='text' placeholder='제목을 작성해주세요.' value={title} />
                    </div>
                    <div className='divider'></div>
                    <div className='board-write-content-box'>
                        <textarea ref={contentRef} className='board-write-content-textarea' placeholder='본문을 작성해주세요.' value={content} />
                        <div className='icon-button'>
                            <div className='icon image-box-light-icon'></div>
                        </div>
                        <input ref={imageInputRef} type='file' accept='image/*' style={{ display: 'none' }} />
                    </div>
                    <div className='board-write-images-box'>
                        <div className='board-write-image-box'>
                            <img className='board-write-image' src='https://search.pstatic.net/sunny/?src=https%3A%2F%2Fcdn.crowdpic.net%2Fdetail-thumb%2Fthumb_d_23F8B01DC9DCBE56216EED03018D4C7D.jpg&type=sc960_832' />
                            <div className='icon-button image-close'>
                                <div className='icon close-icon'></div>
                            </div>
                        </div>

                    </div>
                    <div className='board-write-images-box'>
                        <div className='board-write-image-box'>
                            <img className='board-write-image' src='https://search.pstatic.net/sunny/?src=https%3A%2F%2Fcdn.crowdpic.net%2Fdetail-thumb%2Fthumb_d_FBF1146EF4F1BEF77E19827EDE16CC42.jpeg&type=sc960_832' />
                            <div className='icon-button image-close'>
                                <div className='icon close-icon'></div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    )
}
