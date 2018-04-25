/**
 * 角色管理的单例
 */
var Dept = {
    id: "deptTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Dept.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '部门名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '17%'},
        {title: '状态', field: 'state', align: 'center', valign: 'middle', sortable: true}]
    return columns;
};


/**
 * 检查是否选中
 */
Dept.check = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Dept.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加菜单
 */
Dept.openAddDept = function () {
    var index = layer.open({
        type: 2,
        title: '添加菜单',
        area: ['830px', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dept/dept_add'
    });
    this.layerIndex = index;
};

/**
 * 点击修改
 */
Dept.openChangeDept = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '修改菜单',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dept/dept_edit/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Dept.delDept = function () {
    if (this.check()) {

        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/dept/remove", function (data) {
                Feng.success("删除成功!");
                Dept.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deptId", Dept.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否刪除该菜单?", operation);
    }
};

/**
 * 搜索
 */
Dept.search = function () {
    var queryData = {};

    queryData['deptName'] = $("#deptName").val();
    queryData['level'] = $("#level").val();

    Dept.table.refresh({query: queryData});
}


