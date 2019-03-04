package com.goat.controller;


import com.goat.domain.Menu;
import com.goat.resultmodel.RestResult;
import com.goat.resultmodel.ResultGenerator;
import com.goat.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    private final ResultGenerator generator = new ResultGenerator();
	@Autowired
	private IMenuService menuService;



	@RequestMapping("/list")
	@ResponseBody
	public RestResult getMenu(String userName) {
        List<Menu> menus = menuService.findUserMenus("MrBird");
        return generator.getSuccessResult("添加角色成功",menus,1);
	}

	@RequestMapping("/getMenu")
	@ResponseBody
	public RestResult getMenu(Long menuId) {
        Menu menu = menuService.findById(menuId);
        return generator.getSuccessResult("添加角色成功",menu,1);
	}
//
//	@RequestMapping("menu/menuButtonTree")
//	@ResponseBody
//	public ResponseBo getMenuButtonTree() {
//		try {
//			Tree<Menu> tree = this.menuService.getMenuButtonTree();
//			return ResponseBo.ok(tree);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("获取菜单列表失败！");
//		}
//	}
//
//	@RequestMapping("menu/tree")
//	@ResponseBody
//	public ResponseBo getMenuTree() {
//		try {
//			Tree<Menu> tree = this.menuService.getMenuTree();
//			return ResponseBo.ok(tree);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("获取菜单列表失败！");
//		}
//	}
//
//	@RequestMapping("menu/getUserMenu")
//	@ResponseBody
//	public ResponseBo getUserMenu(String userName) {
//		try {
//			Tree<Menu> tree = this.menuService.getUserMenu(userName);
//			return ResponseBo.ok(tree);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("获取用户菜单失败！");
//		}
//	}
//
//	@RequestMapping("menu/list")
//	@ResponseBody
//	public List<Menu> menuList(Menu menu) {
//		try {
//			return this.menuService.findAllMenus(menu);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@RequestMapping("menu/excel")
//	@ResponseBody
//	public ResponseBo menuExcel(Menu menu) {
//		try {
//			List<Menu> list = this.menuService.findAllMenus(menu);
//			return FileUtils.createExcelByPOIKit("菜单表", list, Menu.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("导出Excel失败，请联系网站管理员！");
//		}
//	}
//
//	@RequestMapping("menu/csv")
//	@ResponseBody
//	public ResponseBo menuCsv(Menu menu){
//		try {
//			List<Menu> list = this.menuService.findAllMenus(menu);
//			return FileUtils.createCsv("菜单表", list, Menu.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("导出Csv失败，请联系网站管理员！");
//		}
//	}
//
//	@RequestMapping("menu/checkMenuName")
//	@ResponseBody
//	public boolean checkMenuName(String menuName, String type, String oldMenuName) {
//		if (StringUtils.isNotBlank(oldMenuName) && menuName.equalsIgnoreCase(oldMenuName)) {
//			return true;
//		}
//		Menu result = this.menuService.findByNameAndType(menuName, type);
//		if (result != null)
//			return false;
//		return true;
//	}
//
//	@Log("新增菜单/按钮")
//	@RequiresPermissions("menu:add")
//	@RequestMapping("menu/add")
//	@ResponseBody
//	public ResponseBo addMenu(Menu menu) {
//		String name = "";
//		if (Menu.TYPE_MENU.equals(menu.getType()))
//			name = "菜单";
//		else
//			name = "按钮";
//		try {
//			this.menuService.addMenu(menu);
//			return ResponseBo.ok("新增" + name + "成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("新增" + name + "失败，请联系网站管理员！");
//		}
//	}
//
//	@Log("删除菜单")
//	@RequiresPermissions("menu:delete")
//	@RequestMapping("menu/delete")
//	@ResponseBody
//	public ResponseBo deleteMenus(String ids) {
//		try {
//			this.menuService.deleteMeuns(ids);
//			return ResponseBo.ok("删除成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("删除失败，请联系网站管理员！");
//		}
//	}
//
//	@Log("修改菜单/按钮")
//	@RequiresPermissions("menu:update")
//	@RequestMapping("menu/update")
//	@ResponseBody
//	public ResponseBo updateMenu(Menu menu) {
//		String name = "";
//		if (Menu.TYPE_MENU.equals(menu.getType()))
//			name = "菜单";
//		else
//			name = "按钮";
//		try {
//			this.menuService.updateMenu(menu);
//			return ResponseBo.ok("修改" + name + "成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("修改" + name + "失败，请联系网站管理员！");
//		}
//	}
}