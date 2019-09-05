/**

 @Name：yuejianManageSystem
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL

 */


layui.define(['table', 'form'], function (exports) {
    var $ = layui.$
        , table = layui.table
        , form = layui.form
        , ContextPath = layui.setter.ContextPath
        , admin = layui.admin;

    //教练课程
    table.render({
        elem: '#LAY-club-notify-manage'
        , url: ContextPath + '/notify/getList' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'center'}
            , {field: 'jId', width: 80, title: 'ID', sort: true, align: 'center'}
            , {field: 'name', title: '教练名称', width: 150, align: 'center'}
            , {field: 'sex', title: '性别', sort: true, width: 100, align: 'center'}
            , {field: 'phone', title: '电话', align: 'center'}
            , {field: 'email', title: '邮箱', align: 'center'}
            , {field: 'aName', title: '审核人', width: 150, sort: true, align: 'center'}
            , {field: 'checktime', title: '审核时间', sort: true, align: 'center'}
            , {title: '标记', width: 200, align: 'center', fixed: 'right', toolbar: '#table-notify-webuser'}
        ]]
        , page: false
        , height: 'full-220'
        , text: {none: '一条数据也没有^_^'}
    });

    //监听工具条
    table.on('tool(LAY-club-notify-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            var d = {
                jId: data.jId
            };
            var url = layui.setter.ContextPath + '/notify/delete';
            admin.req({
                type: 'get'
                , url: url
                , data: d
                , done: function (res) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    // layer.msg("审核成功", {icon: 1});
                }
            });
        }
    });


    exports('notify', {})
});