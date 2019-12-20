package com.util;

import org.junit.Test;

import java.sql.*;


public class DBdao {
	public static String user="root";
	public static String pass="123456";
	public static String dir="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/bookdb? serverTimezone=UTC & noAccessToProcedureBodies=true";
	static Connection con=null;
	public static Connection getConnection() {
		try {
			Class.forName(dir);//反射调取forName（）方法
			con= DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}	
		return con;
	}
	public static Connection closeConnection() {
		
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}
		return con;	
	}
	public static int SQLment(String sql,Object...prame) {//可变长任意类型参数
		int  rest=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=getConnection();
			pst=con.prepareStatement(sql);//预处理SQL
			if(prame!=null && prame.length>0) {//判读参数是否为空
				for(int i=0;i<prame.length;i++) {//逐个获取参数加入SQL语句执行
					pst.setObject(i+1, prame[i]);
				}
				rest=pst.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return rest;
		
	}
//	public void Call(String sql,Object...prm){
//		Connection con=null;
//		PreparedStatement pst=null;
//		try {
//			CallableStatement call = con.prepareCall("call user_add(?,?,?,?,?,?,?,?)");
//			if(prm!=null && prm.length>0) {
//					for(int i=0;i<prm.length;i++) {
//						pst.setObject(i+1, prm[i]);
//					}
//				}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static void  Transaction(String sid,String name,String pass,String age,String sex,String units,String classes,String phone,String flag) throws Exception {
		PreparedStatement pst=null;
		Connection con=null;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			String sql3="insert into user(uid, pass, flag) values ('"+sid+"','"+pass+"','"+flag+"')";
			pst=con.prepareStatement(sql3);
			pst.executeUpdate();
			if(flag.equals("2")){
				String sql1="insert into student(sid, name, pass, age, sex, units, class, phone) values('"+sid+"','"+name+"','"+pass+"','"+age+"','"+sex+"','"+units+"','"+classes+"','"+phone+"')";
				pst=con.prepareStatement(sql1);
				pst.executeUpdate();
			}
			if(flag.equals("3")){
				String sql2="insert into teacher(tid, name, pass, age, sex, units, phone) values('"+sid+"','"+name+"','"+pass+"','"+age+"','"+sex+"','"+units+"','"+phone+"')";
				pst=con.prepareStatement(sql2);
				pst.executeUpdate();
			}
			con.commit();
		} catch (SQLException ex) {
				ex.printStackTrace();
				con.rollback();
				getConnection();
			}
	}
}
