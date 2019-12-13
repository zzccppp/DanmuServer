package info.zzdirty.main;

import com.alibaba.fastjson.JSON;

/**
 * @author ZZDirty
 */
public class Test {
    public static void main(String[] args) {
        DanmuDataBean b = new DanmuDataBean();
        b.setColor("cc");
        b.setVersion("vv");
        b.setContenttype("ctt");
        b.setId("iddd");
        b.setEncode("encode");
        b.setText("text");
        b.setSize("ssss");
        b.setType("ttss");
        b.setTime(String.valueOf(System.currentTimeMillis()));

        String jsonString = JSON.toJSONString(b);
        //System.out.println(jsonString);

        System.out.println("1190201209".matches("119020[0-2][0-9][0-3][0-9]"));
    }
}
