<%@ page language="java"
	import="java.util.*,com.clps.entity.*,java.lang.Integer"
	pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	Cart cart = new Cart();
	if (session.getAttribute("Cart") != null) {
		cart = (Cart) session.getAttribute("Cart");
	}
	Map<String, Item> map = cart.getCartmap();
%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#flushButton").click(
				function() {
					$.ajax({
						url : "flushqtyAction",
						type : "GET",
						dataType : "json",
						success : function(data) {
							if (data == "true") {
								alert("库存更新成功！");
								location.href = "cart/Cart.jsp";

							} else {
								alert("请先给购物车添加东西！");
							}

						}
					});
				});

		$(".textview").bind(
				{
					focus : function() {
						console.log($(this).parent().parent().children()
								.children().first().html());
						console.log($(this).val());
					},
					blur : function() {

						var itemid = $(this).parent().parent().children()
								.children().first().html();

						var count = $(this).val();
						var reg = /^\+?[1-9][0-9]*$/;

						if (reg.test(count)) {
							$.ajax({
								url : "saveCountAction",
								data : {
									"item.itemid" : itemid,
									"count" : count
								},
								type : "GET",
								dataType : "json",
								success : function(data) {
									if (data == "true") {
										location.href = "cart/Cart.jsp";

									} else {
										alert("数量不够了！");
										location.href = "cart/Cart.jsp";
									}

								}
							});
						} else {
							alert("请输入正整数！");
							location.href = "cart/Cart.jsp";

						}

					}
				});

		$(".textviewtwo").bind(
				{
					focus : function() {
						console.log($(this).parent().parent().children()
								.children().first().html());
						console.log($(this).val());
					},
					blur : function() {
						var param = "item.itemid="
								+ $(this).parent().parent().children()
										.children().first().html()
								+ "&item.count="
								+ $(this).val()
								+ "&signon.userid="
								+ "${userid }"
								+ "&item.listprice="
								+ $(this).parent().parent().children().eq(5)
										.html();
						console.log(param);
						$.ajax({
							url : "saveCountAction.action",
							data : param,
							type : "GET",
							dataType : "json",
							success : function(data) {
								console.log(data.sumPrice);
								//$(this).parent().parent().children().eq(6).html(data.sumPrice);
							},
							error : function() {

							}
						})

						var price = $(this).parent().parent().children().eq(5)
								.html();
						var sumprice = $(this).parent().parent().children().eq(
								6).html();
						var count = $(this).val();
						$(this).parent().parent().children().eq(6).html(
								price * count);

					}

				});

		$(".btnTwo").click(
				function() {
					alert($(this).parent().parent().children().children()
							.first().html());
					location.href = "deleteShoppingAction?signon.userid="
							+ "${userid }"
							+ "&item.itemid="
							+ $(this).parent().parent().children().children()
									.first().html();
				});

		$(".btnOne").click(
				function() {

					location.href = "deleteShoppingAction?itemid="
							+ $(this).parent().parent().children().children()
									.first().html() + "&signon.userid=0";

				});

		var sum = 0;
		$(".sumprice").each(
				function() {
					var price = $(this).parent().parent().children().eq(5)
							.html();
					var count = $(this).parent().parent().children().eq(4)
							.children().val();
					$(this).html(price * count);
				})

		$(".sumpriceTwo").each(
				function() {
					var price = $(this).parent().parent().children().eq(5)
							.html();
					var sumprice = $(this).parent().parent().children().eq(6)
							.html();
					var count = $(this).parent().parent().children().eq(4)
							.children().val();
					$(this).html(price * count);
					var countPirce = parseInt($(this).html());

					sum = sum + countPirce;

				})
		/* 	$("#maxprice").html(sum); */

		$(".textviewtwo").parent().parent().children().find("a").click(
				function() {
					if ($(this).html() != "取消") {
						location.href = "queryQtyAction?item.itemid="
								+ $(this).html();
					}
				});
		$(".itemsnews").click(function() {
			location.href = "queryQtyAction?item.itemid=" + $(this).html();
		});
		$("#buy").click(function() {

			if ("${userid }" == "") {
				alert("您还没登陆！请登录后再购买！");
				location.href = "account/SignonForm.jsp";
			} else if (
<%=cart.getIsflag()%>
	<= 0) {
				alert("购物车为空！请先去买点东西吧！");
			} else if (
<%=cart.getTotalPrice()%>
	<= 0) {
				alert("数量不能为0！");
			} else {
				/* location.href = "queryAccountAction?userid=" + "${userid }"; */
				location.href = "checkoutAction?userid=" + "${userid }";
			}
		})

		if ("${profile.mylistopt}" == 0) {
			$("#MyList").css("display", "none");

		}

	});
</script>
<div id="Catalog">

	<div id="BackLink">
		<a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
	</div>
	<div id="Cart">
		<h2>购物车</h2>
		<form method="post">
			<table id="shopping" align="center">
				<tr>
					<th><b>商品编号</b></th>
					<th><b>产品编号</b></th>
					<th><b>产品描述</b></th>
					<th><b>库存</b></th>
					<th><b>产品数量</b></th>
					<th><b>定价</b></th>
					<th><b>总价</b></th>
					<th>&nbsp;</th>
				</tr>
				<%
					if (cart == null) {
				%>
				<tr>
					<td colspan="8"><b>你的购物车是空的.</b></td>
				</tr>
				<%
					} else {

						if (map == null || map.isEmpty()) {
				%>
				<tr>
					<td colspan="8"><b>你的购物车是空的.</b></td>
				</tr>
				<%
					} else {
				%>
				<%
					for (Map.Entry<String, Item> entry : map.entrySet()) {
				%>

				<tr>
					<td><a class="itemsnews" href="javascript:void(0)"><%=entry.getValue().getItemid()%></a></td>
					<td><%=entry.getValue().getProductid()%></td>
					<td><%=entry.getValue().getAttr1()%></td>
					<td><%=entry.getValue().getQty()%></td>
					<td><input type="text" class="textview" name="inStock"
						size="5" value="<%=entry.getValue().getCount()%>"></td>
					<td><%=entry.getValue().getListprice()%></td>
					<td>$<span class="sumpriceTwo"></span></td>
					<td><a class="btnOne" href="javascript:void(0)"> 取消</a></td>
				</tr>

				<%
					}

						}
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
 %><input type="submit" name="update" value="更新库存" class="Button" id="flushButton"/>

					</td>
					<td>&nbsp;</td>
				</tr>
			</table>

		</form>

		<a class="Button" id="buy" href="javascript:void(0)">付款</a>


	</div>
	<div id="MyList" style="margin-top: 10px;">
		<%@ include file="IncludeMyList.jsp"%>
	</div>
	<div id="Separator">&nbsp;</div>

</div>
<%@ include file="../common/IncludeBottom.jsp"%>