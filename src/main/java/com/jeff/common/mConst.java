package com.jeff.common;

import java.util.HashMap;


public class mConst {

	public final static String serverName = "招新报名平台";// 项目名

	public final static String serverCopyright = "&copy; All Rights Reserved.";// 版权

	public final static String Version = "V2.1";// 版本号

	// 服务器IP：192.168.1.88
	// 本地测试：192.168.0.1
	public final static String serverIp = "120.27.110.198";
	public final static String ItvServerIp = "192.168.0.1";

	// 本系统ip+port
	public final static String WebHostPort = "120.27.110.198:8080";// 119.145.142.115:8080//公网地址

	public final static String Quartz_Time = "0 0/1 * * * ?"; // 调度器频率
	public final static Integer Quartz_ReStart_Time = 3; // 分钟，该值需要比上面的调度器频率Quartz_Time大，保证调度器能起码执行2次。
	public final static Integer Thread_Time = 5; // 分钟，该值需要比上面的重启时间Quartz_ReStart_Time大，保证调度器能起码执行2次。

	public final static String DB_Info = ""; // 数据库信息

	// 图片目录
	public final static String UPLOAD_FILE_PATH = "C:/app/community/upload/";// 上传到指定的位置

	// 题目加密key
	public final static String KEY = "Y586U465l05Gv9H2";

	public final static String STATE_T = "T"; // 状态：有效

	public final static String STATE_F = "F"; // 状态：无效
	
	public final static String STATE_H = "H"; // 状态：未操作面试结果
	
	@SuppressWarnings("serial")
	public static final HashMap<String, String> MESSAGE_MAP = new HashMap<String, String>() {
		{
			put(mConst.STATE_T, "通过");
			put(mConst.STATE_F, "未通过");
			put(mConst.STATE_H, "未决定");
			put(null, "未决定");
		}
	};
	
	

}
