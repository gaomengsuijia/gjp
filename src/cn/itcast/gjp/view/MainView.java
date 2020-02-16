package cn.itcast.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

/**
 * 用户界面层
 * @author Administrator
 *
 */
public class MainView {
	private ZhangWuController zhangWucontroller = new ZhangWuController();
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag){
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			int i = sc.nextInt();
			switch(i){
			case 1:
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				System.out.println("再见");
				flag = false;
				break;
			default:
				System.out.println("输入错误！");
				
			}
		}
		
	}

	private void selectZhangWu() {
		// TODO Auto-generated method stub
		System.out.println("1.查询所有　2.按条件查询");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch(i){
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		default:
			System.out.println("选择错误");
		}
		
	}
	
	private void select(){
		System.out.println("请输入时间格式为XXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入查询起始时间：");
		String start = sc.nextLine();
		System.out.println("请输入查询结束时间：");
		String end = sc.nextLine();
		List<ZhangWu> result = zhangWucontroller.select(start,end);
		if (result.size()>0){
			print(result);
		}else{
			System.out.println("无数据");
		}
		
	}
	
	
	private void selectAll(){
		List<ZhangWu> result = zhangWucontroller.selectZhangWu();
		if (result.size()>0){
			print(result);
		}else{
			System.out.println("无数据");
		}
	}
	/**
	 * 打印账户
	 */
	private void  print(List<ZhangWu> zhangWuList){
		System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
		for (ZhangWu zw : zhangWuList) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
					+ zw.getZhanghu() + "\t\t" + zw.getMoney() + "\t\t"
					+ zw.getCreatetime() + "\t" + zw.getDescription());
		}
	}

	private void deleteZhangWu() {
		// TODO Auto-generated method stub
		selectAll();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要删除的账户：");
		int zwid = sc.nextInt();
		System.out.println("确定要删除"+zwid+"吗,输入1是，输入2否");
		int confirm = sc.nextInt();
		switch(confirm){
		case 1:
			confirmDel(zwid);
			break;
		case 2:
			System.out.println("已取消删除");
			break;
		default:
			break;
		}
		
	}
	
	private void confirmDel(int zwid){
		int result = zhangWucontroller.deleteZhangWu(zwid);
		if (result>0){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}

	private void editZhangWu() {
		// TODO Auto-generated method stub
		selectAll();
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入id");
		int zwid = sc.nextInt();
		System.out.print("请输入类别：");
		String flname = sc.next();
		System.out.print("请输入账户：");
		String zhanghu = sc.next();
		System.out.print("请输入金额：");
		double money = sc.nextDouble();
		System.out.print("请输入时间:");
		String createtime = sc.next();
		System.out.print("请输入描述：");
		String description = sc.next();
		
		//实例化dao
		ZhangWu zhangWu  = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		//编辑账户
		int result = zhangWucontroller.editZhangWu(zhangWu);
		if (result>0){
			System.out.println("编辑账户成功");
		}else{
			System.out.println("编辑失败");
		}
				
		
	}

	private void addZhangWu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入类别：");
		String flname = sc.next();
		System.out.print("请输入账户：");
		String zhanghu = sc.next();
		System.out.print("请输入金额：");
		double money = sc.nextDouble();
		System.out.print("请输入时间:");
		String createtime = sc.next();
		System.out.print("请输入描述：");
		String description = sc.next();
		//实例化dao
		ZhangWu zhangWu  = new ZhangWu(0, flname, money, zhanghu, createtime, description);
		//添加账户
		int result = zhangWucontroller.addZhangWu(zhangWu);
		if (result>0){
			System.out.println("添加账户成功");
		}else{
			System.out.println("添加失败");
		}
		
		
		
	} 

}
