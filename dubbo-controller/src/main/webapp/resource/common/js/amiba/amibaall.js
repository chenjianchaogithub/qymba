/**
 * 角色管理的单例
 */
var Amiba = {
    id: "amibaTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Amiba.initColumn = function () {
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
Amiba.check = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Amiba.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加菜单
 */
Amiba.openAddAmiba = function () {
    var index = layer.open({
        type: 2,
        title: '添加菜单',
        area: ['830px', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/amiba/amiba_add'
    });
    this.layerIndex = index;
};

/**
 * 点击修改
 */
Amiba.openChangeAmiba = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '修改菜单',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/amiba/amiba_edit/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Amiba.delAmiba = function () {
    if (this.check()) {

        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/amiba/remove", function (data) {
                Feng.success("删除成功!");
                Amiba.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("amibaId", Amiba.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否刪除该菜单?", operation);
    }
};

/**
 * 搜索
 */
Amiba.search = function () {
    var queryData = {};

    queryData['amibaName'] = $("#amibaName").val();
    queryData['level'] = $("#level").val();

    Amiba.table.refresh({query: queryData});
}


