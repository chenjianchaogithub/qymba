package com.util;

import com.core.exception.DataNotExistException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 字符串处理扩展类
 * 
 * @author Dave Lin
 * 
 */
public class Str {

	/**
	 * 判断元素是否在数组中
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean inArray(String[] arr, String targetValue) {
	    for(String s: arr){
	        if(s.equals(targetValue))
	            return true;
	    }
	    return false;
	}
	
	public static String join(String[] arr) {
		String tmp = "";
		for (String t : arr) {
			tmp += tmp.length()>0 ? (","+t) : t;
		}
		return tmp;
	}
	/**
	 * 字符串是否为空
	 * 
	 * @param str
	 * @return null 或 "" 返回true
	 */
	public static boolean isEmpty(String str) {
		if (str==null) return true;
		str = str.trim();
		return ("".equals(str)) || ("null".equalsIgnoreCase(str));
	}
	
	/**
	 * 检测字串是不是一个日期格式 yyyy-MM-dd
	 * @param str
	 * @return
	 */
	public static boolean isDate(String str) {
		return isDate(str, "yyyy-MM-dd");
	}
	
	/**
	 * 检测字串是不是一个时间格式
	 * @param str
	 * @param format
	 * @return
	 */
	public static boolean isDate(String str, String format) {
		if (isEmpty(str)) return false;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat frm = new SimpleDateFormat(format);
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，
			// 比如2007/02/29会被接受，并转换成2007/03/01
			frm.setLenient(false);
			frm.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		} 
       return true;
	}

	/**
	 * 首字母小写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstLow(String str) {
		if (isEmpty(str))
			return "";
		return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toLowerCase());
	}

	/**
	 * 首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstUpp(String str) {
		if (isEmpty(str))
			return "";
		return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
	}

	/**
	 * 不是一纯数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNaN(String str) {
		if (isEmpty(str))
			return true;
		return !str.matches("\\d*");
	}

	/**
	 * 不是一纯数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNaN(Object obj) {
		if (obj == null)
			return true;
		return isNaN(obj.toString());
	}

	/**
	 * 把中文转成Unicode码
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnicode(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
				result += "\\u" + Integer.toHexString(chr1);
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	/**
	 * Unicode码转中文
	 * 
	 * @param string
	 * @return
	 */
	public static String unicodeToCN(String unicode) {
		String str = unicode.replace("\\u", ",");
		String[] s2 = str.split(",");
		String s1 = "";
		for (int i = 1; i < s2.length; i++) {
			s1 = s1 + (char) Integer.parseInt(s2[i], 16);
		}
		return s1;
	}

	/**
	 * 转化路径
	 * 
	 * @param path
	 * @return
	 */
	public static String path(String path) {
		return path.replace("\\", "/").replace("//", "/");
	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}

	/**
	 * 检测邮箱地址是否合法
	 * 
	 * @param email
	 * @return true合法 false不合法
	 */
	public static boolean isEmail(String email) {
		if (null == email || "".equals(email))
			return false;
		// Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 把中文转成Unicode码
	 * 
	 * @param str
	 * @return
	 */
	public static String chinaToUnicode(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
				result += "\\u" + Integer.toHexString(chr1);
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	/**
	 * 判断是否为中文字符
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串中是否含有中文字符
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainChn(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		return (p.matcher(str).find());
	}

	public static String string2Unicode(String s) {
		try {
			StringBuffer out = new StringBuffer("");
			byte[] bytes = s.getBytes("unicode");
			for (int i = 2; i < bytes.length - 1; i += 2) {
				out.append("u");
				String str = Integer.toHexString(bytes[i + 1] & 0xff);
				for (int j = str.length(); j < 2; j++) {
					out.append("0");
				}
				String str1 = Integer.toHexString(bytes[i] & 0xff);

				out.append(str);
				out.append(str1);
				out.append(" ");
			}
			return out.toString().toUpperCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String unicode2String(String unicodeStr) {
		StringBuffer sb = new StringBuffer();
		String str[] = unicodeStr.toUpperCase().split("U");
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(""))
				continue;
			char c = (char) Integer.parseInt(str[i].trim(), 16);
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * 判断是否是指定位数重复或递增、递减的的符
	 * 
	 * @param numOrStr
	 * @param bit
	 * @return
	 */
	public static boolean isOrder(String numOrStr, int bit) {
		int upNum = 1;// 递增个数
		int dwNum = 1;// 递减个数
		int smNum = 1;// 相同个数
		int before, after;
		char str = numOrStr.charAt(0);
		for (int i = 0; i < numOrStr.length(); i++) {
			// 检查是还相同
			if (str == numOrStr.charAt(i)) {
				smNum++;
				if (smNum >= bit) // 连续多个相同字段
					return true;
			} else {
				str = numOrStr.charAt(i);
				smNum = 1;
			}
			if (!Character.isDigit(numOrStr.charAt(i)) || (i > 0 && !Character.isDigit(numOrStr.charAt(i - 1)))) { // 见到非数字
				upNum = 1;
				dwNum = 1;
			} else if (i > 0) {
				before = Integer.parseInt(numOrStr.charAt(i - 1) + "");
				after = Integer.parseInt(numOrStr.charAt(i) + "");
				// 检查递增
				if (before == (after - 1)) {
					upNum++;
					if (upNum >= bit)
						return true;
				} else
					upNum = 1;
				// 检查递减
				if (before == (after + 1)) {
					dwNum++;
					if (dwNum >= bit)
						return true;
				} else
					dwNum = 1;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param str
	 *            补零字符串
	 * @param strLength
	 *            指定长度
	 * @param left
	 *            true 左边补零 、false右边补零
	 * @return
	 */
	public static String addZeroForNum(String str, int strLength, boolean left) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				if (left)
					sb.append("0").append(str);// 左补0
				else
					sb.append(str).append("0");// 右补0
				str = sb.toString();
				strLen = str.length();
			}
		}

		return str;
	}

	/**
	 * 过滤字母
	 * 
	 * @param str
	 * @return
	 */
	public static String filterChar(String str) {
		return str.replaceAll("[a-zA-Z]", "");
	}

	/**
	 * 过滤所有符号，不包含小数点
	 * 
	 * @param str
	 * @return
	 */
	public static String filterSymbol(String str) {
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		return str.replaceAll(regEx, "");
	}

	/**
	 * 把list串连成以,分隔的字串
	 * 
	 * @param list
	 * @return
	 */
	public static String join(List<?> list) {
		if (null == list || list.size() == 0)
			return "";
		String s = "";
		for (int i = 0; i < list.size(); i++) {
			s += (s.length() > 0 ? "," : "") + list.get(i);
		}
		return s;
	}

	/**
	 * 把id串转成List
	 * 
	 * @param ids
	 * @return
	 * @throws DataNotExistException
	 */
	public static List<Long> getIds(String ids) throws DataNotExistException {
		if (Str.isEmpty(ids))
			throw new DataNotExistException();
		String[] sId = ids.split(",");
		List<Long> pId = new ArrayList<Long>();
		for (String id : sId) {
			if (!Str.isNaN(id))
				pId.add(Long.parseLong(id));
		}
		if (pId.size() == 0)
			throw new DataNotExistException();
		return pId;
	}
	

}
