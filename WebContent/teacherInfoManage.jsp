<%-- 
    Document   : teacherInfoManage
    Created on : 2019-7-16, 16:25:39
    Author     : gyt
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师信息管理</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	function deleteTeacher(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].No);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("teacherDelete",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].gradeName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}

	function searchTeacher(){
		$('#dg').datagrid('load',{
			Name:$('#s_Name').val(),
                        No:$('#s_id').val()
                        
		});
	}
	
	
	function openTeacherAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加教师信息");
		url="teacherSave";
	}
	
	function saveTeacher(){
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
	
	function resetValue(){
		$("#Name").val("");
		$("#ID").val("");
                $("#Password").val("");
	}
	
	function closeTeacherDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openTeacherModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑教师信息");
		$("#fm").form("load",row);
		url="teacherSave?No="+row.No;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="教师信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="TeacherList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
                                <th field="No" width="50">编号</th>
				<th field="ID" width="50">教师工号</th>
				<th field="Name" width="100">教师姓名</th>
				<th field="Password" width="250">密码</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openTeacherAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openTeacherModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteTeacher()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>&nbsp;工号：&nbsp;<input type="text" name="s_id" id="s_id" size="10"/>
		&nbsp;姓名：&nbsp;<input type="text" name="s_Name" id="s_Name" size="10"/>
		
		<a href="javascript:searchTeacher()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 400px;height: 280px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table>
				<tr>
					<td>教师工号：</td>
					<td><input type="text" name="ID" id="ID" class="easyui-validatebox" required="true"/></td>
				</tr>
                                 <tr>
					<td>教师姓名：</td>
					<td><input type="text" name="Name" id="Name" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>密码：</td>
                                        <td><input type="text" name="Password" id="Password" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveTeacher()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeTeacherDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>
