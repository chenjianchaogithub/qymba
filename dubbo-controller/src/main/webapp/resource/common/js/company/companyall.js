/**
 * 角色管理的单例
 */
var Company = {
    id: "companyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Company.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '机构名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '17%'},
        /*{title: '菜单编号', field: 'code', align: 'center', valign: 'middle', sortable: true, width: '12%'},
        {title: '菜单父编号', field: 'parentid', align: 'center', valign: 'middle', sortable: true},*/
        {title: '独立结算', field: 'isdobalance', align: 'center', valign: 'middle', sortable: true, width: '15%'},
        {title: '可抵扣税金', field: 'isdotax', align: 'center', valign: 'middle', sortable: true},
        {title: '最高可抵税金(%)', field: 'maxtaxrate', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'state', align: 'center', valign: 'middle', sortable: true}]
    return columns;
};


/**
 * 检查是否选中
 */
Company.check = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Company.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加菜单
 */
Company.openAddCompany = function () {
    var index = layer.open({
        type: 2,
        title: '添加菜单',
        area: ['830px', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/company/company_add'
    });
    this.layerIndex = index;
};

/**
 * 点击修改
 */
Company.openChangeCompany = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '修改菜单',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/company/company_edit/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Company.delCompany = function () {
    if (this.check()) {

        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/company/remove", function (data) {
                Feng.success("删除成功!");
                Company.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("companyId", Company.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否刪除该菜单?", operation);
    }
};

/**
 * 搜索
 */
Company.search = function () {
    var queryData = {};

    queryData['companyName'] = $("#companyName").val();
    queryData['level'] = $("#level").val();

    Company.table.refresh({query: queryData});
}


