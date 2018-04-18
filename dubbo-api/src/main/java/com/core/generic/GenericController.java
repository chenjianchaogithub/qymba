package com.core.generic;

import com.core.exception.DataNotExistException;
import com.util.ParamMap;
import com.util.Str;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.converter.json.MappingJacksonValue;


/**
 * 控制器的基础类，要求所有Controller都继承这个类。实现了控制层所需的一些公共方法
 * 
 */
public abstract class GenericController {

	private static Logger logger = LoggerFactory.getLogger(GenericController.class);
	
	/**
	 * 返回带View规范的json对象
	 * 本方法基于spring mvc4支持的@jsonView方法上使用的，因为MappingJackson2HttpMessageConverter中
	 * MappingJacksonValue是从一个Map或List开始进行序列化的，所以传入的对象必须是一个Map或者List
	 * 
	 * @param object 必须是一个Map或List对象
	 * @param clazz
	 * @return
	 */
	protected Object jsonView(Object object, Class<?> clazz) {
		MappingJacksonValue mapJsonVal = new MappingJacksonValue(object);
		mapJsonVal.setSerializationView(clazz);
		return mapJsonVal;
	}
	
	/**
	 * 格式化日期格式
	 * 
	 * @param binder
	 */
	/*@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormat, true));
	}*/

	/**
	 * 统一的异常处理方法
	 * 
	 * @param request
	 * @param response
	 * @param e
	 * @return
	 */
	/*@ExceptionHandler
	protected String exception(HttpServletRequest request,
			HttpServletResponse response, Exception e) {

		if (!(e instanceof LicenseException || 
				e instanceof ParamerException || 
				e instanceof OperationException)) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		}

		if (isAjax(request)) {
			ParamMap data = new ParamMap();
			data.put("err", e.getMessage());
			data.put("error", e.getMessage());
			// 如果是JSON格式的AJAX请求
			response.setStatus(200);
			response.setContentType("application/json;charset=utf-8");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			try {
				response.getWriter().print(JSONObject.fromObject(data));
				response.getWriter().flush();
				response.getWriter().close();
			} catch (java.io.IOException e1) {
				log.error(e1.getMessage(), e1);
			}
			return null;
		} else {
			// 如果是普通请求
			request.setAttribute("error", e.getMessage());
			System.err.println("Error License:" + e.getMessage());

			if (e instanceof LicenseException) {
				request.setAttribute("macCode", ((LicenseException) e).macode());
				request.setAttribute("appName", G.AppName);
				return "verify";
			} else {
				return "error";
			}
		}
	}*/

	/**
	 * 验证
	 * 
	 * @return
	 * @throws UnsatisfiedLinkError
	 * @throws LicenseException
	 */
/*	@ModelAttribute
	protected boolean veriy(HttpServletRequest request)
			throws LicenseException {
		if (G.SAVE_VERIFY_PATH.equals(request.getServletPath()))
			return true;
		return Verify.init().check();
	}*/

	/**
	 * 当前用户
	 * 
	 * @return
	 */
	/*protected User currUser() {
		return Online.currUser();
	}

	protected Long currUserId() {
		return Online.currUserId();
	}*/

	/**
	 * 获取Ip地址
	 * 
	 * @param request
	 * @return
	 */
	protected String getIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

	/**
	 * 判断是否是AJAX方式请求
	 * 
	 * @return
	 */
	protected boolean isAjax(HttpServletRequest request) {
		return (request.getHeader("accept").indexOf("application/json") > -1
				|| (request.getHeader("X-Requested-With") != null
						&& request.getHeader("X-Requested-With")
								.indexOf("XMLHttpRequest") > -1));
	}

