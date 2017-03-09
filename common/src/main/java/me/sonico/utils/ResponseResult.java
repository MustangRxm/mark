package me.sonico.utils;

/**
 * 
* <p>Title: ResponseResult</p>
* <p>Description: 操作结果返回类型</p>
* <p>Company: 广东今科道同科技股份有限公司</p> 
* 操作结果--成功  SUCCESS(1000)
* <br>操作失败，数据参数错误  PARAMETERERROR(2000)
* <br>操作失败，数据库操作错误  DATABASEERROR(3000)
* <br>操作失败，网络错误  NETWORKERROR(4000)
* <br>操作失败，其他错误  OTHERERROR(5000)
* @author   xiangheng.chen
* @date       2016年9月26日
* @version      1.0
 */
public enum ResponseResult {

	/**
	 * 操作结果--成功
	 */
	SUCCESS(1000),
	
	/**
	 * 账号存在--
	 */
	ACCOUNTEXIST(1101),
	
	/**
	 * 账号不存在--
	 */
	ACCOUNTNOTEXIST(1102),
	
	/**
	 * 数据不存在
	 */
	DATA_NO_EXIST(1103),
	/**
	 * 操作失败，数据参数错误
	 */
	PARAMETERERROR(2000),
	
	/**
	 * 账号或密码错误--
	 */
	LOGINERROR(2101),
	
	/**
	 * 账号已被冻结--
	 */
	ACCOUNTFROZEN(2102),
	
	/**
	 * 邮箱未被激活--
	 */
	NOTACTIVE(2103),
	
	/**
	 * 操作失败，数据库操作错误
	 */
	DATABASEERROR(3000),
	
	/**
	 * 操作失败，网络错误
	 */
	NETWORKERROR(4000),
	
	/**
	 * 操作失败，其他错误
	 */
	OTHERERROR(5000);
	
	private int value;
	
	private ResponseResult(int value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}
