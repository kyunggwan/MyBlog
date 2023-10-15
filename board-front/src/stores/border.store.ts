import { create } from "zustand";

interface BoardStore {
    title: string;
    content: string;
    boardImgFileList: File[];
    setTitle: (title: string) => void;
    setContent: (content: string) => void;
    setBoardImgFileList: (boardImgFileList: File[]) => void;
    resetBoard: () => void;
};

const useBoardStore = create<BoardStore>(set => ({
    title: '',
    content: '',
    boardImgFileList: [],
    setTitle: (title) => set(state => ({ ...state, title })),
    setContent: (content) => set(state => ({ ...state, content })),
    setBoardImgFileList: (boardImgFileList) => set(state => ({ ...state, boardImgFileList })),
    resetBoard: () => set(state => ({ ...state, title: '', content: '', boardImgFileList: [] })),
}))

export default useBoardStore;