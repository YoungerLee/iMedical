package com.young.iMedical.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.young.iMedical.dao.CommonDao;
import com.young.iMedical.util.GenericSuperClass;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements
		CommonDao<T> {

	// 泛型转换
	@SuppressWarnings("rawtypes")
	private Class entity = (Class) GenericSuperClass.getClass(this.getClass());

	/**
	 * @Name: save
	 * @Description: 保存对象的方法
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: T entity 对象
	 * @Return: 无
	 */
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	/**
	 * <bean id="xxxxx" class="cn.itcast.elec.dao.impl.CommonDaoImpl"> <property
	 * name="sessionFactory" ref="sessionFactory"></property> </bean>
	 */
	@Resource(name = "sessionFactory")
	public final void setSessionFactoryDi(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * @Name: update
	 * @Description: 修改对象的方法
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: T entity 对象
	 * @Return: 无
	 */
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	/**
	 * @Name: findObjectByID
	 * @Description: 使用主键ID查询对象
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: Serializable id 主键ID
	 * @Return: 返回对象
	 */
	@SuppressWarnings("unchecked")
	public T findObjectByID(Serializable id) {
		return (T) this.getHibernateTemplate().get(entity, id);
	}

	/**
	 * @Name: deleteObjectByIDs
	 * @Description: 通过id的删除对象
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: Serializable id 主键ID的数组
	 * @Return: 无
	 */
	@Override
	public void deleteObjectByID(Serializable id) {
		this.getHibernateTemplate().delete(id);
	}

	/**
	 * @Name: deleteObjectByIDs
	 * @Description: 通过id的数组删除对象
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: Serializable [] id 主键ID的数组
	 * @Return: 无
	 */
	public void deleteObjectByIDs(Serializable... ids) {
		for (int i = 0; ids != null && i < ids.length; i++) {
			Serializable id = ids[i];
			Object object = (Object) this.getHibernateTemplate()
					.get(entity, id);
			this.getHibernateTemplate().delete(object);
		}
	}

	/**
	 * @Name: deleteObjectByCollection
	 * @Description: 通过集合的形式删除对象
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2011-12-23 （创建日期）
	 * @Parameters: SCollection<T> list 集合对象
	 * @Return: 无
	 */
	public void deleteObjectByCollection(Collection<T> entities) {
		this.getHibernateTemplate().deleteAll(entities);
	}

	/**
	 * @Name: findCollectionByConditionNoPage
	 * @Description: 使用查询条件查询列表的集合（不分页）
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: String hqlWhere hql语句的where条件 Object[] params where条件的查询参数
	 *              LinkedHashMap<String, String> orderby 排序条件
	 * @Return: List<T> 结果集列表集合
	 */
	@SuppressWarnings("unchecked")
	public List<T> findCollectionByConditionNoPage(String hqlWhere,
			final Object[] params, LinkedHashMap<String, String> orderby) {
		/**
		 * 组织HQL语句的Where条件 select * from elec_text o where 1=1 放置DAO层 and
		 * o.textName like ? 放置Service层 and o.textRemark like ? order by
		 * o.textDate desc , o.textName asc
		 */
		String hql = "from " + entity.getSimpleName() + " o where 1=1";
		// 组织排序条件
		String hqlOrderBy = this.orderByCondition(orderby);
		hql = hql + hqlWhere + hqlOrderBy;
		final String finalHql = hql;
		List<T> list = (List<T>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(finalHql);
						setParams(query, params);
						return query.list();
					}
				});
		return list;
	}

	/**
	 * @Name: setParams
	 * @Description: 对where条件中的参数设置参数值
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: Object[] params 参数值
	 * @Return: 无
	 */
	private void setParams(Query query, Object[] params) {
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}

	/**
	 * @Name: orderByCondition
	 * @Description: 组织排序条件
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: LinkedHashMap<String, String> orderby 排序条件
	 * @Return: String 排序语句的字符串
	 */
	private String orderByCondition(LinkedHashMap<String, String> orderby) {
		StringBuffer buffer = new StringBuffer("");
		if (orderby != null) {
			buffer.append(" order by ");
			for (Map.Entry<String, String> map : orderby.entrySet()) {
				buffer.append(" " + map.getKey() + " " + map.getValue() + ",");
			}
			buffer.deleteCharAt(buffer.length() - 1);
		}
		return buffer.toString();
	}

	/**
	 * @Name: saveObjectByCollection
	 * @Description: 使用集合的形式进行批量保存
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-17 （创建日期）
	 * @Parameters: Collection<T> entities 集合对象
	 * @Return: 无
	 */
	public void saveObjectByCollection(Collection<T> entities) {
		this.getHibernateTemplate().saveOrUpdateAll(entities);
	}
}
