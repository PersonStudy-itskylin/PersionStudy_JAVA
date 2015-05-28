package cn.hglq4.eshop.service.impl.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.hglq4.eshop.dao.impl.menu.MenuDAOImpl;
import cn.hglq4.eshop.entity.menu.Menu;
import cn.hglq4.eshop.service.menu.IMenuService;
import cn.hglq4.eshop.vo.menu.MenuVO;





@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	private static final Logger logger = Logger.getLogger(MenuServiceImpl.class);

	private MenuDAOImpl menuDao;


	@Override
	public List<MenuVO> getTreeNode(String id) {
		List<MenuVO> nl = new ArrayList<MenuVO>();
		String hql = null;
		Map<String, Object> params = new HashMap<String, Object>();
		if (id == null || id.equals("")) {
			// 查询所有根节点
			hql = "from Menu t where t.Menu is null";
		} else {
			// 异步加载当前id下的子节点
			hql = "from Menu t where t.Menu.id = :id ";
			params.put("id", id);
		}
		List<Menu> l = menuDao.find(hql, params);
		if (l != null && l.size() > 0) {
			for (Menu t : l) {
				MenuVO m = new MenuVO();
				BeanUtils.copyProperties(t, m);
				Set<Menu> set = t.getTmenus();
				if (set != null && !set.isEmpty()) {
					m.setState("closed");// 节点以文件夹的形式体现
				} else {
					m.setState("open");// 节点以文件的形式体现
				}
				nl.add(m);
			}
		}
		return nl;
	}

	@Override
	public List<MenuVO> getAllTreeNode() {
		List<MenuVO> nl = new ArrayList<MenuVO>();
		String hql = "from Menu t";
		List<Menu> l = menuDao.find(hql);
		if (l != null && l.size() > 0) {
			for (Menu t : l) {
				MenuVO m = new MenuVO();
				BeanUtils.copyProperties(t, m);
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", t.getUrl());
				m.setAttributes(attributes);
				Menu tm = t.getTmenu();// 获得当前节点的父节点对象
				if (tm != null) {
					m.setPid(tm.getId());
				}
				nl.add(m);
			}
		}
		return nl;
	}

}


