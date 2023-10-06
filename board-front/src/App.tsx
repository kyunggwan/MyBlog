import BoardItem from "components/BoardItem";
import "./App.css";
import latestBoardListMock from "mocks/latest-board-list.mocks";
import Top3Item from "components/Top3Item";
import top3BoardListMock from "mocks/top-3-list.mocks";

function App() {
  return (
    <>
      <div style={{ display: "flex", justifyContent: "center", gap: "24px" }}>
        {/* {latestBoardListMock.map((boardListItem) => (
        <BoardItem boardListItem={boardListItem} />
      ))} */}
        {/* <Top3Item /> */}
        {top3BoardListMock.map(top3ListItem => <Top3Item top3ListItem={top3ListItem} />)}
      </div>
    </>
  );
}

export default App;
