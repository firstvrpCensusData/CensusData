package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenyuan on 15/8/28.
 */
public class GetNowTime {
    public static String getNowTime(){
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");//设置日期格式
        String nowTime = df.format(new Date());
        return nowTime;
    }
}
