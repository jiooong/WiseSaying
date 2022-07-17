import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

Scanner sc;
List<WiseSaying> wiseSayingarray;

public App(){
    sc =new Scanner(System.in);
}
    int wiseId;

    public void run() {
        System.out.println("==명언 SSG==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);



            String[] cmdBits = cmd.split("//?",2);

            String path = cmdBits[0];
            String queryStr = cmdBits.length ==2 ? cmdBits[1] : null;

            switch(rq.getPath()){
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
                case "삭제":
                    wiseSayingController.delete(rq);
                    break;
                case "목록":
                    wiseSayingController.show(rq);
                    break;
                case "등록":
                    wiseSayingController.write(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}

