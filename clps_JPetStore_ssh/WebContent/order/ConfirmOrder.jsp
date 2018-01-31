<%@ include file="../common/IncludeTop.jsp"%>
<%@ page language="java" import="java.util.*,com.clps.entity.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function sure(){
	  if(confirm("您确定要提交表单吗？")){
	alert("提交成功");
	  }
	  else{
	return false;
	  }
	 }
</script>
<div id="Catalog">

	<div id="BackLink">
		<a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
	</div>

	请确认以下信息，然后按"继续"...

	<table>
		<tr>
			<th align="center" colspan="2"><font size="4"><b>订单</b></font> <br />
				<font size="3"><b><s:property value="ordertime" /></b></font></th>
		</tr>

		<tr>
			<th colspan="2">账单地址</th>
		</tr>

		<tr>
			<td>姓名:</td>
			<td><s:property value="account.firstname" /></td>
		</tr>
		<tr>
			<td>地址 1:</td>
			<td><s:property value="account.addr1" /></td>
		</tr>
		<tr>
			<td>地址 2:</td>
			<td><s:property value="account.addr1" /></td>
		</tr>
		<tr>
			<td>城市:</td>
			<td><s:property value="account.city" /></td>
		</tr>
		<tr>
			<td>州 、邦:</td>
			<td><s:property value="account.state" /></td>
		</tr>
		<tr>
			<td>邮政编号:</td>
			<td><s:property value="account.zip" /></td>
		</tr>
		<tr>
			<td>国家:</td>
			<td><s:property value="account.country" /></td>
		</tr>
		<tr>
			<th colspan="2">寄运地址</th>
		</tr>
		<tr>
			<td>姓名:</td>
			<td><s:property value="account.firstname" /></td>
		</tr>
		<tr>
			<td>姓:</td>
			<td><s:property value="account.firstname" /></td>
		</tr>
		<tr>
			<td>地址1:</td>
			<td><s:property value="account.addr1" /></td>
		</tr>
		<tr>
			<td>地址 2:</td>
			<td><s:property value="account.addr1" /></td>
		</tr>
		<tr>
			<td>城市:</td>
			<td><s:property value="account.city" /></td>
		</tr>
		<tr>
			<td>州、邦:</td>
			<td><s:property value="account.state" /></td>
		</tr>
		<tr>
			<td>邮政编码:</td>
			<td><s:property value="account.zip" /></td>
		</tr>
		<tr>
			<td>国家:</td>
			<td><s:property value="account.country" /></td>
		</tr>

	</table>
	<form action="saveOrderAction?signon.userid=${userid }" method="post"  onsubmit="return sure()">
		<input id="subbtn" type="submit" value="确认">
	</form>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>





