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
	 * 查询所有的序列
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
	 * @param tableName:表名
	 * @param seqName:序列名
	 * @return
	 */
	int update(String tableName,String columnName,String seqName);
}
