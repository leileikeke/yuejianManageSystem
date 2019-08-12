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

    //俱乐部管理
    table.render({
        elem: '#LAY-club-back-manage'
        , url: ContextPath + '/club/getList' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'cId', width: 80, title: 'ID', sort: true, align: 'center'}
            , {field: 'name', width: 120, title: '俱乐部名', align: 'center'}
            , {field: 'pic', title: '宣传图', width: 100, templet: '#imgTpl', align: 'center'}
            , {field: 'phone', title: '电话', width:140, align: 'center'}
            , {field: 'jointime', title: '加入时间', sort: true, width: 140, align: 'center'}
            , {field: 'address', width:180, title: '地址', align: 'center'}
            , {field: 'intro', width:230, id:'intro',title: '简介', align: 'center'}
            , {field: 'hot', title: '热度', sort: true, width: 80, align: 'center'}
            , {field: 'aName', width: 120, title: '管理员名', align: 'center'}
            , {title: '操作', width: 200, align: 'center', fixed: 'right', toolbar: '#table-club-admin'}
        ]]
        , page: true
        , limit: 10
        , height: 'full-220'
        , text: {none: '一条数据也没有^_^'}
    });

    //监听工具条
    table.on('tool(LAY-club-back-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.prompt({
                formType: 1
                , title: '敏感操作，请验证口令'
            }, function (value, index) {
                layer.close(index);//如果设定了yes回调，需进行手工关闭
                if (value == layui.setter.Command) {
                    layer.confirm('确定删除此俱乐部吗？', function (index) {
                        $.ajax({
                            url: ContextPath + '/club/delete',
                            type: 'get',
                            data: {'cId': data.cId},//向服务端发送删除的sid
                            success: function (suc) {
                                if (suc.code == 200) {
                                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                    layer.msg("删除成功", {icon: 1});
                                } else {
                                    layer.msg("删除失败", {icon: 5});
                                }
                            }
                        });
                        layer.close(index);
                    });
                } else {
                    layer.msg("验证口令错误,操作失败");
                }

            });
        } else if (obj.event === 'edit') {
            var tr = $(obj.tr);

            layer.open({
                type: 2
                , title: '编辑俱乐部'
                , content: 'clubform.html'
                , area: ['455px', '545px']
                , anim: 4//弹出动画
                , maxmin: true//显示最大化最小化按钮
                , shadeClose: true//点击遮罩层关闭模态框
                , shade: 0.5//阴影
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'LAY-club-back-submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);

                    //监听提交
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                        var field = data.field; //获取提交的字段
                        var url = layui.setter.ContextPath + '/club/update';
                        admin.req({
                            type: 'post'
                            , url: url
                            , contentType: "application/json;charset=utf-8"
                            , data: JSON.stringify(field)
                            , done: function (res) {
                                layer.msg("更新成功", {icon: 6});
                                //提交 Ajax 成功后，静态更新表格中的数据
                                table.reload('LAY-club-back-manage'); //数据刷新
                                layer.close(index); //关闭弹层
                            }
                        });
                    });
                    submit.trigger('click');
                }
                , success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    body.find("input[name='cId']").val(data.cId);
                    body.find("input[name='name']").val(data.name);
                    body.find("input[name='aName']").val(data.aName);
                    body.find("input[name='phone']").val(data.phone);
                    body.find("input[name='address']").val(data.address);
                    body.find("input[name='pic']").val(data.pic);
                    body.find('#demo1').attr('src', ContextPath+data.pic);
                    body.find("textarea[name='intro']").val(data.intro);
                    setTimeout(function () {
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-close1', {
                            tips: 1
                        });
                    }, 300)
                }
            })
        } else if (obj.event === 'audit') {
            var d = {
                id: data.id,
                state: data.state
            };
            var url = layui.setter.ContextPath + '/admin/updateState';
            admin.req({
                type: 'get'
                , url: url
                , data: d
                , done: function (res) {
                    setTimeout(function () {
                        layer.tips(res.msg, obj.tr.selector + ' .state', {
                            tips: [4, '#1aa094']
                        });
                    }, 300)
                    if (d.state == false) {
                        obj.update({
                            state:true
                        });
                    } else {
                        obj.update({
                            state:false
                        });
                    }
                }
            });
        }
    });




    //俱乐部活动管理
    table.render({
        elem: '#LAY-club-activity-manage'
        , url: ContextPath + '/activity/getList' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'aId', width: 80, title: 'ID', sort: true, align: 'center'}
            , {field: 'name', width: 120, title: '活动名', align: 'center'}
            , {field: 'startTime', title: '开始时间', sort: true, width: 140, align: 'center'}
            , {field: 'endTime', title: '结束时间', sort: true, width: 140, align: 'center'}
            , {field: 'address', title: '活动地点', align: 'center'}
            , {field: 'pic', title: '宣传图', width: 80, templet: '#imgTpl', align: 'center'}
            , {field: 'price', width: 80, title: '价格', sort: true, align: 'center'}
            , {field: 'type', width: 80, title: '类型', align: 'center'}
            , {field: 'detail', id:'detail',title: '活动详情', align: 'center'}
            , {field: 'cName', id:'cName', width: 120,title: '所属俱乐部', align: 'center'}
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#table-activity-admin'}
        ]]
        , page: true
        , limit: 10
        , height: 'full-220'
        , text: {none: '一条数据也没有^_^'}
    });

    //监听工具条
    table.on('tool(LAY-club-activity-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.prompt({
                formType: 1
                , title: '敏感操作，请验证口令'
            }, function (value, index) {
                layer.close(index);//如果设定了yes回调，需进行手工关闭
                if (value == layui.setter.Command) {
                    layer.confirm('确定删除此活动吗？', function (index) {
                        $.ajax({
                            url: ContextPath + '/activity/delete',
                            type: 'get',
                            data: {'aId': data.aId,pic:data.pic},//向服务端发送删除的sid
                            success: function (suc) {
                                if (suc.code == 200) {
                                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                    layer.msg("删除成功", {icon: 1});
                                } else {
                                    layer.msg("删除失败", {icon: 5});
                                }
                            }
                        });
                        layer.close(index);
                    });
                } else {
                    layer.msg("验证口令错误,操作失败");
                }

            });
        } else if (obj.event === 'edit') {
            var tr = $(obj.tr);

            layer.open({
                type: 2
                , title: '编辑俱乐部活动'
                , content: 'activityform.html'
                , area: ['570px', '670px']
                , anim: 4//弹出动画
                , maxmin: true//显示最大化最小化按钮
                , shadeClose: true//点击遮罩层关闭模态框
                , shade: 0.5//阴影
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'LAY-club-activity-submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);

                    //监听提交
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                        var field = data.field; //获取提交的字段
                        var url = layui.setter.ContextPath + '/activity/update';
                        admin.req({
                            type: 'post'
                            , url: url
                            , contentType: "application/json;charset=utf-8"
                            , data: JSON.stringify(field)
                            , done: function (res) {
                                layer.msg("更新成功", {icon: 6});
                                //提交 Ajax 成功后，静态更新表格中的数据
                                table.reload('LAY-club-activity-manage'); //数据刷新
                                layer.close(index); //关闭弹层
                            }
                        });
                    });
                    submit.trigger('click');
                }
                , success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    body.find("input[name='aId']").val(data.aId);
                    body.find("input[name='name']").val(data.name);
                    body.find("input[name='pic']").val(data.pic);
                    body.find('#demo1').attr('src', ContextPath+data.pic);
                    body.find("input[name='price']").val(data.price);
                    body.find("input[name='type']").val(data.type);
                    body.find("textarea[name='address']").val(data.address);
                    body.find("textarea[name='detail']").val(data.detail);
                    body.find("input[name='startTime']").val(data.startTime);
                    body.find("input[name='endTime']").val(data.endTime);
                    setTimeout(function () {
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-close1', {
                            tips: 1
                        });
                    }, 300)
                }
            })
        }
    });


    exports('club', {})
});