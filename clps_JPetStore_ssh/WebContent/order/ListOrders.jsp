<%@ include file="../common/IncludeTop.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#order a").click(
				function() {

					location.href = "queryOrders?userid=" + "${userid }"
							+ "&orderid=" + $(this).html();

				})
	})
</script>
<div id="Catalog">
	<h2>我的订单</h2>

	<table id="order">
		<tr>
			<th>订单编号</th>
			<th>日期</th>
			<th>总金额</th>
		</tr>
		<s:iterator value="pageUtil.list" var="orders">
			<tr>

				<td><a href="javascript:void(0)"><s:property
							value="#orders.orderid" /></a></td>
				<td><s:property value="#orders.orderdate" /></td>
				<td><s:property value="#orders.totalprice" /></td>

			</tr>

		</s:iterator>
		<tr>
			<td><c:choose>
					<c:when test="${pageBean.page==1 }">
						<span>上一页</span>
					</c:when>
					<c:otherwise>
						<a class="Button"
							href="categoryAction?pageBean.page=${pageBean.page-1 }&pageBean.limit=2&category.catid=<s:property value="category.catid"/>">
							上一页 </a>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${pageBean.page == PageUtil.totalPage}">
						<span>下一页</span>
					</c:when>
					<c:otherwise>
                        &nbsp;&nbsp;
                <a class="Button"
							href="categoryAction?pageBean.page=${pageBean.page+1 }&pageBean.limit=2&category.catid=<s:property value="category.catid"/>">下一页</a>
                &nbsp;&nbsp;
                    </c:otherwise>
				</c:choose></td>
			<td><span>当前是第${pageUtil.currPage }页</span> <span></td><td> 第 <select
					id="pageSelect">
						<c:forEach begin="1" end="${pageUtil.totalPage }" var="page">
							<c:choose>
								<c:when test="${page==pageUtil.currPage }">
									<option selected="selected" value=${pp }>${page }</option>
								</c:when>
								<c:otherwise>
									<option value=${page }>${page }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select> 页
			</span></td>
		</tr>
	</table>


</div>
<%@ include file="../common/IncludeBottom.jsp"%>