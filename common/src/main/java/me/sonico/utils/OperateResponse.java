package me.sonico.utils;

import java.util.Map;

/**
* <p>Title: OperateResponse</p>
* <p>Description: 操作结果返回类</p>
* <p>Company: 广东今科道同科技股份有限公司</p> 
* @param T 返回data的泛型
* @author   xiangheng.chen
* @date       2016年9月26日
* @version      1.0
 */
public class OperateResponse<T>  {

	/**
	 * 操作结果
	 */
	private ResponseResult result;
	
	public ResponseResult getResult() {
		return result;
	}

	public void setResult(ResponseResult result) {
		this.result = result;
	}

	/**
	 * 操作返回的数据
	 */
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * 操作返回的具体错误信息
	 */
	private Map<String, Object> errorMsg;

	public Map<String, Object> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(Map<String, Object> errorMsg) {
		this.errorMsg = errorMsg;
	}
	
//	@Override
//	public String toString() {
//		return "{\"logId\":"+this.getLogId()+",\"result\":"+this.getResult().name()+"\",\"data\":\""+data+"\",\"errorMsg\":\""+errorMsg+"\"}";
//	} 
}
