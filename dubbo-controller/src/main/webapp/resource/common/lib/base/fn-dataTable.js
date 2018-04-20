/**
 * 绑定页面元素组件
 */
(function ($) {

    /*************************************************************************
     * 列表组件扩展类，基于dataTable
     * in : tbList.list.js
     * last update : cjc 2018.3.14
     * @param options 初始化选项
     */
    $.fn.tbList = function(options) {
        var $this = $(this);

        var ajaxType = 'GET';
        if(options.ajaxType){
            ajaxType=options.ajaxType;
        }
        options.ajaxType = ajaxType;    //同步提交方式

        //有headUrl请求方式 获取表模板
        if(options.headUrl && options.headUrl.length>0){//判断头部模板是否从后台获取
            var headParams = options.headParams;
            $.ajax({
                type: ajaxType, //提交方式
                url: options.headUrl,   //连接地址
                cache: false, //禁用缓存
                async: false,
                data: headParams, //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    //封装返回数据头部数据
                    //TODO
                    var thead_tr = '<tr>';
                    console.log($this.find('thead').html());
                    $(result.thead).each(function(i,item){
                        thead_tr += '<th>'+item+'</th>';
                    });
                    thead_tr += '</tr>';
                    $this.find('thead').html(thead_tr);
                    /*********************************/
                    //组装数据读取字段
                    var columns_data = [];
                    $(result.columns).each(function(i,item){
                        columns_data.push(item)
                    });
                    options.columns = columns_data;
                }
            });
            if(options.url && options.url.length>0) return  $(this).fnList(options);
        }else if(options.url && options.url.length>0){//Url请求方式 获取内容数据
            return $(this).fnList(options);
        }
    }

    $.fn.fnList = function(options) {
        var _this = this;
        var $this = $(this);

        if (!this || $this.length==0) throw 'dataTable Id undefined';

        var searchParams = options.searchParams;

        //提示信息
        var lang = {
            "sProcessing": "处理中...",
            //"sLengthMenu": "每页 _MENU_ 项",
            "sLengthMenu": "",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
            "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页",
                "sJump": "跳转"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        };


        var opt = $.extend({
            language:lang, //提示信息
            autoWidth: false, //禁用自动调整列宽
            stripeClasses: ["odd", "even"], //为奇偶行加上样式，兼容不支持CSS伪类的场合
            processing: true, //隐藏加载提示,自行处理
            serverSide: true, //启用服务器端分页
            searching: false, //禁用原生搜索
            orderMulti: false, //启用多列排序
            order: [], //取消默认排序查询,否则复选框一列会出现小箭头
            renderer: "bootstrap", //渲染样式：Bootstrap和jquery-ui
            pagingType: "simple_numbers", //分页样式：simple,simple_numbers,full,full_numbers
            /*columnDefs: [{
                "targets": 'nosort', //列的样式名
                "orderable": false //包含上样式名‘nosort'的禁止排序
            }],*/
            ajax: function (data, callback, settings) {
                //封装请求参数
                var param = {};
                param.pageSize =data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.page = (data.start / data.length)+1;//当前页码

                //附加查询参数
                if(searchParams){
                    $.extend(param,searchParams); //给param扩展参数
                }
                console.log(searchParams);
                console.log(options.ajaxType);
                console.log(options.url);
                //ajax请求数据
                $.ajax({
                    type: options.ajaxType, //提交方式
                    //url: "/cmpp-manage/ajaxreport.html",
                    url: options.url,   //连接地址
                    cache: false, //禁用缓存
                    data: param, //传入组装的参数
                    dataType: "json",
                    success: function (result) {
                        //封装返回数据
                        var returnData = {};
                        //returnData.draw = 2;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.total;//返回数据全部记录
                        returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = result.rows;//返回的数据列表
                        console.log(returnData);
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    }
                });
            },
            //列表表头字段，格式：[{ "data": "字段名1" ,"orderable":false},{ "data": "字段名2" }]
            columns: []
        }, options || {});

        /**
         * 管理对象
         */
        this.dTable = $(this).dataTable(opt);
    }


})(jQuery);