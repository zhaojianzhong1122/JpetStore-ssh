<%@ page language="java" import="java.util.*,com.clps.entity.*"
	pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("table tr td a").click(
				function() {

					location.href = "queryItemAction?product.productid="
							+ $(this).html();
				});
		$("#pageSelect")
				.change(
						function() {
							location.href = "categoryAction?pageBean.page="
									+ $(this).val()
									+ "&pageBean.limit=2&category.catid=<s:property value="category.catid"/>";
						});

	});
</script>
<div id="Catalog">

	<div id="BackLink">

		<a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>

	</div>
	<h2>
		<s:property value="category.catid" />
	</h2>

	<table>
		<tr>
			<td>产品编号</td>
			<td>产品名称</td>
		</tr>
		<s:iterator value="pageUtil.list" var="product">
			<tr>
				<td><a><s:property value="#product.productid" /></a></td>
				<td><s:property value="#product.name" /></td>

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
			<td><span>当前是第${pageUtil.currPage }页</span> <span> 第 <select
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