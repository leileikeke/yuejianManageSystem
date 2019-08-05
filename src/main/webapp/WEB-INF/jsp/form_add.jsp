<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/27
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>约建App后台管理系统</title>
    <%--引入css,否则没样式--%>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="jsp/common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;position: relative;width: 1100px;margin:0 auto;margin-top: 10px;">
            <fieldset class="layui-elem-field" style="padding : 15px;margin-top: 40px;border: 5px solid #009688;">
                <legend class="layui-bg-green">添加student数据</legend>

                <form class="layui-form layui-form-pane" action="${ctx}/stu/add">
                    <div class="layui-form-item">
                        <label class="layui-form-label">名称</label>
                        <div class="layui-input-block">
                            <input type="text" name="name" autocomplete="off" placeholder="请输入名称" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item" pane="">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="sex" value="男" title="男" checked="">
                            <input type="radio" name="sex" value="女" title="女">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">验证身份证</label>
                        <div class="layui-input-block">
                            <input type="text" name="tid" lay-verify="identity" placeholder="请输入身份证" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-inline">
                                <input type="tel" name="tel" lay-verify="required|phone" autocomplete="off"
                                       class="layui-input" placeholder="请输入手机号">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit="" lay-filter="demo2">提交</button>
                    </div>
                </form>
            </fieldset>
        </div>
    </div>

    <jsp:include page="jsp/common/tail.jsp"/>
</div>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'form'], function () {
        var element = layui.element
            , layer = layui.layer;

    });
</script>
</body>
</html>

