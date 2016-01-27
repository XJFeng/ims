package cn.com.lianbi.ims.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lianbi.framework.dao.HibernateDao;
import cn.com.lianbi.framework.dao.Page;

/**
 * @since 2016年1月15日 下午2:32:49
 * @author xjh
 */
@Service
public class CommonService {

	@Autowired
	private HibernateDao hibernateDao;

	public List<Map> findListBySql(String sqlString, Map<String, Object> paramMap, Page page) {
		return hibernateDao.findListBySql(sqlString, null, null);
	}

	public int getCountNum(String sqlString, Map<String, Object> paramMap) {

		String countSql = "select count(*) as totalResult from ( " + sqlString + " ) as results";
		int totalResult = Integer.parseInt(hibernateDao.findUniqueResultBySql(countSql, paramMap).toString());

		return totalResult;
	}

}