	/**
	 * 获取cookie值
	 * 
	 * @param key
	 * @return
	 */
	protected String cookie(HttpServletRequest request, String key) {
		if (request.getCookies() == null)
			return "";
		for (Cookie cookie : request.getCookies()) {
			if (key.equals(cookie.getName())) {
				try {
					return URLDecoder.decode(cookie.getValue(), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					return cookie.getValue();
				}
			}
		}
		return "";
	}

	/**
	 * 设置coolie, 默认15天有效
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	protected void cookie(HttpServletResponse response, String key,
			String value) {
		cookie(response, key, value, 15);
	}

	/**
	 * 设置coolie
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @param date
	 *            有效天数
	 */
	protected void cookie(HttpServletResponse response, String key,
			String value, int date) {
		if (key != null && value != null) {
			Cookie cookie;
			try {
				cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				cookie = new Cookie(key, value);
			}
			cookie.setPath("/");
			cookie.setMaxAge(date * 24 * 60 * 60);
			response.addCookie(cookie);
		}
	}

	/**
	 * 移除cookie
	 * 
	 * @param key
	 */
	protected void removeCookie(HttpServletResponse response, String key) {
		if (key != null) {
			Cookie cookie = new Cookie(key, null);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}

	/**
	 * 接管参数集 默认前缀为p
	 * 
	 * @param request
	 * @return
	 */
	protected ParamMap getParamMap(HttpServletRequest request) {
		return getParamMap(request, "");
	}

	/**
	 * 接管包含分页信息的参数集，默认前缀为p
	 * 
	 * @param request
	 * @return
	 */
	@Deprecated
	protected ParamMap getPageParamMap(HttpServletRequest request) {
		ParamMap param = getParamMap(request);
		// 如果有分页信息的 对分页信息进行计算
		if (param.isEmpty("currentPage"))
			param.put("currentPage", 1); // 当前页
		int currentPage = Integer.parseInt(param.get("currentPage").toString());
		if (param.isEmpty("pageSize"))
			param.put("pageSize", 20); // 每页条数
		int pageSize = Integer.parseInt(param.get("pageSize").toString());
		param.put("startCount", ((currentPage - 1) * pageSize));
		return param;
	}

	/**
	 * 接管参数集
	 * 
	 * @param request
	 * @param perfix
	 * @return
	 */
	protected ParamMap getParamMap(HttpServletRequest request, String prefix) {
		ParamMap param = new ParamMap();
		Map<String, String[]> map = request.getParameterMap();
		String[] vals;
		String pKey;
		if (map == null) return param;
		for (String key : map.keySet()) {
			if (Str.isEmpty(prefix) || key.startsWith(prefix + ".")) {
				vals = map.get(key);
				pKey = key.replace(prefix + ".", "");
				if (vals.length == 1) {
					if (Str.isEmpty(vals[0])) continue;
					else param.put(pKey, vals[0].trim());
				} else param.put(pKey, vals);
			}
		}
		return param;
	}

	/**
	 * 获取ID列表
	 * 
	 * @param request
	 * @param paramName
	 * @return
	 * @throws DataNotExistException
	 */
	protected List<Long> getIds(HttpServletRequest request, String paramName)
			throws DataNotExistException {
		return Str.getIds(request.getParameter(paramName));
	}

	/**
	 * 获取ID列表
	 *
	 * @return
	 * @throws DataNotExistException
	 */
	protected List<Long> getIds(String ids) throws DataNotExistException {
		if (ids == null)
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

	/**
	 * 不存在信息
	 * 
	 */
	protected Map<String, Object> noExist() {
		Map<String, Object> data = new WeakHashMap<String, Object>();
		//data.put("err", G.getMsg("sys.data.noexist"));
		data.put("err", "");
		return data;
	}

	/**
	 * 输出JSON错误信息
	 * 
	 * @param data
	 * @param obj
	 * @return
	 */
	protected Map<String, Object> error(Map<String, Object> data, Object obj) {
		if (null == data)
			data = new WeakHashMap<String, Object>();
		data.put("err", obj);
		return data;
	}

	/**
	 * 输出JSON错误信息
	 * 
	 * @param result
	 * @return
	 */
	/*protected Map<String, Object> error(BindingResult result) {
		List<FieldError> rs = result.getFieldErrors();
		List<String> rsList = new ArrayList<String>();
		for (FieldError iRs : rs) {
			rsList.add(iRs.getDefaultMessage());
		}
		return error(null, rsList);
	}*/

	/*protected String errorInfo(BindingResult result) {
		List<FieldError> rs = result.getFieldErrors();
		StringBuffer info = new StringBuffer();
		for (FieldError iRs : rs) {
			info.append(iRs.getDefaultMessage());
		}
		return info.toString();
	}*/

	/**
	 * 输出JSON错误信息
	 * 
	 * @param data
	 * @return
	 */
	/*protected Map<String, Object> error(Map<String, Object> data) {
		return error(data, G.getMsg("sys.error"));
	}*/

	/**
	 * 输出JSON错误信息
	 * 
	 * @return
	 */
	/*protected Map<String, Object> error() {
		return error(null, G.getMsg("sys.error"));
	}*/

	/**
	 * 输出JSON错误信息
	 * 
	 * @param msg
	 * @return
	 */
	/*protected Map<String, Object> error(String msg) {
		String key;
		Matcher m = Pattern.compile("(\\{[^\\}]+})").matcher(msg);
		while (m.find()) {
			key = m.group(1);
			msg = msg.replace(key,
					G.getMsg(key.replace("{", "").replace("}", "")));
		}
		return error(null, msg);
	}*/

	/**
	 * 操作成功信息
	 * 
	 * @param data
	 * @param msg
	 * @return
	 */
	protected Map<String, Object> success(Map<String, Object> data,String msg) {
		if (null == data)
			data = new WeakHashMap<String, Object>();
		data.put("msg", msg);
		return data;
	}

	/**
	 * 操作成功信息
	 * 
	 * @return
	 */
	/*protected Map<String, Object> success() {
		return success(null);
	}*/

	/**
	 * 操作成功信息
	 * 
	 * @param data
	 * @return
	 */
	/*protected Map<String, Object> success(Map<String, Object> data) {
		return success( data , G.getMsg("sys.success") );
	}*/
	
	/**
	 * 操作成功信息
	 * @param key 添加的关键字
	 * @param obj 添加的信息内容
	 * @return
	 */
	/*protected Map<String, Object> success(String key, Object obj) {
		Map<String, Object> rs = new WeakHashMap<String, Object>();
		rs.put(key, obj);
		return success(rs);
	}*/

	/**
	 * 返回数据集
	 * 
	 * @param rowsData
	 * @return
	 */
	protected Map<String, Object> rows(Object rowsData) {
		Map<String, Object> data = new WeakHashMap<String, Object>();
		data.put("rows", rowsData);
		return data;
	}

}
