package me.sonico.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VarifyUtils {
	/**
	 * 短整形
	 **/
	public final static int Short = 1;
	/**
	 * 整形
	 **/
	public final static int Integer = 2;
	/**
	 * 长整形
	 **/
	public final static int Long = 3;
	/**
	 * 字符串
	 **/
	public final static int String = 4;
	/**
	 * 规定约束Id
	 **/
	public final static int LogId = 5;
	/**
	 * 编号
	 **/
	public final static int Number = 6;
	/**
	 * 手机号码
	 **/
	public final static int PhoneNumber = 7;
	/**
	 * 邮箱
	 **/
	public final static int Email = 8;
	/**
	 * 文本
	 **/
	public final static int Text = 9;
	/**
	 * 时间
	 **/
	public final static int DateTime = 10;
	/**
	 * IdList
	 */
	public final static int IdList=11;
	/**
	 * StrList
	 */
	public final static int StrList=12;
	/**
	 * IntList
	 */
	public final static int IntList=13;

	public VarifyUtils(){

	}

	/**
	 * <p>Title: checkData</p>
	 * <p>Description: 检测会员表单数据是否正确</p>
	 * @param json 会员表单数据
	 * @param list 检索格式-List
	 * @return OperateResponse
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static OperateResponse checkData(String json,List list,Log log) {
		log.i("Beagin To Excute The checkData", json, false);
		OperateResponse response = new OperateResponse();
		Map<String, Object> map = JsonUtil.getMapFromJson(json);
		list = setfieldBeanList(list,map);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.putAll(checkDataisLegal(list));//规范格式长度必填检索
		if (resultMap.isEmpty()) {
			response.setResult(ResponseResult.SUCCESS);
			log.i("检查数据 通过 end", response.toString(), false);
		} else {
			response.setResult(ResponseResult.PARAMETERERROR);
			response.setErrorMsg(resultMap);
			log.e("检查数据 不通过 end", response.toString(), false);
			log.i("End To Excute The checkData", json, true);
		}
		log.i("End To Excute The checkData", json, true);
		return response;
	}


	/**
	 * <p>Title: checkSpecialData</p>
	 * <p>Description: 单个字段检测参数</p>
	 * @param objName 字段名
	 * @param objValue 字段值
	 * @param type 字段类型
	 * @param fixedLength 层级规范长度
	 * @param min 字段值最小值
	 * @param max 字段值最大值
	 * @param errorMsg 数据类型不符报错信息
	 * @param canEmpty 非必填
	 * @return OperateResponse
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static OperateResponse checkSpecialData(String objName,String objCName,String objValue,int type,long fixedLength,long min,long max,String errorMsg,boolean canEmpty,Log log) {
		log.i("Beagin To Excute The checkData", objName, true);
		OperateResponse response = new OperateResponse();
		List list = new ArrayList<FieldBean>();
		FieldBean bean = new FieldBean(objName,objCName,objValue,type,fixedLength,min,max,errorMsg,canEmpty);
		list.add(bean);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.putAll(checkDataisLegal(list));//规范格式长度检索
		if (resultMap.isEmpty()) {
			response.setResult(ResponseResult.SUCCESS);
			log.i("检查" + objCName + "的数据 通过 end", response.toString(), true);
		} else {
			response.setResult(ResponseResult.PARAMETERERROR);
			response.setErrorMsg(resultMap);
			log.e("检查" + objCName + "的数据 不通过 end", response.toString(), false);
			log.i("End To Excute The checkData", objName, true);
		}
		log.i("End To Excute The checkData", objName, true);
		return response;
	}

	/**
	 *
	 * <p>Title: checkDataEmpty</p>
	 * <p>Description: 检索表单数据是是否必填</p>
	 * @param list 表单字段汇总
	 * @return Map
	 */
	public Map<String, Object> checkDataEmpty(List<FieldBean> list){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).canEmpty){//不为空检索
					if(list.get(i).getObjValue() == null || "".equals(list.get(i).getObjValue())){
						Map<String,Object>  singMap= new HashMap<String, Object>();
						singMap.put(list.get(i).getObjName(), list.get(i).getObjCName() + "数据不存在");
						resultMap.putAll(singMap);
					}
				}
			}
		return resultMap;
	}

	/**
	 *
	 * <p>Title: checkDataisLegal</p>
	 * <p>Description: 检索表单数据是是否必填、格式是否正确、长度是否合法</p>
	 * @param list 表单字段汇总
	 * @return Map
	 */
	public static Map<String, Object> checkDataisLegal(List<FieldBean> list){
		HashMap<String,Object> map = new HashMap<String, Object>();
		for (int i = 0; i < list.size(); i++) {
			FieldBean bean = list.get(i);
				switch (bean.getType()) {
				case Short:
					map.putAll(ParameterCheck.isShort(bean));
					break;
				case Integer:
					map.putAll(ParameterCheck.isInteger(bean));
					break;
				case Long:
					map.putAll(ParameterCheck.isLong(bean));
					break;
				case String:
					map.putAll(ParameterCheck.isString(bean));
					break;
				case LogId:
					map.putAll(ParameterCheck.isLogId(bean));
					break;
				case Number:
					map.putAll(ParameterCheck.isNo(bean));
					break;
				case PhoneNumber:
					map.putAll(ParameterCheck.isPhoneNumber(bean));
					break;
				case Email:
					map.putAll(ParameterCheck.isEmail(bean));
					break;
				case Text:
					map.putAll(ParameterCheck.isText(bean));
					break;
				case DateTime:
					map.putAll(ParameterCheck.isDateTime(bean));
					break;
				case IdList:
					map.putAll(ParameterCheck.isIdList(bean));
					break;
				case StrList:
					map.putAll(ParameterCheck.isStrList(bean));
					break;
				case IntList:
					map.putAll(ParameterCheck.isIntList(bean));
					break;
				default:
					break;
				}
		}
		return map;
	}

	/**
	 *
	 * <p>Title: setfieldBeanList</p>
	 * <p>Description: 表单赋值汇总检索元素</p>
	 * @param fieldList 表单检索元素
	 * @param map 传入字段值
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public static List setfieldBeanList(List<FieldBean> fieldList,Map<String, Object> map){
		for (int i = 0; i < fieldList.size(); i++) {
			//System.out.print(key);
			for (String key : map.keySet()) {
				if(key.equals(fieldList.get(i).objName)){
					fieldList.get(i).objValue = map.get(key) == null ? null:(map.get(key).toString()).trim();
				}
			}
		}
		return fieldList;
	}

	/**
	 *
	 * <p>Title: setCanEmptyBoolean</p>
	 * <p>Description: 将0(必填),1(非必填)状态转化false(必填),true(非必填)形式</p>
	 * @param boolStr 可为空0、1 格式可为: 0 | 0,1 | 0,1,1 | 0,0,1,
	 * @return boolean[]
	 */
	public static boolean[] setCanEmptyBoolean(String boolStr){
		String[] list = boolStr.split(",");
		boolean[] booList = null;
		if(list.length == 0)
			return booList;

		booList = new boolean[list.length];
		for (int i = 0; i < list.length; i++) {
			if("1".equals(list[i])){//非必填情况
				booList[i] = true;
			}else{
				booList[i] = false;
			}
		}
		return booList;
	}

	/**
	 * keys里面是调用者所可能接收的字段,map为实际json传入的key-value,
	 * 依据map中，是否存在keys中的字段，来填写0,1
	 */
	public static String obtainCanEmptyString(Map<String, Object> map, String[] keys) {
		int size = keys.length;
		StringBuilder sb = new StringBuilder();
		if (map.isEmpty()) {
			for(int i = 0; i < size; i++) {
				if (i == size - 1) {
					sb.append("1");
				} else {
					sb.append("1,");
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (i == size - 1) {
					if(map.containsKey(keys[i]) && map.get(keys[i]) != null) {

						sb.append("0");
					} else {
						sb.append("1");
					}
				} else {
					if(map.get(keys[i])!=null && map.containsKey(keys[i])) {
						sb.append("0,");
					} else {
						sb.append("1,");
					}
				}

			}
		}
		return sb.toString();
	}

	public static String obtainKeySet( String[] keys){
		int size = keys.length;
		StringBuilder sb = new StringBuilder();

			for (int i = 0; i < size; i++) {
				if (i == size - 1) {
					sb.append(keys[i]);
				} else {
					sb.append(keys[i]+",");
				}
		}
		return sb.toString();
	}

}
