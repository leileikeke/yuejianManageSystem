<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/29
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body>
<div style="padding-top: 30px">
    <form class="layui-form layui-form-pane" style="width:80%;margin: 0 auto ">
        <div class="layui-row layui-col-xs12">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <!-- 使用隐藏域用于保存编辑项的ID值，便于提交修改 -->
                <input type="hidden" id="sid" name="sid">
                <input type="text" class="layui-input" id="name" name="name" lay-verify="required" placeholder="请输入名称">
            </div>
        </div>

        <div class="layui-row">
            <div class="magb15 layui-col-md4 layui-col-xs12">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block" id="sex">
                    <input type="radio" name="sex" value="男" title="男" checked>
                    <input type="radio" name="sex" value="女" title="女">
                </div>
            </div>
        </div>
        <div class="layui-row layui-col-xs12">
            <label class="layui-form-label">身份证</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" id="tid" name="tid" lay-verify="identity" placeholder="请输入身份证">
            </div>
        </div>
        <div class="layui-row layui-col-xs12">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input type="tel" id="tel" name="tel" lay-verify="required|phone" autocomplete="off"
                       class="layui-input" placeholder="请输入手机号">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-xs12">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-m" id="edit" lay-submit lay-filter="editStu">修改</button>
                <button type="button" class="layui-btn layui-btn-m" id="cancel" lay-submit lay-filter="cancel">取消
                </button>
            </div>
        </div>

    </form>
</div>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'form', 'layer'], function () {
        var element = layui.element
            , form = layui.form
            , layer = layui.layer
            , $ = layui.$;
        //注意：parent 是 JS 自带的全局对象，可用于操作父页面
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        //监听提交
        form.on('submit(editStu)', function (data) {
            console.log(data.field);
            var stu = data.field;
            $.ajax({
                type: "POST",
                url: '${ctx}/stu/update',
                data: JSON.stringify(stu),
                contentType: "application/json",
                success: function (data) {
                    if (data.code == 200) {
                        // parent.layui.msg("修改成功", {icon: 6});
                        //给父容器初始化'弹出层'的数据  以供局部刷新
                        parent.setData(stu);
                        parent.layer.close(index);
                    } else {
                        layer.msg("修改失败", {icon: 5});
                    }
                }
            });

        });
        form.on('submit(cancel)', function () {
            parent.layer.close(index)
        })
    });
</script>
</body>
</html>
