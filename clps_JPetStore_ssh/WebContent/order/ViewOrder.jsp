<%@ include file="../common/IncludeTop.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		var sum = 0;
		$(".sumprice").each(function() {
			var price = $(this).parent().parent().children().eq(3).html();
			var count = $(this).parent().parent().children().eq(2).html();
			$(this).html(price * count);
			var countPirce = parseInt($(this).html());
			sum = sum + countPirce;
		})

		$("#maxprice").html(sum);
		$(".itemsnews").click(function() {
			location.href = "queryQtyAction?item.itemid=" + $(this).html();
		});

	});
</script>


<div id="Catalog">
	<div id="BackLink">
		<a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
	</div>
	<table>
		<tr>
			<th align="center" colspan="2">订单号<s:property
					value="orders.orderid" /> <s:property value="orders.orderdate" />
			</th>
		</tr>
		<tr>
			<th colspan="2">付款详情</th>
		</tr>
		<tr>
			<td>信用卡类型:</td>
			<td><s:property value="orders.cardtype" /></td>
		</tr>
		<tr>
			<td>信用卡号码:</td>
			<td><s:property value="orders.creditcard" /></td>
		</tr>
		<tr>
			<td>有效日期 (MM/YYYY):</td>
			<td><s:property value="orders.exprdate" /></td>
		</tr>
		<tr>
			<th colspan="2">账单地址</th>
		</tr>
		<tr>
			<td>姓名:</td>
			<td><s:property value="orders.billtofirstname" /></td>
		</tr>

		<tr>
			<td>地址 1:</td>
			<td><s:property value="orders.shipaddr1" /></td>
		</tr>
		<tr>
			<td>地址 2:</td>
			<td><s:property value="orders.shipaddr2" /></td>
		</tr>
		<tr>
			<td>城市:</td>
			<td><s:property value="orders.shipcity" /></td>
		</tr>
		<tr>
			<td>区、县:</td>
			<td><s:property value="orders.shipstate" /></td>
		</tr>
		<tr>
			<td>邮政编码:</td>
			<td><s:property value="orders.shipzip" /></td>
		</tr>
		<tr>
			<td>国籍:</td>
			<td><s:property value="orders.shipcountry" /></td>
		</tr>
		<tr>
			<th colspan="2">收货地址</th>
		</tr>
		<tr>
			<td>姓名:</td>
			<td><s:property value="orders.shiptofirstname" /></td>
		</tr>
		<tr>
			<td>地址1:</td>
			<td><s:property value="orders.shipaddr1" /></td>
		</tr>
		<tr>
			<td>地址2:</td>
			<td><s:property value="orders.shipaddr1" /></td>
		</tr>
		<tr>
			<td>城市:</td>
			<td><s:property value="orders.shipcity" /></td>
		</tr>
		<tr>
			<td>区、县:</td>
			<td><s:property value="orders.shipstate" /></td>
		</tr>
		<tr>
			<td>邮政编码:</td>
			<td><s:property value="orders.shipzip" /></td>
		</tr>
		<tr>
			<td>国籍:</td>
			<td><s:property value="orders.shipcountry" /></td>
		</tr>
		<tr>
			<td>邮政公司:</td>
			<td><s:property value="orders.courier" /></td>
		</tr>
		<tr>
			<td colspan="2">状态:已付款</td>
		</tr>
		<tr>
			<td colspan="2">
				<table>
					<tr>
						<th>商品编号</th>
						<th>产品描述</th>
						<th>数量</th>
						<th>价格</th>
						<th>总金额</th>
					</tr>

					<c:forEach items="${ordercart.cartmap}" var="orders">
						<tr>
							<td><a class="itemsnews" href="javascript:void(0)">${orders.value.itemid}</td>
							<td>${orders.value.attr1}</td>
							<td>${orders.value.count}</td>
							<td>${orders.value.listprice}</td>
							<td>$<span class="sumprice"></span></td>
						</tr>
					</c:forEach>
					<tr>
						<th colspan="5">总金额: $ <s:property value="orders.totalprice" />
						</th>
					</tr>
				</table>
			</td>
		</tr>

	</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>



