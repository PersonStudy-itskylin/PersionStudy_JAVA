<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>软件1211—注册</title>
    <script language="javascript" src="js/YMDClass.js"></script>
    <style type="text/css">
    	body{background-color:#09F;}
    	.content{width: 700px;margin:0 auto;font-size:14px;}
    	table{background-color:#abc;font-size:14px;}
    	table caption{font-size:35px;padding: 15px;padding-bottom: 0px;}
    	table tr.last{padding-bottom: 20px;}
    	.loadphoto{font-size:12px;height: 220px;}
    	.loadphoto .view{margin-left:200px;margin-top:10px;}
    </style>
  </head>
  
  <body>
  	<div class="content">
	  	<form action="" method="post">
	  	<table align="left">
	  		<caption>软件1211班注册登陆信息表</caption>
	  		<tr>
	  			<td>学号：</td>
	  			<td><input type="text" name="gr_no" value="12303130123" readonly="readonly" style="background-color:#abc;border-collapse: 0;" ></td>
	  			<td align="center" rowspan="7" width="250">
	  				<div class="loadphoto">
	  					<div style="padding:20px 30px 10px 30px;">
	  						<textarea rows="7" cols="9">图片预览预留位置</textarea>
	  					</div>
	  					<span>图片位置：<input class="input2" type="text" name="gr_photo"></span>
	  					<span class="view"><input type="button" name="" value="预览"></span>
	  				</div>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>姓名：</td>
	  			<td><input type="text" name="gr_name"></td>
	  		</tr>
	  		<tr>
	  			<td>性别：</td>
	  			<td><input type="text" name="gr_sex"></td>
	  		</tr>
	  		<tr>
	  			<td>出生日期:</td>
				<td>					
					<select name="year"></select>
					<select name="month"></select>
					<select name="day"></select>
					<script>
						new YMDselect('year','month','day');
					</script>
				</td>
				
	  		</tr>
	  		<tr>
	  			<td>电话号码:</td>
	  			<td><input type="text" name="gr_tel"> </td>
	  		</tr>
	  		<tr>
	  			<td>QQ号码:</td>
	  			<td><input type="text" name="gr_qq"> </td>
	  		</tr>
	  		<tr>
	  			<td>QQ号码:</td>
	  			<td><input type="text" name="gr_qq"> </td>
	  		</tr>
	  		<tr>
	  			<td>家庭地址:</td>
	  			<td><input type="text" name="gr_address"></td>
	  		</tr>
	  		<tr>
	  			<td>微博:</td>
	  			<td><input type="text" name="tz_weibo"></td>
	  		</tr>
	  		<tr>
	  			<td>恋爱状态:</td>
	  			<td>
	  				<select name="tz_loveno">
	  					<option value="1">光棍儿</option>
	  					<option value="2">恋爱ing</option>
	  					<option value="3">婚姻的坟墓ing</option>
	  					<option value="4">其他...</option>
	  				</select>
	  			</td>
	  		<tr>
	  			<td valign="top">恋爱宣言:</td>
	  			<td colspan="2">
	  				<textarea rows="6" cols="40" name="tz_lovesay" onfocus="javascript:this.value=''">请输入您的恋爱宣言...</textarea>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>兴趣爱好:</td>
	  			<td colspan="2">
	  				<input type="checkbox" name="jsj">计算机
	  				<input type="checkbox" name="sheying">摄影
	  				<input type="checkbox" name="lvyou">旅游
	  				<input type="checkbox" name="liubing">溜冰<br />
	  				其他：<input type="text" name="other">	  				
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>&nbsp;</td>
	  		</tr>
	  		<tr class="last">
	  			<td>&nbsp;</td>
	  			<td colspan="3">
	  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  				<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  				<input type="reset" value="重置">
	  			</td>
	  		</tr>
	  	</table>
	  	</form>
  	</div>
  </body>
</html>
