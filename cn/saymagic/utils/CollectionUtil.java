package cn.saymagic.utils;

import java.util.List;

/**
 * 集合相关的辅助类
 *
 * @author saymagic
 */
public class CollectionUtil {

	public CollectionUtil() {
	}

	public  static boolean isListEmpty(List l){
		if(l.size() == 0 || l == null)
			return true;
		else 
			return false;
		
	}

}
