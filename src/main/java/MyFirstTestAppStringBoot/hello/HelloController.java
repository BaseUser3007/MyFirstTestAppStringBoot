package MyFirstTestAppStringBoot.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    private ArrayList<String> arrayList;
    private HashMap<Integer, String> hashMap;
    private int keyCount = 0;

    @GetMapping("/MyFirstTestAppStringBoot/hello")
    public String hello(@RequestParam(value = "name",
                        defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s")
                                      String s) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(s);
        return "В ArrayList добавлено: " + s;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        keyCount++;
        hashMap.put(keyCount, s);
        return "В HashMap добавлено: " + keyCount + " = " + s;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        if (hashMap == null) {
            return new HashMap<>();
        }
        return hashMap;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int listSize = (arrayList == null) ? 0 : arrayList.size();
        int mapSize = (hashMap == null) ? 0 : hashMap.size();
        return "Количество элементов в ArrayList: " + listSize
                + ", в HashMap: " + mapSize;
    }
}
