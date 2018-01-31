<%@ page language="java" import="java.util.*,com.clps.entity.*"
	pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>


<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".sumprice").each(function() {
			var price = $(this).parent().parent().children().eq(4).html();
			var count = $(this).parent().parent().children().eq(5).html();
			$(this).html(price * count);
		})
		$("#continue").click(function() {

			location.href = "queryAccountAction?userid=" + "${userid }";

		});
	$(".itemsnews").click(function(){
		location.href = "queryQtyAction?item.itemid="+ $(this).html();});
	})
</script>
<div id="Catalog">
	<div id="BackLink">
		<a href="<%=basePath%>/cart/Cart.jsp">返回到购物车</a>
	</div>

	<table>
		<tr>
			<td>
				<h2>核对信息</h2>

				<table>

					<tr>
						<td><b>商品编号</b></td>
						<td><b>产品编号</b></td>
						<td><b>产品描述</b></td>
						<td><b>库存</b></td>
						<td><b>产品数量</b></td>
						<td><b>单价</b></td>
						<td><b>总价</b></td>
					</tr>
					<%
						Cart cart = (Cart) session.getAttribute("Cart");
						Map<String,Item> map=cart.getCartmap();
						for (Map.Entry<String, Item> entry : map.entrySet()) {
					%>

					<tr>
						<td><a target="_blank" class="itemsnews" href="javascript:void(0)" target="_blank"><%=entry.getValue().getItemid()%></a></td>
						<td><%=entry.getValue().getProductid()%></td>
						<td><%=entry.getValue().getAttr1()%></td>
						<td><%=entry.getValue().getQty()%></td>
						<td style="text-align:center"><%=entry.getValue().getCount()%></td>
						<td><%=entry.getValue().getListprice()%></td>
						<td>$<span class="sumprice"></span></td>
					</tr>
					<%
						}
					%>
					<tr>
					<td colspan="7">总金额:$ <%
						if (cart == null) {
							cart = new Cart();
						}
						if (cart.getTotalPrice().equals(0) || cart.getTotalPrice() == null) {
					%>0.00<%
						} else {
					%><%=cart.getTotalPrice()%> <%
 	}
 %>
					</td>
					<td>&nbsp;</td>
				</tr>
				</table><a
				class="Button" id="continue" href="javascript:void(0)">继续</a>
			</td>


		</tr>
	</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>





