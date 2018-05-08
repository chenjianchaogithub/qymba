/**
 * 日志管理初始化
 */
var Role = {
    id: '#roleTable',	//表格id
    ajaxType: 'POST',		//查询类型
    url: '/role/ajax.html'
};

/**
 * 初始化表格的列
 */
Role.initColumn = function () {
    return [	//行数据
        { "data": "id" ,"orderable":false ,"width":"40px", "className": "center"},
        { "data": "grouping" ,"width":"100px"},
        { "data": "name" ,"width":"150px" },
        { "data": "state","width":"150px" },
        { "data": "description" },
        {
            "data": null,
            "className": "td-manage",
            "width":"100px"
        }
    ];
};

/*
* 按钮控制
* */
Role.columnDefs = function () {
    return [{
        "targets": 5, //列的样式名
        "orderable": false, //包含上样式名‘nosort'的禁止排序
        "render": function (data, type, row, meta) {
            return '<a style="text-decoration:none" onClick="admin_stop(this,\'10001\')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>'
                +' <a title="编辑" href="javascript:;"  onclick="admin_edit(\'管理员编辑\',\'user_add_edit\',\'800\',\'500\','+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>'
                +'<a title="删除" href="javascript:;" onclick="admin_del(this,\'1\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>'
        }
    }];
};

/**
 * 检查是否选中
 */
/*Role.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Role.seItem = selected[0];
        return true;
    }
};*/

/**
 * 查看日志详情
 */
/*Role.detail = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/role/detail/" + this.seItem.id, function (data) {
            Feng.infoDetail("日志详情", data.regularMessage);
        }, function (data) {
            Feng.error("获取详情失败!");
        });
        ajax.start();
    }
};*/


/**
 * 清空日志
 */
/*Role.delRole = function () {
    Feng.confirm("是否清空所有日志?",function(){
        var ajax = Feng.baseAjax("/role/delRole","清空日志");
        ajax.start();
        Role.table.refresh();
    });
}*/

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
Role.formParams = function() {
    var queryData = {	//搜索条件
        "retryType":'1',
        "departmentCode":'2',
        "projectCode":3,
        "serviceName":4,
        "csrfmiddlewaretoken":'5'
    };
    return queryData;
}

/**
 * 查询日志列表
 */
/*Role.search = function () {
    Role.table.refresh({query: Role.formParams()});
};*/


