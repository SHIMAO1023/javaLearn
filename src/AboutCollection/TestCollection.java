package AboutCollection;/**
 * @ProjectName: javaLearn
 * @Package: AboutCollection
 * @ClassName: TestCollection
 * @Author: shima
 * @Description:
 * @Date: 2018/11/6 14:22
 * @Version: 1.0
 */

import java.util.*;

/**
 * @program: javaLearn
 * @description:
 * @author: shimao
 * @create: 2018-11-06 14:22
 **/
public class TestCollection {

    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
        }};

        Iterator<String> it = hs.iterator();

        while (it.hasNext()) {
            System.out.println(it.next() + "\n");
        }

        for (String item : hs) {
            System.out.println(item + "\n");
        }
        HashMap<Integer, String> hm = new HashMap<Integer, String>() {{
            put(1, "a");
        }};

        List<String> ls=new ArrayList<>();
        ls.add("a");

        Object o=new Object();
    }

}
