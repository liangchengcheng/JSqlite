package mddemo.library.com.db;

import java.util.List;

@SuppressWarnings("rawtypes")
public class SqlSet {

	/** 唯一标示. */
	private String id;

	/** sql类型. */
	private String type;

	/** sql语句. */
	private String sql;

	/** 参数列表. */
	private List<String> parameterNames;

	/** 替换值列表*/
	private List<String> attributeNames;
	/** 参数类型. */
	private Class parameterType;

	/** 返回结果类型. */
	private Class resultType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Class getParameterType() {
		return parameterType;
	}

	public void setParameterType(Class parameterType) {
		this.parameterType = parameterType;
	}

	public Class getResultType() {
		return resultType;
	}

	public void setResultType(Class resultType) {
		this.resultType = resultType;
	}

	public List<String> getParameterNames() {
		return parameterNames;
	}

	public void setParameterNames(List<String> parameterNames) {
		this.parameterNames = parameterNames;
	}

	public List<String> getAttributeNames() {
		return attributeNames;
	}

	public void setAttributeNames(List<String> attributeNames) {
		this.attributeNames = attributeNames;
	}

}