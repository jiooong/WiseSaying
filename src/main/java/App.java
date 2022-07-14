import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    ArrayList  wiseSayingarray = new ArrayList();

    int wiseId;

    public void run() {
        System.out.println("==명언 SSG==");

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            String[] cmdBits = cmd.split("//?",2); //cmd를 물음표 기준으로 두동강낸다.
            String path = cmdBits[0];
            String queryStr = cmdBits.length ==2 ? cmdBits[1] : null;

            switch(path){

                case "목록":
                    show();
                    break;
                case "등록":
                    write();
                    break;
                case "종료":
                    break outer;
            }
        }
    }


    public void write(){

        System.out.print("명언: ");
        String content = sc.nextLine();
        System.out.print("작가: ");
        String author = sc.nextLine();
        int id= ++wiseId;
        System.out.println(id+"번째 명언이 등록되었습니다.");

        WiseSaying wisesaying = new WiseSaying(id,content,author);
        wiseSayingarray.add(wisesaying);

    }

    public void show(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------");
        for(int i=wiseSayingarray.size()-1; i>=0; i--){
            WiseSaying wise = (WiseSaying) wiseSayingarray.get(i);
            System.out.printf("%d / %s / %s\n", wise.id, wise.content, wise.author);
        }

    }
}

