/**

 @Name：layuiAdmin 用户管理 管理员管理 角色管理
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
        elem: '#LAY-club-recommend-manage'
        , url: ContextPath + '/recommend/getList' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'center'}
            , {field: 'jId', width: 80, title: 'ID', sort: true, align: 'center'}
            , {field: 'name', title: '教练名称', width: 150, align: 'center'}
            , {field: 'pic', width: 120, title: '头像', width: 120, templet: '#imgTpl', align: 'center'}
            , {field: 'sex', title: '性别', sort: true, width: 100, align: 'center'}
            , {field: 'phone', title: '电话', width: 120, align: 'center'}
            , {field: 'email', title: '邮箱', width: 200, align: 'center'}
            , {field: 'intro', title: '简介', align: 'center'}
            , {field: 'cName', title: '所属俱乐部', width: 150, sort: true, align: 'center'}
            , {title: '审核', width: 200, align: 'center', fixed: 'right', toolbar: '#table-recommend-webuser'}
        ]]
        , page: false
        , height: 'full-220'
        , text: {none: '一条数据也没有^_^'}
    });

    //监听工具条
    table.on('tool(LAY-club-recommend-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'recommend') {
            var d = {
                jId: data.jId
            };
            var url = layui.setter.ContextPath + '/recommend/updateState';
            admin.req({
                type: 'get'
                , url: url
                , data: d
                , done: function (res) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.msg("审核成功", {icon: 1});
                }
            });
        }
    });


    exports('recommend', {})
});