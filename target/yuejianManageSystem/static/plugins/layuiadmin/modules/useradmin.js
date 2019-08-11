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

    //用户管理
    table.render({
        elem: '#LAY-user-manage'
        , url: ContextPath + '/user/userList' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'center'}
            , {field: 'uId', width: 60, title: 'ID', sort: true, align: 'center'}
            , {field: 'name', title: '用户名', minWidth: 120, align: 'center'}
            , {field: 'password', title: '密码', width: 120, align: 'center'}
            , {field: 'pic', title: '头像', width: 100, templet: '#imgTpl', align: 'center'}
            , {field: 'phone', title: '手机', width: 180, align: 'center'}
            , {field: 'email', title: '邮箱', align: 'center'}
            , {field: 'sex', width: 120, title: '性别', sort: true, align: 'center'}
            , {field: 'jointime', title: '加入时间', sort: true, align: 'center'}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
        ]]
        , page: true
        , limit: 13
        , height: 'full-220'
        , text: {none: '一条数据也没有^_^'}
    });

    //监听工具条
    table.on('tool(LAY-user-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.prompt({
                formType: 1
                , title: '敏感操作，请验证口令'
            }, function (value, index) {
                if (value == layui.setter.Command) {
                    layer.confirm('真的删除行么', function (index) {
                        $.ajax({
                            url: ContextPath + '/user/delete',
                            type: 'get',
                            data: {'uId': data.uId,pic:data.pic},//向服务端发送删除的sid
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
                layer.close(index);


            });
        } else if (obj.event === 'edit') {
            var tr = $(obj.tr);

            layer.open({
                type: 2
                , title: '编辑用户'
                , content: 'userform.html'
                , area: ['455px', '500px']
                , anim: 4//弹出动画
                , maxmin: true//显示最大化最小化按钮
                , shadeClose: true//点击遮罩层关闭模态框
                , shade: 0.5//阴影
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'LAY-user-front-submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);

                    //监听提交
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                        var field = data.field; //获取提交的字段

                        var url = layui.setter.ContextPath + '/user/update';
                        admin.req({
                            type: 'post'
                            , url: url
                            , contentType: "application/json;charset=utf-8"
                            , data: JSON.stringify(field)
                            , done: function (res) {
                                layer.msg("更新成功", {icon: 6});
                                //提交 Ajax 成功后，静态更新表格中的数据
                                table.reload('LAY-user-manage'); //数据刷新
                                layer.close(index); //关闭弹层
                            }
                        });

                    });

                    submit.trigger('click');
                }
                , success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    body.find("input[name='uId']").val(data.uId);
                    body.find("input[name='name']").val(data.name);
                    body.find("input[name='password']").val(data.password);
                    body.find("input[name='phone']").val(data.phone);
                    body.find("input[name='email']").val(data.email);
                    body.find("input[name='pic']").val(data.pic);
                    body.find('#demo1').attr('src', ContextPath+data.pic);
                    body.find("input[value=" + data.sex + "]").prop("checked", "checked");  //，单选按钮
                    setTimeout(function () {
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-close1', {
                            tips: 1
                        });
                    }, 300)
                }
            });
        }
    });

    //管理员管理
    table.render({
        elem: '#LAY-user-back-manage'
        , url: ContextPath + '/admin/adminList' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', width: 80, title: 'ID', sort: true, align: 'center'}
            , {field: 'name', title: '登录名', align: 'center'}
            , {field: 'password', title: '密码', align: 'center'}
            , {field: 'nickname', title: '昵称', align: 'center'}
            , {field: 'phone', title: '手机', align: 'center'}
            , {field: 'sex', title: '年龄', align: 'center'}
            , {field: 'role', title: '角色', toolbar: '#table-role', align: 'center'}
            , {field: 'jointime', title: '加入时间', sort: true, width: 170, align: 'center'}
            , {field: 'state', title: '审核状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
            , {title: '操作', width: 200, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
        ]]
        , text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-back-manage)', function (obj) {
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
                , content: 'adminform.html'
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
                                table.reload('LAY-user-back-manage'); //数据刷新
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
    exports('useradmin', {})
});