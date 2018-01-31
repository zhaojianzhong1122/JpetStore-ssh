<%@ include file="../common/IncludeTop.jsp"%>
<%@ page language="java" import="java.util.*,com.clps.entity.*"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	/* $(function() {

		$("#go").click(
				function() {

					location.href = "queryAccountTwoAction?userid="
							+ "${userid }";
				})
	}) */
</script>
<div id="Catalog">

	<form action="queryAccountTwoAction" method="post">

		<table>
			<tr>
				<th colspan=2>付款详情</th>
			</tr>
			<tr>
				<td>付款方式:</td>
				<td><select name="cardtype">
						<option value="维萨信用卡">维萨信用卡</option>
						<option value="万事达信用卡">万事达信用卡</option>
						<option value="美国运通信用卡">美国运通信用卡</option>
				</select></td>
			</tr>
			<tr>
				<td>信用卡号码:</td>
				<td><input type="text" value="9999 9999 9999"
					name="creditcard" /></td>
			</tr>
			<tr>
				<td>终止日期 (MM/YYYY):</td>
				<td><input type="text" value="12/03" name="exprdate" /></td>
			</tr>
			<tr>
				<th colspan=2>账单地址</th>
			</tr>

			<tr>
				<td>姓名:</td>
				<td><input type="text"
					value="<s:property value="account.firstname"/>"
					name="account.firstname" /></td>
			</tr>
			<tr>
				<td>地址1:</td>
				<td><input type="text" size="40"
					value="<s:property value="account.addr1"/>" name="account.addr1" /></td>
			</tr>
			<tr>
				<td>地址2:</td>
				<td><input type="text" size="40" value="" name="account.addr2" /></td>
			</tr>
			<tr>
				<td>城市:</td>
				<td><input type="text" size="10"
					value="<s:property value="account.city" />" name="account.city" /></td>
			</tr>
			<tr>
				<td>区、县:</td>
				<td><input type="text" size="4"
					value="<s:property value="account.state"/>" name="account.state" /></td>
			</tr>
			<tr>
				<td>邮政编码:</td>
				<td><input type="text" size="10"
					value="<s:property value="account.zip"/>" name="account.zip" /></td>
			</tr>
			<tr>
				<td>国籍:</td>
				<td><input type="text" size="15"
					value="<s:property value="account.country"/> "
					name="account.country" /></td>
			</tr>

		</table>

		<input type="submit" id="go" name="submit" value="继续">

	</form>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>