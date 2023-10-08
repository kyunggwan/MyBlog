import "./styles.css";

//              component: footer 레이아웃              //
export default function Footer() {

    //              render: footer 레이아웃 렌더링              //
    return (
        <div id="footer">
            <div className="footer-container">
                <div className="footer-top">
                    <div className="footer-logo-box">
                        <div className="icon-box">
                            <div className="logo-light-icon"></div>
                            <div className="footer-logo-text"></div>
                        </div>
                    </div>
                    <div className="footer-link-box">
                        <div className="footer-email-link"></div>
                        <div className="icon-button">
                            <div className="insta-icon"></div>
                        </div>
                        <div className="icon-button">
                            <div className="naver-icon"></div>
                        </div>
                    </div>
                </div>
                <div className="footer-bottom">
                    <div className="footer-copyright">

                    </div>
                </div>
            </div>
        </div>
    )
}