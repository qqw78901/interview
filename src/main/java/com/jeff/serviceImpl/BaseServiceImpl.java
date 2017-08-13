package com.jeff.serviceImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.jeff.mapper.BaseMapper;
import com.jeff.mybatis.autobuild.MybatisContext;
import com.jeff.mybatis.page.Page;
import com.jeff.mybatis.page.PageContext;
import com.jeff.service.BaseService;

public class BaseServiceImpl<T, ID extends Serializable> implements
		BaseService<T, ID> {

	private BaseMapper<T, ID> baseMapper;

	/**
	 * 创建Class的对象来获取泛型的class
	 */
	public Class<?> clz = null;

	public Class<?> getClz() {
		if (this.clz == null) {
			// 获取泛型的Class对象
			this.clz = ((Class<?>) (((ParameterizedType) (this.getClass()
					.getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return this.clz;
	}

	@Override
	public int add(T t) {
		return baseMapper.insert(t);
	}

	@Override
	public int deleteById(ID id) {
		MybatisContext.setClzName(this.getClz().getSimpleName());
		int i = baseMapper.deleteById(id);
		// MybatisContext.clearContext();
		return i;
	}

	@Override
	public int update(T t) {
		return baseMapper.update(t);
	}

	@Override
	public T getById(ID id) {
		MybatisContext.setClzName(this.getClz().getSimpleName());
		T t = baseMapper.getById(id);
		// MybatisContext.clearContext();
		return t;
	}

	@Override
	public List<T> list(T t) {
		return baseMapper.list(t);
	}

	@Override
	public Page<T> findByPage(T t) {
		List<T> data = baseMapper.findByPage(t);
		return buildPage(data);
	}

	@Override
	public Page<T> buildPage(List<T> data) {
		Page<T> page = new Page<T>();
		page.setRows(data);
		page.setOffset(PageContext.getPageOffset());
		page.setLimit(PageContext.getPageLimit());
		page.setTotal(PageContext.getTotalCount());
		page.setTotalPage(PageContext.getTotalPage());
		return page;
	}

	@Override
	public <V> Page<V> buildVoPage(List<V> data) {
		Page<V> page = new Page<V>();
		page.setRows(data);
		page.setOffset(PageContext.getPageOffset());
		page.setLimit(PageContext.getPageLimit());
		page.setTotal(PageContext.getTotalCount());
		page.setTotalPage(PageContext.getTotalPage());
		return page;
	}

	public BaseMapper<T, ID> getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
		this.baseMapper = baseMapper;
	}

}
