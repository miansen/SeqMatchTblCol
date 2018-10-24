package priv.bss.gj.test;

import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import priv.bss.gj.dao.SeqMatchTblColDao;
import priv.bss.gj.dao.impl.SeqMatchTblColDaoImpl;
import priv.bss.gj.entity.SeqMatchTblCol;
import priv.bss.gj.service.SeqMatchTblColService;
import priv.bss.gj.service.impl.SeqMatchTblColServiceImpl;

/**
 * 测试代码
 * @author wang.miansen
 * 2018年10月23日
 * 下午9:24:08
 * TODO
 */
public class JDBCUtilTest {
	
	private static Logger logger = Logger.getLogger(JDBCUtilTest.class);
	
	@Test
	public void findAllTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		List<SeqMatchTblCol> findAll = msDao.findAll();
		//System.out.println(findAll);
		logger.debug(findAll);
		logger.debug(findAll.size());
	}
	
	@Test
	public void countTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		int count = msDao.countTbl("JK", "ATTR_VALUE");
		System.out.println(count);
	}
	
	/**
	 * 更新配置表
	 * @throws Exception
	 */
	@Test
	public void updateTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		//int update = msDao.update("ATTR_VALUE","LOG_ID","INF_MKT_RES_DEAL_DEAL_ID");
		SeqMatchTblCol smtl = new SeqMatchTblCol();
		smtl.setOwner("MARKING");
		smtl.setTableName("CONTACT_CHL_ATTR");
		smtl.setColumnName("INST_ID");
		smtl.setColumnLength(22);
		smtl.setExists(true);
		smtl.setRemark("默认主键");
		smtl.setSeqName("CONTACT_CHL_ATTR_INST");
		int update = msDao.update(smtl);
		System.out.println(update);
	}
	
	@Test
	public void stringBufferTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		String str = "BILL_CHARGE_DETAIL_INF_MKT_RES_DEAL_DEAL_ID";
		String[] split = str.split("_");
		StringBuffer sb = new StringBuffer();
		int count = 0;
		logger.debug("开始执行,序列名:SEQ_"+str);
		for(int i = 0;i< split.length;i++){
			if(i == 0){
				sb.append(split[i]);
			}else {
				sb.append("_");
				sb.append(split[i]);
			}
			logger.debug("当前匹配:"+sb);
			count = msDao.countTbl("JK", sb.toString());
			if(count > 0){
				logger.debug("结果:"+count+"(匹配成功),表名:"+sb+",用户:JK");
				return;
			}
		}
		logger.debug("未找到与之对应的表名");
	}
	
	/**
	 * 匹配表名和字段
	 * @throws Exception
	 */
	@Test
	public void serviceMatchTest() throws Exception{
		SeqMatchTblColService msSeqMatchTblService = new SeqMatchTblColServiceImpl();
		msSeqMatchTblService.match();
	}
	
	/**
	 * 判断字段是否存在
	 * @throws Exception
	 */
	@Test
	public void countColTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		int count = msDao.countCol("JK", "INF_OFFER_SMS", "ID");
		logger.debug(count);
	}
	
	@Test
	public void substringTest() throws Exception{
		String tableName = "CEPEX_SOO_ORDER_EXT";
		String str = "CEPEX_SOO_ORDER_EXT_LOG_ID";
		String substring = str.substring(tableName.length()+1);
		logger.debug(substring);
	}
	
	/*@Test
	public void matchColTest() throws Exception{
		SeqMatchTblColService msSeqMatchTblService = new SeqMatchTblColServiceImpl();
		String matchCol = msSeqMatchTblService.matchCol("JK", "CEPEX_SOO_ORDER_EXT", "CEPEX_SOO_ORDER_EXT_LOG_ID");
		logger.debug(matchCol);
	}*/
	
	/**
	 * 查询表的主键
	 * @throws Exception
	 */
	@Test
	public void selectPrimaryKeyTest() throws Exception {
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		String selectPrimaryKey = msDao.selectPrimaryKey("MARKING","EVENT");
		logger.debug(selectPrimaryKey);
	}
	
	@Test
	public void test01() throws Exception {
		String seq = "EVENT_MATCH_RUL";
		String matchTbl = "EVENT";
		String matchCol = "aaa_id";
		String primaryKey = "EVENT_ID";
		String owner = "MARKING";
		String a = matchCol != null ? matchCol : primaryKey;
		logger.debug("结果:匹配成功,序列:"+seq+",表名:"+matchTbl+",字段:"+(matchCol != null ? matchCol : primaryKey)+",用户:"+owner+"");
		System.out.println("字段:"+a);
	}
	
	/**
	 * 查询字段的长度
	 * @throws Exception
	 */
	@Test
	public void selectColumnLengthTest() throws Exception {
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		int selectColumnLength = msDao.selectColumnLength("MARKING", "MKT_QST_QUEST_DETAIL_REL", "REL_CONF_ID");
		logger.debug(selectColumnLength);
	}
}
