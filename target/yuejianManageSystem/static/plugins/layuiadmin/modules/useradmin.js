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
            {type: 'checkbox', fixed: 'left'}
            , {field: 'uId', width: 100, title: 'ID', sort: true}
            , {field: 'name', title: '用户名', minWidth: 100}
            , {field: 'pic', title: '头像', width: 100, templet: '#imgTpl'}
            , {field: 'phone', title: '手机'}
            , {field: 'email', title: '邮箱'}
            , {field: 'sex', width: 80, title: '性别'}
            , {field: 'jointime', title: '加入时间', sort: true}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
        ]]
        , page: true
        , limit: 30
        , height: 'full-220'
        , text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.prompt({
                formType: 1
                , title: '敏感操作，请验证口令'
            }, function (value, index) {
                layer.close(index);

                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            });
        } else if (obj.event === 'edit') {
            var tr = $(obj.tr);

            layer.open({
                type: 2
                , title: '编辑用户'
                , content: '../../../views/user/user/userform.html'
                , maxmin: true
                , area: ['500px', '450px']
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'LAY-user-front-submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);

                    //监听提交
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                        var field = data.field; //获取提交的字段

                        //提交 Ajax 成功后，静态更新表格中的数据
                        //$.ajax({});
                        table.reload('LAY-user-front-submit'); //数据刷新
                        layer.close(index); //关闭弹层
                    });

                    submit.trigger('click');
                }
                , success: function (layero, index) {

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
            , {field: 'id', width: 80, title: 'ID', sort: true}
            , {field: 'name', title: '登录名'}
            , {field: 'password', title: '密码'}
            , {field: 'nickname', title: '昵称'}
            , {field: 'phone', title: '手机'}
            , {field: 'sex', title: '年龄'}
            , {field: 'role', title: '角色', toolbar: '#table-role'}
            , {field: 'jointime', title: '加入时间', sort: true, width: 170}
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
                , content: '../../../views/user/administrators/adminform.html'
                , area: ['420px', '500px']
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
                        console.log(field);
                        if (field.state == "on"){
                            field.state = 1;
                        } else {
                            field.state = 0;
                        }
                        var url = layui.setter.ContextPath + '/admin/updateAdmin';
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
                    //表单初始赋值
                    // body.form.val('layuiadmin-form-admin', {
                    //     "name": "贤心" // "name": "value"
                    //     ,"password": "123456"
                    //     // ,"interest": 1
                    //     // ,"like[write]": true //复选框选中状态
                    //     // ,"close": true //开关状态
                    //     // ,"sex": "女"
                    //     // ,"desc": "我爱 layui"
                    // })
                    body.find("input[name='id']").val(data.id);
                    body.find("input[name='name']").val(data.name);
                    body.find("input[name='password']").val(data.password);
                    body.find("input[name='nickname']").val(data.nickname);
                    body.find("input[name='phone']").val(data.phone);
                    body.find("input[name='sex']").val(data.sex);
                    body.find("input[name='role']").val(data.role);
                    // body.find("input[name='state']").val(data.state);
                    body.find("option[value=" + data.role + "]").prop("selected", true);  //，单选按钮
                    setTimeout(function () {
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-close1', {
                            tips: 1
                        });
                    }, 300)
                }
            })
        }
    });

    //角色管理
    table.render({
        elem: '#LAY-user-back-role'
        , url: layui.setter.base + 'json/useradmin/role.js' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', width: 80, title: 'ID', sort: true}
            , {field: 'rolename', title: '角色名'}
            , {field: 'limits', title: '拥有权限'}
            , {field: 'descr', title: '具体描述'}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
        ]]
        , text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-back-role)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定删除此角色？', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            var tr = $(obj.tr);

            layer.open({
                type: 2
                , title: '编辑角色'
                , content: '../../../views/user/administrators/roleform.html'
                , area: ['500px', '480px']
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submit = layero.find('iframe').contents().find("#LAY-user-role-submit");

                    //监听提交
                    iframeWindow.layui.form.on('submit(LAY-user-role-submit)', function (data) {
                        var field = data.field; //获取提交的字段

                        //提交 Ajax 成功后，静态更新表格中的数据
                        //$.ajax({});
                        table.reload('LAY-user-back-role'); //数据刷新
                        layer.close(index); //关闭弹层
                    });

                    submit.trigger('click');
                }
                , success: function (layero, index) {

                }
            })
        }
    });

    exports('useradmin', {})
});