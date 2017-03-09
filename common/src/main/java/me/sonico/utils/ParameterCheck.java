package me.sonico.utils;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("unchecked")
public class ParameterCheck {

	/**
	 * 
	 * <p>
	 * Title: isLogId
	 * </p>
	 * <p>
	 * Description:判断是否为logId
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isLogId(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}

		/*
		 * String errorMsg = ""; if(!"".equals(bean.getErrorMsg()) &&
		 * bean.getErrorMsg() != null){ errorMsg = bean.getErrorMsg(); }
		 */
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		Pattern telecomPattern = Pattern.compile(Constant.Number);
		Matcher match = telecomPattern.matcher(bean.getObjValue());
		if (!match.find()) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不为纯数字");
			return map;
		}
		if (String.valueOf(bean.getObjValue()).length() != Constant.ID_LENGTH) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据长度不正确");
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isNo
	 * </p>
	 * <p>
	 * Description:判断是否符合编号层级规范
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isNo(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		String errorMsg = "数据层级规范不正确";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		if ("".equals(bean.getObjValue()))
			return map;
		long length = bean.getObjValue().length();
		if (length % bean.getFixedLength() != 0) {
			map.put(bean.getObjName(), bean.getObjCName() + errorMsg);
		}
		if (bean.getMax() == 0 && bean.getMin() == 0) {
			return map;
		} else {
			if (length > bean.getMax() || length < bean.getMin()) {
				map.put(bean.getObjName(), bean.getObjCName() + "数据范围不正确");
			}
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isLong
	 * </p>
	 * <p>
	 * Description:判断是否为长整形
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isLong(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty
				&& (bean.getObjValue() == null || "".equals(bean.getObjValue()
						.toString().trim()))) {
			return map;
		}
		String errorMsg = "参数长度不符";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		if ("".equals(bean.getObjValue()))
			return map;
		try {
			Long value = Long.parseLong(bean.getObjValue());
			if (bean.getFixedLength() != 0) {
				if (bean.getFixedLength() != bean.getObjValue().length()) {// 参数长度不符
					map.put(bean.getObjName(), bean.getObjCName() + errorMsg);
					return map;
				}
			}
			if (bean.getMax() == 0 && bean.getMin() == 0) {
				return map;
			} else {
				if (value > bean.getMax() || value < bean.getMin()
						|| value > Long.MAX_VALUE || value <= Long.MIN_VALUE) {
					map.put(bean.getObjName(), bean.getObjCName() + "数据范围不正确");
				}
			}
		} catch (NumberFormatException e) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据类型转换失败");
			return map;
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isShort
	 * </p>
	 * <p>
	 * Description:判断是否为短整形
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isShort(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		String errorMsg = "参数长度不符";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		if ("".equals(bean.getObjValue()))
			return map;
		try {
			Short value = Short.parseShort(bean.getObjValue());
			if (bean.getFixedLength() != 0) {
				if (bean.getFixedLength() != bean.getObjValue().length()) {// 参数长度不符
					map.put(bean.getObjName(), bean.getObjCName() + errorMsg);
					return map;
				}
			}
			if (bean.getMax() == 0 && bean.getMin() == 0) {
				return map;
			} else {
				if (value > bean.getMax() || value < bean.getMin()
						|| value > Short.MAX_VALUE || value <= Short.MIN_VALUE) {
					map.put(bean.getObjName(), bean.getObjCName() + "数据范围不正确");
				}
			}
		} catch (NumberFormatException e) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据类型转换失败");
			return map;
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isInteger
	 * </p>
	 * <p>
	 * Description:判断是否为整形
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isInteger(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		String errorMsg = "参数长度不符";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		if ("".equals(bean.getObjValue()))
			return map;
		try {
			Integer value = Integer.parseInt(bean.getObjValue());
			if (bean.getFixedLength() != 0) {
				if (bean.getFixedLength() != bean.getObjValue().length()) {// 参数长度不符
					map.put(bean.getObjName(), bean.getObjCName() + errorMsg);
					return map;
				}
			}
			if (bean.getMax() == 0 && bean.getMin() == 0) {
				return map;
			}
			if (value > bean.getMax() || value < bean.getMin()
					|| value > Integer.MAX_VALUE || value <= Integer.MIN_VALUE) {
				map.put(bean.getObjName(), bean.getObjCName() + "数据范围不正确");
			}
		} catch (NumberFormatException e) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据类型转换失败");
			return map;
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isString
	 * </p>
	 * <p>
	 * Description:判断是否为字符串
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isString(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		String errorMsg = "参数长度不符";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		long length = bean.getObjValue().length();
		if (bean.getFixedLength() != 0) {
			if (bean.getFixedLength() != length) {// 参数长度不符
				map.put(bean.getObjName(), bean.getObjCName() + errorMsg);
				return map;
			}
		}
		if (bean.getMax() == 0 && bean.getMin() == 0) {
			return map;
		} else {
			if (length > bean.getMax() || length < bean.getMin()) {
				map.put(bean.getObjName(), bean.getObjCName() + "数据范围不正确");
			}
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isPhoneNumber
	 * </p>
	 * <p>
	 * Description:判断是否为手机号码
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isPhoneNumber(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		String errorMsg = "参数长度不符";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		Pattern telecomPattern = Pattern
				.compile(Constant.CHINA_TELECOM_PATTERN);
		Matcher match = telecomPattern.matcher(bean.getObjValue());
		if (match.find()) {
			return map;
		} else {
			Pattern mobilePattern = Pattern
					.compile(Constant.CHINA_MOBILE_PATTERN);
			match = mobilePattern.matcher(bean.getObjValue());
			if (match.find()) {
				return map;
			} else {
				Pattern unicomPattern = Pattern
						.compile(Constant.CHINA_UNICOM_PATTERN);
				match = unicomPattern.matcher(bean.getObjValue());
				if (match.find()) {
					return map;
				}
			}
		}
		map.put(bean.getObjName(), "手机号码格式不正确");
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isEmail
	 * </p>
	 * <p>
	 * Description:判断是否为邮箱格式
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isEmail(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		/*
		 * String errorMsg = "参数长度不符"; if(!"".equals(bean.getErrorMsg()) &&
		 * bean.getErrorMsg() != null){ errorMsg = bean.getErrorMsg(); }
		 */
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		long length = bean.getObjValue().length();
		if (bean.getMax() == 0 && bean.getMin() == 0) {
			return map;
		} else {
			if (length > bean.getMax() || length < bean.getMin()) {
				map.put(bean.getObjName(), bean.getObjCName() + "邮箱长度范围不正确");
			}
		}
		Pattern emailPattern = Pattern.compile(Constant.EMAIL_PATTERN);
		Matcher match = emailPattern.matcher(bean.getObjValue());
		if (!match.find()) {
			map.put(bean.getObjName(), "邮箱格式不正确");
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isText
	 * </p>
	 * <p>
	 * Description:判断是否为text
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isText(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		String errorMsg = "参数长度不符";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		if (bean.getFixedLength() != 0) {
			if (bean.getFixedLength() != bean.getObjValue().length()) {// 参数长度不符
				map.put(bean.getObjName(), bean.getObjCName() + errorMsg);
				return map;
			}
		}
		long longText = (long) Integer.MAX_VALUE - (long) Integer.MIN_VALUE;
		if (bean.getObjValue().length() > longText
				|| bean.getObjValue().length() <= 0) {
			map.put(bean.getObjName(), bean.getObjCName() + "字符串长度不正确");
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isDateTime
	 * </p>
	 * <p>
	 * Description:判断是否为时间类型
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isDateTime(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		/*
		 * String errorMsg = ""; if(!"".equals(bean.getErrorMsg()) &&
		 * bean.getErrorMsg() != null){ errorMsg = bean.getErrorMsg(); }
		 */
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		if (bean.getObjValue() == "")
			return map;
		try {
			Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bean
					.getObjValue());
		} catch (ParseException e) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据类型转换失败");
			return map;
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isIdList
	 * </p>
	 * <p>
	 * Description:判断是否为List里面都为Id
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isIdList(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		List<Long> idList = null;
		try {
			Gson gson = new Gson();
			Type type = new TypeToken<List<Long>>() {
			}.getType();
			idList = gson.fromJson(bean.getObjValue(), type);
			if (bean.getObjValue() == null) {
				map.put(bean.getObjName(), bean.getObjCName() + "Id列表为空");
			} else {
				if (idList != null || idList.size() != 0) {
					Pattern numberPattern = Pattern.compile(Constant.Number);
					for (Long id : idList) {
						if (id == null) {
							map.put(bean.getObjName(), "数据存在为空的Id数据");
							return map;
						} else {
							Matcher match = numberPattern.matcher(String.valueOf(id == null ? "" : id));
							if (!match.find()) {
								map.put(bean.getObjName(), "id=" + id + "不为纯数字");
								return map;
							}
						}
						if (String.valueOf(id).length() != Constant.ID_LENGTH) {
							map.put(bean.getObjName(), "id= " + id + "  数据长度不正确");
							return map;
						}
					}
				} else {
					map.put(bean.getObjName(), bean.getObjCName() + "Id列表为空");
				}
			}
		} catch (Exception e) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据类型转换失败");
			return map;
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isStrList
	 * </p>
	 * <p>
	 * Description:判断是否为List里面都为合法字符串
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isStrList(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		String errorMsg = "参数长度不符";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		List<String> strList = null;
		try {
			Gson gson = new Gson();
			Type type = new TypeToken<List<String>>() {
			}.getType();
			strList = gson.fromJson(bean.getObjValue(), type);
			if (strList == null || strList.size() == 0) {
				map.put(bean.getObjName(), bean.getObjCName() + "列表为空");
			} else {
				for (String str : strList) {
					if (bean.getFixedLength() != 0) {
						if (bean.getFixedLength() != str.length()) {// 参数长度不符
							map.put(bean.getObjName(), bean.getObjCName()
									+ "str=" + str + errorMsg);
						}
					}
					if (!(bean.getMax() == 0 && bean.getMin() == 0)) {
						if (str.length() > bean.getMax()
								|| str.length() < bean.getMin()) {
							map.put(bean.getObjName(), bean.getObjCName()
									+ "str=" + str + "数据长度不正确");
						}
					}
				}
			}
		} catch (Exception e) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据类型转换失败");
			return map;
		}
		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isIntList
	 * </p>
	 * <p>
	 * Description:判断是否为List里面都为合法数字
	 * </p>
	 * 
	 * @param FieldBean
	 *            字段检测集合
	 * @return 错误信息集合
	 */
	public static HashMap<String, Object> isIntList(FieldBean bean) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (bean.canEmpty && bean.getObjValue() == null) {
			return map;
		}
		if (bean.getObjValue() == null) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据不存在");
			return map;
		}
		String errorMsg = "参数长度不符";
		if (!"".equals(bean.getErrorMsg()) && bean.getErrorMsg() != null) {
			errorMsg = bean.getErrorMsg();
		}
		List<Integer> intList = null;
		try {
			Gson gson = new Gson();
			Type type = new TypeToken<List<Integer>>() {
			}.getType();
			intList = gson.fromJson(bean.getObjValue(), type);
			if (intList == null || intList.size() == 0) {
				map.put(bean.getObjName(), bean.getObjCName() + "列表为空");
			} else {
				for (Integer inte : intList) {
					try {
						// Integer value = Integer.parseInt(inte);
						if (bean.getFixedLength() != 0) {
							if (bean.getFixedLength() != bean.getObjValue()
									.length()) {// 参数长度不符
								map.put(bean.getObjName(), bean.getObjCName()
										+ errorMsg);
								return map;
							}
						}
						if (!(bean.getMax() == 0 && bean.getMin() == 0)) {
							if (inte > bean.getMax() || inte < bean.getMin()
									|| inte > Integer.MAX_VALUE
									|| inte <= Integer.MIN_VALUE) {
								map.put(bean.getObjName(), bean.getObjCName()
										+ "inte=" + inte + "数据范围不正确");
							}
						}
					} catch (NumberFormatException e) {
						map.put(bean.getObjName(), bean.getObjCName() + "inte="
								+ "数据类型转换失败");
						return map;
					}
				}
			}
		} catch (Exception e) {
			map.put(bean.getObjName(), bean.getObjCName() + "数据类型转换失败");
			return map;
		}
		return map;
	}

}
