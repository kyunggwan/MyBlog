// 특정한 url을 받아서, 파일 객체로 변경
export const convertUrlToFile = async (url: string) => {
  const response = await fetch(url); // url 가져옴
  const data = await response.blob(); // response를 파일 형태로 수신
  const extend = url.split(".").pop(); // 확장자 명 가져오기
  const fileName = url.split("/").pop(); // url 맨 뒤의 요소 가져오기
  const meta = { type: "image/${extend" }; // meta 데이터, type으로 생성

  return new File([data], fileName as string, meta);
};

export const convertUrlsToFile = async (urls: string[]) => {
  const files: File[] = [];
  for (const url of urls) {
    const file = await convertUrlToFile(url);
    files.push(file);
  }
  return files;
};
