import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    //데이터를 저장하고 보관하는 담당, 데이터 관리하는 녀석
   public List<WiseSaying> wiseSayings;
    public int wiseSayingLastId;
    WiseSayingRepository(){
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }
    public void modify(int paramId, String content, String author) {
        WiseSaying foundWiseSaying = findById(paramId);
        foundWiseSaying.content = content;
        foundWiseSaying.author = author;

    }
    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }
    public void delete(int paramId) {
        WiseSaying foundWiseSaying = findById(paramId);
        wiseSayings.remove(foundWiseSaying);
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }

        return null;
    }

}
