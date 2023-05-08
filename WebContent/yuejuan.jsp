<%-- 
    Document   : yuejuan
    Created on : 2019-7-24, 14:31:21
    Author     : X
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>阅卷系统</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	
	function searchTi(){
		$('#dg').datagrid('load',{
			tId:$('#s_tId').val()
		});
	}
	
	
	
	
	function saveTi(){
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
					$.messager.alert("系统提示","批卷成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function resetValue(){
		$("#id").val("");
		$("#tId").val("");
		$("#answer").val("");
		
		$("#userId").val("");
		$("#mark").val("");
	}
	
	function closeTiDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openTiModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!==1){
			$.messager.alert("系统提示","请选择一条要批改的答案！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","输入分数");
		$("#fm").form("load",row);
		url="tiSave?id="+row.id;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="学生作答信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="tiList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="id" width="50" align="center">编号</th>
				<th field="tId" width="100" align="center">试卷号</th>
				<th field="userId" width="100" align="center">学生学号</th>
				<th field="mark" width="100" align="center">分数</th>
				
				<th field="answer" width="100" align="center">学生答案</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			
			<a href="javascript:openTiModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">批卷</a>
			
		</div>
		<div>&nbsp;试卷编号：&nbsp;<input type="text" name="s_tId" id="s_tId"/>
                    <a href="javascript:searchTi()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
	</div>
    
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>分数：</td>
					<td><input type="text" name="mark" id="mark" class="easyui-validatebox" required="true"/></td>
				
				</tr>
				
				<
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveTi()" class="easyui-linkbutton" iconCls="icon-ok">提交</a>
		<a href="javascript:closeTiDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>
