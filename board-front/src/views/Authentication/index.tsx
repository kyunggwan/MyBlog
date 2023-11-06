import React, { useState } from 'react'
import './styles.css';

//              component: 인증 화면 컴포넌트               //
export default function Authentication() {

    //              state: 화면 상태                //
    const [view, setView] = useState<'sign-in' | 'sign-up'>('sign-in');

    //              component: sing in card 컴포넌트               //
    const SignInCard = () => {
        //              render: sign in card 컴포넌트 렌더링               //
        return (
            <div className='auth-card'></div>
        )
    }
    //              component: sign up card 컴포넌트               //
    const SignUpCard = () => {
        //              render: sing up card 컴포넌트 렌더링               //
        return (
            <div className='auth-card'></div>
        )
    }

    //              render: 인증 화면 컴포넌트 렌더링               //
    return (
        <div id='auth-wrapper'>
            <div className='auth-container'>
                <div className='auth-jumbotron-box'>
                    <div className='auth-jumbotron-content'>
                        <div className='auth-logo-icon'></div>
                        <div className='auth-jumbotron-text-box'>
                            <div className='auth-jumbotron-text'>{'Welcome'}</div>
                            <div className='auth-jumbotron-text'>{'Gwani Board'}</div>
                        </div>

                    </div>
                </div>
                {view === 'sign-in' && <SignInCard />}
                {view === 'sign-up' && <SignUpCard />}
            </div>
        </div>
    )
}
