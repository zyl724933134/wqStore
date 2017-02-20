package com.wqstore.result;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.lang3.StringUtils;

public class CollectionContentUtils {
	public static final String SORT_ASC = "asc";
	
	public static final String SORT_DESC = "desc";
	
	@SuppressWarnings("unchecked")
	public static <T> void sortList(List<T> list, String[] sortFields, String sortOrder) {
		if(sortFields == null || sortFields.length == 0) {
			return;
		}
		Comparator<?> comparator = ComparableComparator.getInstance();
		comparator = ComparatorUtils.nullLowComparator(comparator);			//允许null 
		if(SORT_DESC.equals(sortOrder)) {
			comparator = ComparatorUtils.reversedComparator(comparator);	//逆序，默认正序
		}
		ArrayList<BeanComparator> sort = new ArrayList<BeanComparator>();	
		for (int i = 0; i < sortFields.length; i++) {
			if(StringUtils.isNotBlank(sortFields[i])) {
				sort.add(new BeanComparator(sortFields[i], comparator));	//声明要排序的对象的属性及排序规则
			}
		}
		
		ComparatorChain multiSort = new ComparatorChain(sort);				//创建排序链
		Collections.sort(list,multiSort);
	}
	
	/**
	 * List中对象根据指定字段和规则进行排序
	 * @param list	目标list
	 * @param sortField 排序字段名
	 * @param sortOrder 排序规则
	 */
	public static <T> void sortList(List<T> list, String sortField, String sortOrder) {
		if(StringUtils.isBlank(sortField)) {
			return;
		}
		String[] sortFields = new String[] {sortField};
		sortList(list,sortFields,sortOrder);
	}
	
	/**
	 * 将List中指定字段提取到Map中
	 * @param list
	 * @param fieldKey	转成key的字段名
	 * @param fieldValue 转成value的字段名	
	 * @return
	 */
	public static <T> Map<String,Object> extractToMap(List<T> list, String fieldKey, String fieldValue) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if(list != null) {
			for(T r : list) {
				try {
					Field fkey = r.getClass().getDeclaredField(fieldKey);
					fkey.setAccessible(true);
					Field fvalue = r.getClass().getDeclaredField(fieldValue);
					fvalue.setAccessible(true);
					String key = (String)fkey.get(r);
					Object value = fvalue.get(r);
					map.put(key, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return map;
	}
}
