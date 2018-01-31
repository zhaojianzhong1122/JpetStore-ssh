<%@ include file="../common/IncludeTop.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
var flagpassword = "false";
var flaginput = "false";
var flaguserid = "false";
$(function() {
		$("#accountTwoTable input").blur(function() {

			if ($(this).val() == "") {
				$("#inputmsg").css("display", "inline");
				$("#inputmsg").html("带*号的输入框不能为空");
				$("#inputmsg").css("color", "red");
			} else {
				$("#inputmsg").css("display", "none");
				flaginput == "true";
			}

		});
		$("#accountTable input:first").bind({
			focus : function() {

				$("#userid").css("display", "inline");
				$("#userid").html("输入用户名");
			},
			blur : function() {

				if ($(this).val() == "") {
					$("#userid").html("用户名不能为空");
					$("#userid").css("color", "red");
				} else {
					$("#userid").css("display", "none");
					var param = $(this).val();
					$.ajax({
						url : "newuserAction",
						data : {
							"userid" : param
						},
						dataType : "json",
						type : "post",
						success : function(data) {
							if (data != "true") {
								$("#userid").css("display", "inline");
								$("#userid").html("用户名已经注册了！");
								$("#userid").css("color", "red");
							} else {
								$("#userid").css("display", "inline");
								$("#userid").html("用户名可用！");
								$("#userid").css("color", "green");
								flaguserid = "true";
							}
						},
						error : function() {
						}
					});
				}

			}
		})

		$("#accountSubmit").click(function() {
			var userid = $("#accountTable input:first").val();
			var password = $("#accountTable input:eq(0)").val();

		});
		$("#accountTable input:eq(1)").bind({
			focus : function() {

				$("#password").css("display", "inline");
				$("#password").html("输入密码");
			},
			blur : function() {

				if ($(this).val() == "") {
					$("#password").html("密码不能为空");
					$("#password").css("color", "red");
				} else {
					$("#password").css("display", "none");
				}
			}

		})
		$("#accountTable input:eq(2)").bind(
				{
					focus : function() {

						$("#passwordcommit").css("display", "inline");
						$("#passwordcommit").html("请重复密码");
					},
					blur : function() {

						if ($(this).val() == "") {
							$("#passwordcommit").html("密码不能为空");
							$("#passwordcommit").css("color", "red");
						} else if ($("#accountTable input:eq(1)").val() != $(
								"#accountTable input:eq(2)").val()) {
							$("#passwordcommit").html("密码不一样，请重新输入");
							$("#passwordcommit").css("color", "red");
						} else {
							$("#passwordcommit").css("display", "none");
							flagpassword = "true";
						}
					}

				});

	});
	function check() {
		if (flaginput == "true" && flagpassword == "true"
				&& flaguserid == "true") {
			alert("注册成功");
			return true;
		} else {
			alert("请检查填写是否符合要求！");
			return false;
		}
	};
</script>
<div id="Catalog">

	<form action="insertAction" method="post" onsubmit="return check()">



		<h3>账户信息</h3>

		<table id="accountTable">
			<tr>
				<td>账户:</td>
				<td><input type="text" id="user_id" name="signon.username" /></td>
				<td><span id="userid"></span></td>
			</tr>
			<tr>
				<td>新密码:</td>
				<td><input type="password" id="pass_word"
					name="signon.password" /></td>
				<td><span id="password"></span></td>
			</tr>
			<tr>
				<td>重复密码:</td>
				<td><input type="password" /></td>
				<td><span id="passwordcommit"></span></td>
			</tr>
		</table>

		<%@ include file="IncludeAccountFields.jsp"%>

		<input type="submit" id="accountSubmit" name="submit" value="创建账户"
			class="Button" />

	</form>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>