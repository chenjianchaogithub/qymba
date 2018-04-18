package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;


/**
 * 参数Map
 * 
 * @author Dylin
 * 
 * @param <K>
 * @param <V>
 */
public class ParamMap extends WeakHashMap<String, Object> {

	/**
	 * 从参数中取出字符
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		// TODO 防注入处理
		String t = (String) get(key);
		if (t == null || "null".equals(t))
			t = "";
		return t;
	}

	/**
	 * 判断指定key中的值与指定的值是否相等
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean equals(String key, String value) {
		return value.equals(getString(key));
	}

	/**
	 * 安全性过滤
	 * 
	 * @param str
	 * @return
	 */
	public String safe(String str) {
		// TODO
		return str;
	}

	/**
	 * 获取整数
	 * 
	 * @param key
	 * @return
	 */
	public int getInt(String key) {
		if (this.isNull(key))
			return 0;
		try {
			return Integer.parseInt(this.getString(key));
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	/**
	 * 把指定键的内容转化成为整形集，用于搜索集
	 * @param key
	 * @return
	 */
	public List<Integer> getIntArr(String key) {
		List<Integer> rs = new ArrayList<Integer>();
		Object obj = this.get(key);
		String[] tgs;
		if (obj instanceof ArrayList) return rs;

		if (obj.getClass().isArray()) tgs = (String[]) obj;
		else tgs = this.getString(key).split(",");
		
		for (int i=0; i<tgs.length; i++) try {
			if (Str.isNaN(tgs[i].toString())) continue;
			rs.add(Integer.parseInt(tgs[i].toString()));
		} catch (NumberFormatException e) { }
		if (rs.size()==0) return null;
		else return rs;	
	}
	
	/**
	 * 把指定键的参数内容转化成为整形集
	 * @param key
	 * @return
	 */
	public List<Integer> changeIntArr(String key) {
		List<Integer> rs = this.getIntArr(key);
		if (null == rs) this.remove(key);
		else this.put(key, rs);
		return rs;
	}
	
	/**
	 * 搜索关键字转换
	 * @param key
	 * @return
	 */
	public List<String> changeKeywords(String key) {
		List<String> rs = new ArrayList<String>();
		String kw = this.getString(key);
		if (Str.isEmpty(kw)) {
			this.remove(key);
			return null;
		}
		// TODO 防主入处理
		
		rs.add(kw);
		// 拆分成多个关键字
		kw = kw.replace(",", " ").replace("，", " ").replace("  ", " ");
		String[] tgs = kw.split(" ");
		for (int i=0; i<tgs.length; i++) {
			if (Str.isEmpty(tgs[i])) continue;
			rs.add(tgs[i]);
		}
		if (rs.size()==0) this.remove(key);
		else this.put(key, rs);
		return rs;
	}
	
	public Integer changeInt(String key) {
		if (isNaN(key)) {
			this.remove(key);
			return null;
		} else {
			this.put(key, this.getInt(key));
			return (Integer) this.get(key);
		}
	}
	
	/**
	 * 效验  sql 注入
	 * @param str
	 * @return
	 */

    public  boolean sqlValidate(String str) {  
        str = str.toLowerCase();//统一转为小写  
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +  
                "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +  
                "table|from|grant|use|group_concat|column_name|" +  
                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +  
                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";//过滤掉的sql关键字，可以手动添加  
        String[] badStrs = badStr.split("\\|");  
        for (int i = 0; i < badStrs.length; i++) {  
            if (str.indexOf(badStrs[i]) > -1)  return true; 
        }  
        return false;  
    }  

	
	/**
	 * 获取Long
	 * 
	 * @param key
	 * @return
	 */
	public long getLong(String key) {
		if (this.isNull(key))
			return 0;
		try {
			return Long.parseLong(this.getString(key));
		} catch (NumberFormatException e) {
			return 0;
		}
	}


	/**
	 * 获取浮点数
	 * 
	 * @param key
	 * @return
	 */
	public float getFloat(String key) {
		if (this.isNull(key))
			return 0;
		try {
			return Float.parseFloat(getString(key));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/**
	 * 获取布尔值
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key) {
		if (this.isNull(key))
			return false;
		return "1".equals(getString(key)) || Boolean.parseBoolean(getString(key));
	}

	/**
	 * 获取指定格式的日期
	 * 
	 * @param key
	 * @param format
	 * @return
	 */
	public String getDate(String key, String format) {
		// TODO
		return null;
	}

	/**
	 * 获取yyyy-MM-dd格式的日期
	 * 
	 * @param key
	 * @return
	 */
	public String getDate(String key) {
		return getDate(key, "yyyy-MM-dd");
	}

	/**
	 * 判断指定键的值是否为空
	 * 
	 * @param key
	 * @return
	 */
	public boolean isNull(String key) {
		String t = (String) get(key);
		return (t == null || "null".equals(t.trim()) || "".equals(t.trim()));
	}

	/**
	 * 判断指定键的值是否为空
	 * 
	 * @param key
	 * @return
	 */
	public boolean isEmpty(String key) {
		return isNull(key);
	}

	/**
	 * 数字
	 * 
	 * @param key
	 * @param errMsg
	 * @return
	 */
	public boolean isNumeric(String key) {
		return !Str.isNaN(getString(key));
	}

	/**
	 * 判断指定key的值不是数字
	 * 
	 * @param key
	 * @return
	 */
	public boolean isNaN(String key) {
		return Str.isNaN(getString(key));
	}

	/**
	 * 整数验证
	 * 
	 * @param key
	 * @param errMsg
	 * @return
	 */
	public boolean isInt(String key) {
		try {
			Integer.parseInt(getString(key));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 浮点娄验证
	 * 
	 * @param key
	 * @param errMsg
	 * @return
	 */
	public boolean isFloat(String key, String errMsg) {
		// TODO
		return true;
	}

	/**
	 * 日期格式验证 根据指定的格式
	 * 
	 * @param key
	 * @param errMsg
	 * @param format
	 * @return
	 */
	public boolean isDate(String key, String errMsg, String format) {
		// TODO
		return true;
	}

	/**
	 * 日期格式的验证 yyyy-MM-dd格式
	 * 
	 * @param key
	 * @param errMsg
	 * @return
	 */
	public boolean isDate(String key, String errMsg) {
		return isDate(key, errMsg, "yyyy-MM-dd");
	}

	/**
	 * 手机号码验证
	 * 
	 * @param key
	 * @param errMsg
	 * @return
	 */
	public boolean mob(String key, String errMsg) {
		// TODO
		return true;
	}

	/**
	 * 邮箱验证
	 * 
	 * @param key
	 * @param errMsg
	 * @return
	 */
	public boolean email(String key, String errMsg) {
		// TODO
		return true;
	}

	/**
	 * 身份证验证
	 * 
	 * @param key
	 * @param errMsg
	 * @return
	 */
	public boolean creditcard(String key, String errMsg) {
		// TODO
		return true;
	}
	
	public ParamMap turnPage(Integer total) {
		return turnPage(Long.valueOf(total));
	}
	/**
	 * 翻页操作，这个方法只有当通过param转换同Map后调用之后才有效
	 * @param total 结果总条娄
	 * @return
	 */
	public ParamMap turnPage(Long total) {
		// 调整每页大小
		int pageSize = 20;
		if (!this.isNaN("pageSize"))
			pageSize = this.getInt("pageSize");
		else if (!this.isNaN("pagesize"))
			pageSize = this.getInt("pagesize");
		if (pageSize==0) pageSize = 20;
		// 正确的pageSize
		this.put("pageSize", pageSize);		 
		// 调整第几页
		long page = 1;
		// 当前支持前端两个参数currentPage和page两种写法
		if (!this.isNaN("currentPage")) 
			page = this.getInt("currentPage");
		else if (!this.isNaN("currentpage"))
			page = this.getInt("currentpage");
		else if (!this.isNaN("page")) 
			page = this.getInt("page");
		// 计算总页数
		long tPage = (long) Math.ceil(total / pageSize);
		// 重设正确的页数
		this.put("currentPage", page<1 ? 1 : (page>tPage ? tPage : page));
		// 开始的位置
		this.put("startCount", ((page - 1) * pageSize));
		return this;
	}

}
