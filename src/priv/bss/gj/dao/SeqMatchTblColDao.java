package priv.bss.gj.dao;

import java.util.List;

import priv.bss.gj.entity.SeqMatchTblCol;

/**
 * @author wang.miansen
 * 2018年10月23日
 * 下午4:16:56
 * TODO
 */
public interface SeqMatchTblColDao {
	
	/**
	 * 查询配置表
	 * @return
	 */
	List<SeqMatchTblCol> findAll();
	
	/**
	 * 判断表是否存在
	 * @param owner:用户名
	 * @param tableName:表名
	 * @return
	 */
	int countTbl(String owner,String tableName);
	
	/**
	 * 判断字段是否存在
	 * @param owner:用户名
	 * @param tableName:表名
	 * @param columnName:字段名
	 * @return
	 */
	int countCol(String owner,String tableName,String columnName);
	
	/**
	 * 更新配置表
	 * @param smtl
	 * @return
	 */
	int update(SeqMatchTblCol smtl);
	
	/**
	 * 查询表的主键
	 * @param owner:用户
	 * @param tableName:表名
	 * @return
	 */
	String selectPrimaryKey(String owner,String tableName);
	
	/**
	 * 查询字段的长度
	 * @param owner
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	int selectColumnLength(String owner,String tableName,String columnName);
}
