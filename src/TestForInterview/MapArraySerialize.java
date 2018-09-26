package TestForInterview;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: TestForInterview
 * @description: 自定义序列化及及反序列化字典数组
 * @author: SHIMAO
 * @create: 2018-09-17 12:02
 **/
public class MapArraySerialize {

    public static void main(String[] args) {

        //测试数据
        HashMap[] mapArray = new HashMap[]{
                new HashMap<String, String>() {{
                    put("key1", "value1");
                    put("key2", "value2");
                }},
                new HashMap<String, String>() {{
                    put("key3", "value3");
                    put("key4", "value4");
                }},
                new HashMap<String, String>() {{
                    put("key5", "value5");
                }}
        };


        //调用存储方法
        String storeResult = store(mapArray);
        System.out.println(storeResult);
        /*
        输出
        key1=value1;key2=value2;
        key3=value3;key4=value4;
        key5=value5;
        */

        //调用加载方法
        HashMap[] loadResult = load(storeResult);
        System.out.println(Arrays.toString(loadResult));

        /*
        输出
        [{key1=value1, key2=value2}, {key3=value3, key4=value4}, {key5=value5}]
         */

        //非法字符串
        load("=a=\n;;=3");
          /*
        输出
        字符串不合法
         */
    }

    /**
     * @Method store
     * @Author SHIMAO
     * @Version 1.0
     * @Description 将字典数组存储为指定格式字符串:"k1=v1;k2=v2\nA=XXX"
     * @Parameter [hashMapArray]
     * @Return java.lang.String
     * @Date 2018/9/17 12:06
     */
    public static String store(HashMap<String, String>[] hashMapArray) {
        StringBuilder sb = new StringBuilder();
        //遍历数组
        for (HashMap<String, String> mapItem : hashMapArray) {
            //遍历字典
            for (Map.Entry<String, String> entry : mapItem.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(";");
            }
            sb.append(LineSeparator.Unix);
        }
        return sb.toString();
    }

    /**
     * @Method load
     * @Author SHIMAO
     * @Version 1.0
     * @Description 将指定格式字符串转换为字典数组
     * @Parameter [hashMapArrayStr]
     * @Return java.util.HashMap<java.lang.String,java.lang.String>[]
     * @Date 2018/9/17 12:06
     */
    public static HashMap<String, String>[] load(String hashMapArrayStr) {

        if (hashMapArrayStr == null || hashMapArrayStr.equals("")) {
            throw new IllegalArgumentException("字符串不合法");
        }

        ArrayList<HashMap<String, String>> hashMapArrayList = new ArrayList<>();

        //分割字典数组
        String[] mapArray = hashMapArrayStr.split(LineSeparator.Unix);
        //遍历字典数组
        for (String mapArrayItemStr : mapArray) {
            HashMap<String, String> mapResult = new HashMap<>();
            //分割字典
            String[] mapStr = mapArrayItemStr.split(";");
            //遍历字典
            for (String mapItemStr : mapStr) {
                //分割字典元素
                String[] mapItemStrArray = mapItemStr.split("=");
                if (mapItemStrArray.length != 2 || mapItemStrArray[0].equals("")) {
                    throw new IllegalArgumentException("字符串不合法");
                }
                mapResult.put(mapItemStrArray[0], mapItemStrArray[1]);
            }
            hashMapArrayList.add(mapResult);
        }

        HashMap<String, String>[] hashMapArray = new HashMap[hashMapArrayList.size()];
        return hashMapArrayList.toArray(hashMapArray);
    }
}


