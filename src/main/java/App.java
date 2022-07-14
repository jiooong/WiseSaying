import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

Scanner sc;
List<WiseSaying> wiseSayingarray;

public App(){
    sc =new Scanner(System.in);
    wiseSayingarray = new ArrayList();
}
    int wiseId;

    public void run() {
        System.out.println("==명언 SSG==");

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);



            String[] cmdBits = cmd.split("//?",2); //cmd를 물음표 기준으로 두동강낸다.
            String path = cmdBits[0];
            String queryStr = cmdBits.length ==2 ? cmdBits[1] : null;

            switch(rq.getPath()){
                case "삭제":
                    delete(rq);
                    break;
                case "목록":
                    show(rq);
                    break;
                case "등록":
                    write(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
    }


    public void write(Rq rq){

        System.out.print("명언: ");
        String content = sc.nextLine();
        System.out.print("작가: ");
        String author = sc.nextLine();
        int id= ++wiseId;
        System.out.println(id+"번째 명언이 등록되었습니다.");

        WiseSaying wisesaying = new WiseSaying(id,content,author);
        wiseSayingarray.add(wisesaying);

    }

    public void show(Rq rq){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------");
        for(int i=wiseSayingarray.size()-1; i>=0; i--){
            WiseSaying wise = (WiseSaying) wiseSayingarray.get(i);
            System.out.printf("%d / %s / %s\n", wise.id, wise.content, wise.author);
        }

    }
    public void delete(Rq rq){
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }
        WiseSaying foundWiseSaying = findById(paramId);
        
        // URL에 입력된 id에 해당하는 명언객체 찾기
        /*WiseSaying foundWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayingarray) {
            if (wiseSaying.id == paramId) {
                foundWiseSaying = wiseSaying;
            }
        }*/

        // 찾지 못했다면 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayingarray.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    private WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayingarray) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }
        return null;
    }

}

