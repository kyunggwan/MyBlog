import React from 'react'
import "./styles.css";
import { useNavigate } from 'react-router-dom';
import { MAIN_PATH } from 'constant';

//              component: 헤더 레이아웃                //
export default function Header() {

    //              functions: 네비게이트 함수              //
    const navigate = useNavigate();

    //              event handler: 로고 클릭 이벤트 처리 함수               //
    const onLogoClickHandler = () => {
        navigate(MAIN_PATH());
    }

    //              render: 헤더 레이아웃 렌더링                //
    return (
        <div id='header'>
            <div className='header-container'>
                <div className='header-left-box' onClick={onLogoClickHandler}>
                    <div className='icon-box'>
                        <div className='icon logo-dark-icon'></div>
                    </div>
                    <div className='header-logo'>
                        {'Gwani Board'}
                    </div>
                </div>
                <div className='header-right-box'></div>
            </div>
        </div>
    )
}
