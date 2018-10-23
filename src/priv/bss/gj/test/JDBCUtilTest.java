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
		int update = msDao.update("ATTR_VALUE","LOG_ID","INF_MKT_RES_DEAL_DEAL_ID");
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
}
