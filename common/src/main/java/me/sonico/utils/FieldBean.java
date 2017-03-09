package me.sonico.utils;

public class FieldBean {

	public String objName;
	public String objCName;
	public String objValue;
	public int type;
	public long fixedLength;
	public long min;
	public long max;
	public String errorMsg;
	public boolean canEmpty;
	
	/**
	 * 
	 * <p>Title: FieldBean</p>
	 * <p>Description: 字段检测参数</p>
	 * @param objName 字段名
	 * @param objCNName 字段名称
	 * @param objValue 字段值
	 * @param type 字段类型
	 * @param fixedLength 层级规范长度
	 * @param min 字段值最小值
	 * @param max 字段值最大值
	 * @param errorMsg 数据类型不符报错信息
	 * @param canEmpty 非必填
	 */
	public FieldBean(String objName,String objCName,String objValue,int type,long fixedLength,long min,long max,String errorMsg,boolean canEmpty) {
		this.objName = objName;
		this.objCName = objCName;
		this.objValue = objValue;
		this.type = type;
		this.fixedLength = fixedLength;
		this.min = min;
		this.max = max;
		this.errorMsg = errorMsg;
		this.canEmpty = canEmpty;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getObjCName() {
		return objCName;
	}

	public void setObjCName(String objCName) {
		this.objCName = objCName;
	}

	public String getObjValue() {
		return objValue;
	}

	public void setObjValue(String objValue) {
		this.objValue = objValue;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getFixedLength() {
		return fixedLength;
	}

	public void setFixedLength(long fixedLength) {
		this.fixedLength = fixedLength;
	}

	public long getMin() {
		return min;
	}

	public void setMin(long min) {
		this.min = min;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isCanEmpty() {
		return canEmpty;
	}

	public void setCanEmpty(boolean canEmpty) {
		this.canEmpty = canEmpty;
	}
	
}
