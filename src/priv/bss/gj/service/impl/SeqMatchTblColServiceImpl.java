package priv.bss.gj.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import priv.bss.gj.dao.SeqMatchTblColDao;
import priv.bss.gj.dao.impl.SeqMatchTblColDaoImpl;
import priv.bss.gj.entity.SeqMatchTblCol;
import priv.bss.gj.service.SeqMatchTblColService;

/**
 * @author wang.miansen
 * 2018年10月23日
 * 下午4:17:31
 * TODO
 */
public class SeqMatchTblColServiceImpl implements SeqMatchTblColService{
	
	private static Logger logger = Logger.getLogger(SeqMatchTblColServiceImpl.class);

	/**
	 * 根据序列名匹配表和字段
	 */
	@Override
	public void match() {
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		List<SeqMatchTblCol> findAll = msDao.findAll();
		String matchCol = null;
		for(int i = 0;i < findAll.size();i++){
			SeqMatchTblCol msmt = findAll.get(i);
			//开始匹配表名
			String matchTbl = matchTbl(msmt);
			//如果表名不为空并且长度小于序列的长度，则开始匹配字段。
			if(matchTbl != null && matchTbl.length() < msmt.getSeqName().length()){
				msmt.setTableName(matchTbl);
				matchCol = matchCol(msmt);
			}
			if(matchTbl == null){
				logger.debug("结果:匹配失败,序列:SEQ_"+msmt.getSeqName()+" 未匹配到与之对应的表名");
				logger.debug("------------------------------------------------------------------");
			}else{
				//表名不为空则更新配置表
				msDao.update(matchTbl, matchCol, msmt.getSeqName());
				logger.debug("结果:匹配成功,序列:SEQ_"+msmt.getSeqName()+",表名:"+matchTbl+",字段:"+matchCol+",用户:"+msmt.getOwner()+"");
				logger.debug("------------------------------------------------------------------");
			}
		}
	}

	/**
	 * 匹配表名
	 * @param msDao:查询接口
	 * @param sb:拼接字符串
	 * @param countTbl:是否匹配到了
	 * @param msmt:实体信息
	 * @return
	 */
	private String matchTbl(SeqMatchTblCol msmt) {
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		StringBuffer sb = new StringBuffer();
		String[] split = msmt.getSeqName().split("_");
		logger.debug("开始执行,序列名:SEQ_"+msmt.getSeqName());
		logger.debug("*********开始匹配表名*********");
		for(int i = 0;i < split.length;i++){
			if(i == 0){
				sb.append(split[i]);
			}else{
				sb.append("_");
				sb.append(split[i]);
			}
			logger.debug("当前匹配表名:"+sb);
			int countTbl = msDao.countTbl(msmt.getOwner(), sb.toString());
			if(countTbl > 0){
				logger.debug("表名匹配成功");
				return sb.toString();
			}
		}
		return null;
	}

	/**
	 * 匹配字段
	 * @param owner:用户名
	 * @param tableName:表名
	 * @param seqName:序列名
	 * @return
	 */
	private String matchCol(SeqMatchTblCol msmt) {
		logger.debug("*********开始匹配字段*********");
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		StringBuffer sb = new StringBuffer();
		String sbt = msmt.getSeqName().substring(msmt.getTableName().length()+1);
		String[] split = sbt.split("_");
		for(int i = 0;i < split.length;i++){
			if(i == 0){
				sb.append(split[i]);
			}else{
				sb.append("_");
				sb.append(split[i]);
			}
			logger.debug("当前匹配字段:"+sb);
			int countCol = msDao.countCol(msmt.getOwner(), msmt.getTableName(), sb.toString());
			if(countCol > 0){
				logger.debug("字段匹配成功");
				return sb.toString();
			}
		}
		logger.debug("字段匹配失败");
		return null;
	}
}
