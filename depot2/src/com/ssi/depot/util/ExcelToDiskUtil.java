/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.ssi.depot.entity.ProductInOut;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot2
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.util;
 * Author：      林为 
 * Create Date： 2014年10月29日 上午10:43:49
 * Modified By：  林为 
 * Modified Date: 2014年10月29日 上午10:43:49
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
//@SuppressWarnings("all")
public class ExcelToDiskUtil {

	private static WritableWorkbook wwk;
	
	
	/**
	 * 
	 * 功能描述： 导出出库单
	 * @param File file 要导出的文件位置，默认位置和文件名：C:\\产品出库表.xls
	 * @param ProductInOut productInOut 导出的对象属性值
	 * @param Integer topStrRow Y坐标位置,默认topStrRow = 0，该值不能小于0
	 * @param Integer topStrCol X坐标位置,默认topStrCol = 0，该值不能小于0
	 */
	public static boolean ToExcelPrint(ProductInOut productInOut,Integer topStrRow,Integer topStrCol) {
		boolean flag = true;
		
		String path = "excel/";
		//判断file是否是文件或者是否为空，默认为：webroot/excel/ToExcel_（时间）.xls
		File file = new File(path, "ToExcel_" + System.currentTimeMillis() + ".xls");
		
		//判断行数是否为空或为负数
		if(topStrRow == null && topStrRow < 0){
			topStrRow = 0;
		}

		//判断列数是否为空或为负数
		if(topStrCol == null && topStrCol < 0){
			topStrCol = 0;
		}
		try {
			wwk = Workbook.createWorkbook(file);
			WritableSheet ws = wwk.createSheet("产品出库表", 0);

			ws.mergeCells(topStrCol + 1, topStrRow, topStrCol + 6, topStrRow);
			ws.mergeCells(topStrCol + 1, topStrRow + 1, topStrCol + 3,
					topStrRow + 1);
			ws.mergeCells(topStrCol + 5, topStrRow + 1, topStrCol + 6,
					topStrRow + 1);
			ws.mergeCells(topStrCol + 3, topStrRow + 4, topStrCol + 3,
					topStrRow + 5);
			ws.mergeCells(topStrCol + 4, topStrRow + 4, topStrCol + 6,
					topStrRow + 5);
			ws.mergeCells(topStrCol + 4, topStrRow + 6, topStrCol + 6,
					topStrRow + 6);
			ws.mergeCells(topStrCol + 4, topStrRow + 7, topStrCol + 6,
					topStrRow + 7);
			ws.mergeCells(topStrCol + 2, topStrRow + 8, topStrCol + 6,
					topStrRow + 8);
			ws.mergeCells(topStrCol + 2, topStrRow + 9, topStrCol + 6,
					topStrRow + 9);
			ws.mergeCells(topStrCol + 2, topStrRow + 10, topStrCol + 6,
					topStrRow + 10);
			ws.mergeCells(topStrCol + 2, topStrRow + 11, topStrCol + 6,
					topStrRow + 11);

			WritableFont wfc = new WritableFont(WritableFont.ARIAL, 20,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat top = new WritableCellFormat(wfc);

			WritableCellFormat border = new WritableCellFormat();
			border.setVerticalAlignment(VerticalAlignment.CENTRE);
			border.setAlignment(Alignment.LEFT);
			border.setBorder(Border.ALL, BorderLineStyle.THIN);

			// 水平居中
			top.setAlignment(Alignment.CENTRE);
			top.setVerticalAlignment(VerticalAlignment.BOTTOM);
			ws.addCell(new Label(topStrCol + 1, topStrRow, "极地安全产品出库单", top));

			WritableCellFormat body = new WritableCellFormat();
			// 水平居中
			body.setAlignment(Alignment.CENTRE);
			body.setBorder(Border.ALL, BorderLineStyle.THIN);

			// 创建样式表格
			for (int col = topStrCol + 2; col < topStrCol + 7; col++) {
				for (int row = topStrRow + 2; row < topStrRow + 12; row++) {
					Label label = new Label(col, row, null, border);
					ws.addCell(label);
					ws.setRowView(row, 30 * 20);
					ws.setColumnView(row, 15);
				}
			}

			// 表头
			body.setWrap(true);
			body.setVerticalAlignment(VerticalAlignment.CENTRE);
			ws.addCell(new Label(topStrCol + 1, topStrRow + 1, "时间："
					+ new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss")
							.format(new Date())));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 2, "硬件编号", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 3, "产品类型", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 4, "出库种类", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 5, "合同编号", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 6, "项目编号", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 7, "出库时间", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 8, "申请人", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 9, "提货人", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 10, "备注", body));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 11, "库管签字", body));
			ws.addCell(new Label(topStrCol + 3, topStrRow + 2, "型号", body));
			ws.addCell(new Label(topStrCol + 3, topStrRow + 3, "灌机人", body));
			ws.addCell(new Label(topStrCol + 3, topStrRow + 4, "出库状态", body));
			ws.addCell(new Label(topStrCol + 3, topStrRow + 6, "项目名称", body));
			ws.addCell(new Label(topStrCol + 3, topStrRow + 7,
					"签约公司        （或最终用户）", body));
			ws.addCell(new Label(topStrCol + 5, topStrRow + 2, "采购成本", body));
			ws.addCell(new Label(topStrCol + 5, topStrRow + 3, "灌机点数", body));
			
			//表格属性值
			ws.addCell(new Label(topStrCol + 2, topStrRow + 2, productInOut.getProduct().getProid().toString(), border));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 3, productInOut.getPiotype(), border));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 4, "正式发货", border));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 5, productInOut.getPioagreementid(), border));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 6, productInOut.getPioprojectid(), border));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 7, DateUtil.format(productInOut.getPiouttime()).toString(), border));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 8, productInOut.getAccount().getRealname(),border));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 9, productInOut.getAccount().getRealname(), border));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 10, productInOut.getPioremark(), border));

			ws.addCell(new Label(topStrCol + 4, topStrRow + 2, productInOut.getPiotype(), border));
			ws.addCell(new Label(topStrCol + 4, topStrRow + 3, productInOut.getPiooperation(), border));
			ws.addCell(new Label(topStrCol + 4, topStrRow + 4, productInOut.getPiotype(), border));
			ws.addCell(new Label(topStrCol + 4, topStrRow + 6, productInOut.getPioprojectname(), border));
			ws.addCell(new Label(topStrCol + 4, topStrRow + 7, productInOut.getPiosign(), border));

			ws.addCell(new Label(topStrCol + 6, topStrRow + 2, productInOut.getPiointime(), border));
			ws.addCell(new Label(topStrCol + 6, topStrRow + 3, productInOut.getPiooperationnum().toString(), border));
		
			//写入完毕
			wwk.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			flag = false;
		}finally{
			try {
				if(wwk != null){
					wwk.close();
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				System.out.println("table关闭失败。。。");
			}
		}
		return flag;
	}



	/**
	 * 
	 * 方  法 名: Excel2List
	 * 功能描述： 导出出库单列表
	 * @param File file 要导出的文件位置，默认位置和文件名：C:\\产品出库表.xls
	 * @param ProductInOut productInOut 导出的对象属性值
	 * @param Integer topStrRow Y坐标位置,默认topStrRow = 0
	 * @param Integer topStrCol X坐标位置,默认topStrCol = 0
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月30日 下午3:05:22
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月30日 下午3:05:22
	 */
	public static boolean Excel2List(File file,List<ProductInOut> productInOuts,Integer topStrRow,Integer topStrCol){
		boolean flag = true;
		//判断file是否是文件或者是否为空，默认为C:\\产品出库表.xls
		
		
		//判断行数是否为空或为负数
		if(topStrRow == null && topStrRow < 0){
			topStrRow = 0;
		}

		//判断列数是否为空或为负数
		if(topStrCol == null && topStrCol < -1){
			topStrCol = -1;
		}
		try {
			wwk = Workbook.createWorkbook(file);
			WritableSheet ws = wwk.createSheet("产品出库表", 0);

			ws.mergeCells(topStrCol + 1, topStrRow, topStrCol + 18, topStrRow);
			ws.mergeCells(topStrCol + 1, topStrRow + 1, topStrCol + 3,
					topStrRow + 1);
			ws.mergeCells(topStrCol + 17, topStrRow + 1, topStrCol + 18,
					topStrRow + 1);
			
			WritableFont wfc = new WritableFont(WritableFont.ARIAL, 20,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat top = new WritableCellFormat(wfc);

			WritableCellFormat border = new WritableCellFormat();
			border.setVerticalAlignment(VerticalAlignment.CENTRE);
			border.setAlignment(Alignment.LEFT);
			border.setBorder(Border.ALL, BorderLineStyle.THIN);

			// 水平居中
			top.setAlignment(Alignment.CENTRE);
			top.setVerticalAlignment(VerticalAlignment.BOTTOM);
			ws.addCell(new Label(topStrCol + 1, topStrRow, "极地安全产品出库单", top));

			WritableCellFormat body = new WritableCellFormat();
			// 水平居中
			body.setAlignment(Alignment.CENTRE);
			body.setBorder(Border.ALL, BorderLineStyle.THIN);

			// 创建样式表格
			for (int row = topStrRow + 2; row < topStrRow + 12; row++) {
				Label label = new Label(2, 2, null, border);
				ws.addCell(label);
				ws.setRowView(2, 30 * 20);
				ws.setColumnView(2, 20);
			}

			// 表头
			body.setWrap(true);
			body.setVerticalAlignment(VerticalAlignment.CENTRE);
			ws.addCell(new Label(topStrCol + 1, topStrRow + 1, "时间："
					+ DateUtil.format(new Date(), "yyyy年MM月dd日  HH:mm:ss").toString()));
			ws.addCell(new Label(topStrCol + 1, topStrRow + 2, "记录编号", body));
			ws.addCell(new Label(topStrCol + 2, topStrRow + 2, "硬件编号", body));
			ws.addCell(new Label(topStrCol + 3, topStrRow + 2, "产品型号", body));
			ws.addCell(new Label(topStrCol + 4, topStrRow + 2, "产品类型", body));
			ws.addCell(new Label(topStrCol + 5, topStrRow + 2, "采购成本", body));
			ws.addCell(new Label(topStrCol + 6, topStrRow + 2, "出库种类", body));
			ws.addCell(new Label(topStrCol + 7, topStrRow + 2, "出库时间", body));
			ws.addCell(new Label(topStrCol + 8, topStrRow + 2, "合同编号", body));
			ws.addCell(new Label(topStrCol + 9, topStrRow + 2, "项目编号", body));
			ws.addCell(new Label(topStrCol + 10, topStrRow + 2, "项目名称", body));
			ws.addCell(new Label(topStrCol + 11, topStrRow + 2, "灌机人", body));
			ws.addCell(new Label(topStrCol + 12, topStrRow + 2, "灌机点数", body));
			ws.addCell(new Label(topStrCol + 13, topStrRow + 2, "出库状态", body));
			ws.addCell(new Label(topStrCol + 14, topStrRow + 2,
					"签约用户", body));
			ws.addCell(new Label(topStrCol + 15, topStrRow + 2, "申请人", body));
			ws.addCell(new Label(topStrCol + 16, topStrRow + 2, "提货人", body));
			ws.addCell(new Label(topStrCol + 17, topStrRow + 2, "备注", body));
			ws.addCell(new Label(topStrCol + 18, topStrRow + 2, "库管签字", body));
			
			//表格属性值
			int i =topStrRow + 3;//下标
			for(ProductInOut productInOut: productInOuts){
				ws.setRowView(topStrRow + i, 30 * 10);
				ws.setColumnView(topStrRow + i, 25);
				ws.addCell(new Label(topStrCol + 1, topStrRow + i, productInOut.getProduct().getProid().toString(), border));
				ws.addCell(new Label(topStrCol + 4, topStrRow + i, productInOut.getPioagreementid(), border));
				ws.addCell(new Label(topStrCol + 5, topStrRow + i, productInOut.getPioprojectid(), border));
				ws.addCell(new Label(topStrCol + 4, topStrRow + i, productInOut.getPiotype(), border));
				ws.addCell(new Label(topStrCol + 6, topStrRow + i, DateUtil.format(productInOut.getPiouttime()).toString(), border));
				ws.addCell(new Label(topStrCol + 6, topStrRow + i, "正式发货", border));
				ws.addCell(new Label(topStrCol + 7, topStrRow + i, productInOut.getPioapply(), border));
				ws.addCell(new Label(topStrCol + 8, topStrRow + i, productInOut.getPiodelivery(), border));
	
				ws.addCell(new Label(topStrCol + 10, topStrRow + i, productInOut.getPiotype(), border));
				ws.addCell(new Label(topStrCol + 11, topStrRow + i, productInOut.getPiooperation(), border));
				ws.addCell(new Label(topStrCol + 12, topStrRow + i, productInOut.getPiotype(), border));
				ws.addCell(new Label(topStrCol + 13, topStrRow + i, productInOut.getPioprojectname(), border));
	
				ws.addCell(new Label(topStrCol + 15, topStrRow + i, productInOut.getAccount().getRealname(), border));
				ws.addCell(new Label(topStrCol + 16, topStrRow + i, productInOut.getAccount().getRealname(), border));
				ws.addCell(new Label(topStrCol + 17, topStrRow + i, productInOut.getPiointime(), border));
				ws.addCell(new Label(topStrCol + 18, topStrRow + i, productInOut.getPiooperationnum().toString(), border));
				ws.addCell(new Label(topStrCol + 17, topStrRow + i, productInOut.getPioremark(), border));
				ws.addCell(new Label(topStrCol + 18, topStrRow + i, productInOut.getPiosign(), border));
				i++;
			}
			
			//写入完毕
			wwk.write();
			System.out.println("文件列表写入完成！~");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			flag = false;
		}finally{
			try {
				if(wwk != null){
					wwk.close();
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				System.out.println(e);
				System.out.println("List关闭失败。。。");
			}
		}
		return flag;
	}
}
