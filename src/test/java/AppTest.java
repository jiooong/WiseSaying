import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void Rq__getIntParam(){
        Rq rq = new Rq("삭제?id=1");

        int id = rq.getIntParam("id",0);//rq한테 부탁한다
        assertEquals(1,id);

    }
    @Test
    public void Rq__getPath(){
        Rq rq = new Rq("삭제?id=1");
        String path = rq.getPath();


        assertEquals("삭제",path);


    }
    @Test
    public void Rq__getIntParam__2(){
        Rq rq = new Rq("삭제?id=10&no=1");

        int id = rq.getIntParam("id",0);//rq한테 부탁한다
        int no = rq.getIntParam("no",0);
        assertEquals(10,id);
        assertEquals(1,no);

    }
    @Test
    public void 문자열을_스캐너의_입력으로_설정(){ //미리 입력된 명령어를 받아들일 수 있는 스캐너 객체
        String input= """ 
               등록
               명언
               작가
                """.stripIndent();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in); //system.in말고 in만 하면 자동으로 스캐너가 생성되면서 들어간다.
        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();

        assertEquals("등록", cmd);
        assertEquals("작가", author);
        assertEquals("명언", content);
    }
    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        //표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");//1

        String rs = output.toString().trim(); //1이 차곡차곡 쌓인다
        //표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();


        assertEquals("안녕", rs);
    }


}
