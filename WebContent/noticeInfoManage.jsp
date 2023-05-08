<%-- 
    Document   : noticeInfoManage
    Created on : 2019-7-19, 17:46:45
    Author     : X
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告信息管理</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	
	
	
	function openNoticeAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加公告信息");
		url="noticeSave";
	}
	
	
	function closeNoticeDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function resetValue(){
		$("#Title").val("");
                $("#Content").val("");
                $("#Time").val("");
	}
	
	
	function saveNotice(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="公告信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="noticeList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				
                                <th field="ID" width="50">ID</th>
				<th field="Title" width="100">标题</th>
				<th field="Content" width="250">内容</th>
                                <th field="Time" width="250">发布时间</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openNoticeAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			
		</div>
		
	
	<div id="dlg" class="easyui-dialog" style="width: 400px;height: 280px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table>

				<tr>
					<td valign="top">标题：</td>
					<td><input type="text" name="Title" id="Title" class="easyui-validatebox" required="true"/></td> </tr>
                                <tr>         <td valign="top">内容：</td>
                                    <td><textarea rows="7" cols="30" name="Content" id="Content"></textarea></td> </tr>
                                 <tr>       <td valign="top">时间：</td>
					<td><input type="text" name="Time" id="Time" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveNotice()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeNoticeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
