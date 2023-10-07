import BoardItem from "components/BoardItem";
import "./App.css";
import latestBoardListMock from "mocks/latest-board-list.mocks";
import Top3Item from "components/Top3Item";
import top3BoardListMock from "mocks/top-3-list.mocks";
import InputBox from "components/InputBox";
import { useState } from "react";

function App() {

  const [value, setvalue] = useState<string>("");
  return (
    <>
      <div >
        <InputBox label="이메일" type='text' placeholder="이메일 주소를 입력해주세요" value={value} error={true} setValue={setvalue} message="" />
      </div>
    </>
  );
}

export default App;
