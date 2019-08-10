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
        , url: ContextPath + '/club/clubList' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'cId', width: 80, title: 'ID', sort: true, align: 'center'}
            , {field: 'name', title: '俱乐部名', align: 'center'}
            , {field: 'pic', title: '宣传图', width: 100, templet: '#imgTpl', align: 'center'}
            , {field: 'phone', title: '电话', align: 'center'}
            , {field: 'jointime', title: '加入时间', sort: true, width: 170, align: 'center'}
            , {field: 'intro', title: '简介', toolbar: '#table-intro', align: 'center'}
            , {field: 'address', title: '地址', align: 'center'}
            , {field: 'hot', title: '热度', templet: '#hotIcon', minWidth: 80, align: 'center'}
            , {title: '操作', width: 200, align: 'center', fixed: 'right', toolbar: '#table-club-admin'}
        ]]
        , text: '对不起，加载出现异常！'
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
                    layer.confirm('确定删除此管理员？', function (index) {
                        $.ajax({
                            url: ContextPath + '/admin/delete',
                            type: 'get',
                            data: {'id': data.id},//向服务端发送删除的sid
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
                , title: '编辑管理员'
                , content: '../../../views/user/administrators/adminform.html'
                , area: ['500px', '550px']
                , anim: 4//弹出动画
                , maxmin: true//显示最大化最小化按钮
                , shadeClose: true//点击遮罩层关闭模态框
                , shade: 0.5//阴影
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'LAY-user-back-submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);

                    //监听提交
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                        var field = data.field; //获取提交的字段
                        if (field.state == "on") {
                            field.state = 1;
                        } else {
                            field.state = 0;
                        }
                        var url = layui.setter.ContextPath + '/admin/update';
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
                    body.find("input[name='id']").val(data.id);
                    body.find("input[name='name']").val(data.name);
                    body.find("input[name='password']").val(data.password);
                    body.find("input[name='nickname']").val(data.nickname);
                    body.find("input[name='phone']").val(data.phone);
                    body.find("input[name='sex']").val(data.sex);
                    // body.find("input[name='role']").val(data.role);
                    // body.find("input[name='state']").val(data.state);
                    body.find("option[value=" + data.role + "]").prop("selected", true);  //，单选按钮
                    if (data.state == 1) {
                        body.find(".layui-input-inline input[name='state']").prop("checked", "checked");
                    }
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
    exports('club', {})
});