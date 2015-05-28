<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="cn.xiangce.DBXiangce"%>
<%@page import="cn.gonggao.DBGonggao"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.sql.*"%>
<%@ page import="cn.liuyan.*" %>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-cn">
	<title>软件1211班主页</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="css/class_index.css">
	<style type="text/css">
		a{text-decoration: none;}
	</style>
	<script type="text/javascript">
		function exit(){			
			if(confirm('确定要退出吗？')){
				alert('确定');
			}
		function login(){
				alert('欢迎您');
				var username =<%=session.getAttribute("username")%>;
				alert(username);
				if(username != null){
					alert('欢迎您，' + username);
				}else{
					history.go(-1);
				}
			}
		}
	</script>
</head>
<body onload="login()">
	<div class="bd">
    	<div class="top"><!---头部----->
        	<ul>
            	<li><a href="#">设为首页</a></li>
            	<li><a href="#">加入收藏</a></li>
            	<li><a href="#">联系我们</a></li>
            </ul>
            <div class="login">
            	<span class="user">您好，<a href="tongxue/person.jsp"><%=session.getAttribute("username")%> </a></span>
            	<span onclick="exit()" style="cursor: pointer;"><a>退出</a></span>
            </div>
        </div>
        <div class="banji">
        	<ul>
            	<li><a href="class_index.jsp">班级主页</a></li>
            	<li><a href="gonggao/index.jsp">班级通告</a></li>
            	<li><a href="tongxue/index.jsp">&nbsp;同学录&nbsp;</a></li>
            	<li><a href="xiangce/index.jsp">班级相册</a></li>
            	<li class="last"><a href="liuyan/index.jsp">班级留言</a></li>
            </ul>
            <div class="new">
            	<div class="newtop">
                	<span><a href="gonggao/index.jsp">更多></a></span>
                </div>
               	<div class="newtext">
                	<img src="images/newtextback.png" />
                    <table>
						<%
							DBGonggao gonggao = new DBGonggao();
							ResultSet rs = gonggao.queryGonggaoTop5();
							try {
								while (rs.next()) {
									String time = new String(rs.getString("times")).substring(
											0, 16);
									String content = new String(rs.getString("content"))
											.substring(0, 15);
						%>
						<tr>
							<td><a href="gonggao/content.jsp?id=<%=rs.getInt("id")%>"><img style="height: 11px;width: auto;" src="images/new.gif" /><%=content%>...</a></td>
							<td><%=time%></td>
						</tr>
						<%
							}
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						%>
					</table>        
                </div>
               	<div class="newliuyan">
                	<div class="newliuyantop">
                    	<span><a href="liuyan/index.jsp">更多></a></span>
                    </div>
                    <div class="newliuyantext">
                    	<img src="images/index_32.gif">
                        <table class="liuyancontent" >
                        	<%
                        		DBLiuyan liuyan = new DBLiuyan();
                        		rs =liuyan.queryTop5();
                        		try{
                        			while(rs.next()){
                        				String lycontent = new String(rs.getString("content")).substring(0,5);
                        				String lytime = new String(rs.getString("times")).substring(5,10);
                        	%>
                        		<tr>
                        			<td><%= lycontent %>...</td>
                        			<td><%= lytime %></td>
                        		</tr>
                        	<%
                        			}
                        		}catch(Exception e){
                        			e.printStackTrace();
                        		}                        	
                        	%>
                           <!--  
                           			留言列表                          
                           --> 
                        </table>
                    </div>
                </div>
                <div class="classjianjie">
                	<div class="classjianjietop">
                    	<span><a href="jianjie/jianjie.html">更多></a></span>
                    </div>
                    <div class="classjianjietext">
                    	<img src="images/index_34.gif">
                        <table>
                        	<tr><td>2002年，我们来到美丽的海南岛，</td></tr>
                            <tr><td>鄂东院，怀着对计算机软件技术的</td></tr>
                            <tr><td>热爱！经过了一年的基本功学习，</td></tr>
                            <tr><td>2014年秋天，随着联合办学，我们</td></tr>
                            <tr><td>被派到了广东省轻工业技师学院…</td></tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="xiangce">
            	<img src="images/index_17.gif">
                <div class="photo">
                	<%
                		DBXiangce xiangce = new DBXiangce();
                	                		rs = xiangce.queryXiangcetop2(session.getAttribute("userno") + "" ); 
                	                		try{
                	                			while(rs.next()){
                	%>
                			<p>
                				<a href="xiangce/index.jsp?id=<%=rs.getInt(1)%>"><img src="<%=rs.getString("imagepath")%>" /></a>
                			
                			</p>
                	<%
                		}
                	                		}catch(Exception e){
                	                			e.printStackTrace();
                	                		}
                	%>
                    <span><a href="xiangce/xiangce.html">更多></a></span>
                </div>
            </div>
        </div>
        <div class="newboard">
        	<marquee scrolldelay="50" scrollamount="3">
            	<span><img src="images/new.gif">公告：</span>
            	<%
            		try{
            	            		String content = new DBGonggao().queryGonggaoTop1();
            	            		out.print(content);
            	            		}catch(Exception e){
            	            			e.printStackTrace();
            	            		}
            	%>
            </marquee>
        </div>
        <div class="course">
        	<span>※※ 本学期课程安排 ※※</span>
            <table background="images/index_18.gif" bordercolor="#000080" border="1" cellspacing="0">
              <tr>
                  <th colspan="2">节次/时间</th>
                  <th>星期一</th>
                  <th>星期二</th>
                  <th>星期三</th>
                  <th>星期四</th>
                  <th>星期五</th>
              </tr>
              <tr>
                  <td rowspan="4">上<br />午</td>
                  <td>08:00-08:45</td>
                  <td rowspan="2" style="background-color:#f33;">Linux系统<br />@实验楼二楼</td>
                  <td rowspan="2" style="background-color:green;">Web JSP项目开发<br />@实验楼403</td>
                  <td rowspan="2" style="background-color:green;">Web JSP项目开发<br />@视频一</td>
                  <td rowspan="2" style="background-color:#09f;">WEB HTML客户端开发<br />@视频二</td>
                  <td rowspan="2" style="background-color:#09f;">WEB HTML客户端开发<br />@实验楼301</td>
              </tr>
              <tr>
                  <td>08：55-09:40</td>
              </tr>
              <tr>
                  <td>10:00-10:45</td>
                  <td rowspan="2" style="background-color:#f33">Linux系统<br />@实验楼405</td>
                  <td rowspan="2" style="background-color:#99f;">软件测试<br />@实验楼203</td>
                  <td rowspan="2" style="background-color:green;">Web JSP项目开发<br />@实验楼附一楼</td>
                  <td rowspan="2" style="background-color:#99f;">软件测试<br />@实验楼203</td>
                  <td rowspan="2" style="background-color:#99f;">软件测试<br />@3#203</td>
              </tr>
              <tr>
                  <td>10：55-11:40</td>
              </tr>
              <tr>
                  <td rowspan="2">下<br />午</td>
                  <td>14:10-14:55</td>
                  <td rowspan="2" style="background-color:#f33">Linux系统<br />@视频一</td>
                  <td rowspan="2">&nbsp;</td>
                  <td rowspan="2" style="background-color:#09f;">WEB HTML客户端开发<br />@视频二</td>
                  <td rowspan="2">&nbsp;</td>
                  <td rowspan="2">&nbsp;</td>
              </tr>
              <tr>
                  <td>15:05-15:50</td>
              </tr>
    </table>
        </div>
        <div>
          <div class="admin">
              <a href="admin/admin.html"><img src="images/index_33.gif"></a>
              <table border="1" width="660" cellspacing="0" bordercolor="#666666">
                <tr>
                    <td width="265" style="font-size: 12px">
                    站长：负责网站运行的一切事物</td>
                    <td style="font-size: 12px">
                    设计部长：主要进行网站的美工，图片制作</td>
                </tr>
                <tr>
                    <td width="265" style="font-size: 12px">
                    副站长：协助站长进行一系列的管理</td>
                    <td style="font-size: 12px">
                    宣传部长：负责对同学或社会宣传本站的内容，寻找友情链接等宣传工作</td>
                </tr>
                <tr>
                    <td width="265" style="font-size: 12px">
                    文学部长：负责收集同学的文学材料并审核</td>
                    <td style="font-size: 12px">
                    相册部长：负责收集同学或老师的相片，协助新闻部长收集图片等</td>
                </tr>
                <tr>
                    <td width="265" style="font-size: 12px">
                    新闻部长：收集本班发生的新闻、趣事、通知等</td>
                    <td style="font-size: 12px">
                    录入员：负责协助各部长进行文字录入</td>
                </tr>
            </table>
          </div>
          <div class="admin2">
              <a href="banganbu/banganbu.html"><img src="images/index_43.gif"></a>
              <table border="1" width="660" bordercolor="#666666" cellpadding="0" height="51" cellspacing="0">
                <tr>
                    <td>&nbsp;班长：林为</td>
                    <td>&nbsp;副班长：林为</td>
                    <td>&nbsp;学习委员：林为</td>
                    <td>&nbsp;文艺委员：林为</td>
                </tr>
                <tr>
                    <td>&nbsp;体育委员：林为</td>
                    <td>&nbsp;生活委员：林为</td>
                    <td>&nbsp;劳动委员：林为</td>
                    <td>&nbsp;宣传委员：林为</td>
                </tr>
              </table>
          </div>
          <div class="linkfriend">
          		<img class="back" src="images/newlink.gif">
                <table>
                	<tr>
                    	<td><a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437"><img border="0" src="http://wpa.qq.com/imgd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></td>
                    	<td><a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437"><img border="0" src="http://wpa.qq.com/imgd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></td>
                    	<td><a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437"><img border="0" src="http://wpa.qq.com/imgd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></td>
                    	<td><a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437"><img border="0" src="http://wpa.qq.com/imgd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></td>
                    	<td><a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437"><img border="0" src="http://wpa.qq.com/imgd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></td>
                    	<td><a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437"><img border="0" src="http://wpa.qq.com/imgd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></td>
                    	<td><a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437"><img border="0" src="http://wpa.qq.com/imgd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></td>
                    </tr>
                    <tr>
                    	<td><a href="http://user.qzone.qq.com/403415171" target="_blank"><img src="images/nologo.gif"></a></td>
                    	<td><a href="http://user.qzone.qq.com/403415171" target="_blank"><img src="images/nologo.gif"></a></td>
                        <td><a href="http://user.qzone.qq.com/403415171" target="_blank"><img src="images/nologo.gif"></a></td>
                        <td><a href="http://user.qzone.qq.com/403415171" target="_blank"><img src="images/nologo.gif"></a></td>
                        <td><a href="http://user.qzone.qq.com/403415171" target="_blank"><img src="images/nologo.gif"></a></td>
                        <td><a href="http://user.qzone.qq.com/403415171" target="_blank"><img src="images/nologo.gif"></a></td>
                        <td><a href="http://user.qzone.qq.com/403415171" target="_blank"><img src="images/nologo.gif"></a></td>
                    </tr>
                </table>
          </div>
          <div class="classmate">
                <img src="images/txl_logo.gif">
                <div class="classmatext">
                   <span>留言信息 | 关于我们 | 友情链接 | 广告宣传 | 网络书库 </span><br />
                   <span>幽&nbsp;蓝&nbsp;&nbsp;制作,建议您用1024*768浏览本站<a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437">QQ:403415171</a>（幽蓝）</span><br />
                   <span>Copyright 2014 www.class_1211.com All Rights Reserved </span><br />
                   <span>ICP备案号：鄂ICP备14031820号</span><br />
                </div>
          </div>
        </div>
    </div>
</body>
</html>