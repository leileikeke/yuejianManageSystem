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

    //俱乐部员工
    table.render({
        elem: '#LAY-clubcoach-manage'
        , url: ContextPath + '/clubemp/getList' //模拟接口
        , cols: [[
            {type: 'checkbox', fixed: 'center'}
            , {field: 'jId', width: 60, title: 'ID', sort: true, align: 'center'}
            , {field: 'name', title: '用户名', minWidth: 120, align: 'center'}
            , {field: 'pic', width: 120, title: '头像', width: 100, templet: '#imgTpl', align: 'center'}
            , {field: 'sex', width: 120, title: '性别', sort: true, align: 'center'}
            , {field: 'phone', title: '手机', width: 180, align: 'center'}
            , {field: 'email', title: '邮箱', align: 'center'}
            , {field: 'intro', title: '简介', align: 'center'}
            , {field: 'cName', title: '所属俱乐部', sort: true, align: 'center'}
            , {field: 'state', title: '职称', sort: true, templet: '#buttonTpl', width: 100, align: 'center'}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-clubcoach-webuser'}
        ]]
        , page: true
        , limit: 10
        , height: 'full-220'
        , text: {none: '一条数据也没有^_^'}
    });

    //监听工具条
    table.on('tool(LAY-clubcoach-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.prompt({
                formType: 1
                , title: '敏感操作，请验证口令'
            }, function (value, index) {
                if (value == layui.setter.Command) {
                    layer.confirm('真的删除行么', function (index) {
                        $.ajax({
                            url: ContextPath + '/clubemp/delete',
                            type: 'get',
                            data: {'jId': data.jId, pic: data.pic},//向服务端发送删除的sid
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
                , title: '编辑俱乐部教练'
                , content: 'clubcoachform.html'
                , area: ['455px', '550px']
                , anim: 4//弹出动画
                , maxmin: true//显示最大化最小化按钮
                , shadeClose: true//点击遮罩层关闭模态框
                , shade: 0.5//阴影
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index]
                        , submitID = 'LAY-clubemp-front-submit'
                        , submit = layero.find('iframe').contents().find('#' + submitID);

                    //监听提交
                    iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                        var field = data.field; //获取提交的字段

                        var url = layui.setter.ContextPath + '/clubemp/update';
                        admin.req({
                            type: 'post'
                            , url: url
                            , contentType: "application/json;charset=utf-8"
                            , data: JSON.stringify(field)
                            , done: function (res) {
                                layer.msg("更新成功", {icon: 6});
                                //提交 Ajax 成功后，静态更新表格中的数据
                                table.reload('LAY-clubcoach-manage'); //数据刷新
                                layer.close(index); //关闭弹层
                            }
                        });

                    });

                    submit.trigger('click');
                }
                , success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    body.find("input[name='jId']").val(data.jId);
                    body.find("input[name='name']").val(data.name);
                    body.find("input[name='phone']").val(data.phone);
                    body.find("input[name='email']").val(data.email);
                    body.find("input[name='pic']").val(data.pic);
                    body.find('#demo1').attr('src', ContextPath + data.pic);
                    body.find("input[value=" + data.sex + "]").prop("checked", "checked");  //，单选按钮
                    body.find("textarea[name='intro']").val(data.intro);
                    setTimeout(function () {
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-close1', {
                            tips: 1
                        });
                    }, 300)
                }
            });
        } else if (obj.event === 'addCourse') {

        }
    });


    exports('clubemp', {})
});