package com.core.exception;


/**
 * 查询的数据不存在异常
 * 
 * @author Dylin
 * 
 */
public class DataNotExistException extends OperationException {

	private static final long serialVersionUID = 1L;

	/**
	 * 查询的数据不存在异常
	 * 
	 * @param msg
	 */
	/*public DataNotExistException(String message) {
		super(G.getMsg(message));
	}

	public DataNotExistException() {
		super(G.getMsg("sys.data.noexist"));
	}
	
	public DataNotExistException(Long id) {
		super(G.getMsg("sys.data.noexit") + ":" + id);
	}
	*/

	public DataNotExistException(String message) {
		super("");
	}

	public DataNotExistException() {
		super("");
	}

	public DataNotExistException(Long id) {
		super("sys.data.noexit"+ ":" + id);
	}
}
