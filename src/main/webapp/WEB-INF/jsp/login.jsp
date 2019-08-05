<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/8/2
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登入 - admin</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${ctx}/static/plugins/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/plugins/layuiadmin/style/login.css" media="all">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/layuiadmin/layui/css/layui.css" media="all"/>
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>约健后台管理系统</h2>
            <p>一个关于健身的App后台管理系统</p>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                       for="LAY-user-login-username"></label>
                <input type="text" name="name" id="LAY-user-login-username" lay-verify="required" placeholder="用户名"
                       class="layui-input" value="leike">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                       for="LAY-user-login-password"></label>
                <input type="password" name="password" id="LAY-user-login-password" lay-verify="required"
                       placeholder="密码" class="layui-input" value="11">
            </div>
            <div class="layui-form-item">
                <div class="layui-card-body layui-row layui-col-space10">
                    <div class="layui-col-md12">
                        <input type="radio" name="role" value="clubAdmin" title="俱乐部管理员">
                        <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i>
                            <div>俱乐部管理员</div>
                        </div>
                        <input type="radio" name="role" value="systemAdmin" title="系统管理员" checked="">
                        <div class="layui-unselect layui-form-radio layui-form-radioed"><i
                                class="layui-anim layui-icon layui-anim-scaleSpring"></i>
                            <div>系统管理员</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item" style="margin-bottom: 20px;">
                <a href="reg.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">注册账号</a>
                <a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
            </div>
        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer">

        <p>© 2019-2020 <a href="http://www.baidu.com/" target="_blank">baidu.com</a></p>
    </div>
</div>

<script src="${ctx}/static/plugins/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${ctx}/static/plugins/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'user'], function () {
        var $ = layui.$,
            setter = layui.setter,
            admin = layui.admin,
            form = layui.form,
            router = layui.router(),
            search = router.search;

        form.render();

        //提交
        form.on('submit(LAY-user-login-submit)', function (obj) {
            console.log(obj.field);

            var url = "${ctx}/admin/login";
            //请求登入接口
            admin.req({
                url: url//实际使用请改成服务端真实接口
                , data: obj.field
                , done: function (res) {

                    // //请求成功后，写入 access_token
                    // layui.data(setter.tableName, {
                    //     key: setter.request.tokenName,
                    //     value: res.data.access_token
                    // });
                    console.log(res);
                    // 登入成功的提示与跳转
                    layer.msg('登入成功', {
                        offset: '15px',
                        icon: 1,
                        time: 1000
                    }, function () {
                        // location.href = '/'; //后台主页
                        window.location.href="${ctx}/";
                    });
                }
            });

        });


        //欢迎
        layer.msg('欢迎管理员登录', {
            offset: '15px',
            icon: 6
        });

    });
</script>
</body>
</html>

