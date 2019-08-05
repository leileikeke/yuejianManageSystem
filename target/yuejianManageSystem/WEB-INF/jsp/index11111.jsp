<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/19
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>第二周第三周作业</title>
    <%--引入css,否则没样式--%>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;position: relative;width: 796px;margin:0 auto;">
            <div style="margin-bottom: 5px;">

                <!-- 示例-970 -->
                <ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px"
                     data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>

            </div>

            <div class="layui-btn-group demoTable">
                <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
                <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
                <button class="layui-btn" data-type="isAll">验证是否全选</button>
                <button class="layui-btn layui-btn-danger" data-type="addDate">添加数据</button>
            </div>

            <table class="layui-table"
                   lay-data="{width: 856, height:500, url:'${ctx}/stu/select', page:true, id:'idTest'}"
                   lay-filter="demo">
                <thead>
                <tr>
                    <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
                    <th lay-data="{field:'sid', width:80, sort: true, fixed: true}">SID</th>
                    <th lay-data="{field:'name', width:100}">用户名</th>
                    <th lay-data="{field:'sex', width:80, sort: true}">性别</th>
                    <th lay-data="{field:'tid', width:200}">身份证</th>
                    <th lay-data="{field:'tel', width:160}">电话</th>
                    <th lay-data="{fixed: 'right', width:180, align:'center', toolbar: '#barDemo'}"></th>
                </tr>
                </thead>
            </table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>

    <jsp:include page="/WEB-INF/jsp/common/tail.jsp"/>
</div>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'table', 'layer'], function () {
        var element = layui.element,
            table = layui.table,
            layer = layui.layer;
        var chileData;//弹出层返回数据
        //监听表格复选框选择
        table.on('checkbox(demo)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('SID：' + data.sid + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                        url: '${ctx}/stu/delete',
                        type: 'get',
                        data: {'sid': data.sid},//向服务端发送删除的sid
                        success: function (suc) {
                            console.log("suc", suc);
                            console.log("index", index);
                            if (suc.code == 200) {
                                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                layer.msg("删除成功", {icon: 1});
                            } else {
                                layer.msg("删除失败", {icon: 5});
                            }
                        }
                    });
                });
            } else if (obj.event === 'edit') {
                // layer.alert('编辑行：<br>'+data.tid)
                // var data = obj.data;
                var body = layer.getChildFrame('body', index);
                var index = layer.open({
                    title: "编辑学生",
                    type: 2,//0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）；
                    anim: 4,//弹出动画
                    maxmin: true,//显示最大化最小化按钮
                    content: "${ctx}/edit.jsp",//弹出层页面
                    shadeClose: true,//点击遮罩层关闭模态框
                    shade: 0.5,//阴影
                    area: ['500px', '350px'],
                    success: function (layero, index) {
                        var body = layer.getChildFrame('body', index);
                        body.find("#sid").val(data.sid);
                        body.find("#name").val(data.name);  //名称
                        body.find("#sex input[value=" + data.sex + "]").prop("checked", true);  //性别，单选按钮

                        body.find("#tid").val(data.tid);
                        body.find("#tel").val(data.tel);
                        // form.render();//刷新页面
                        setTimeout(function () {
                            layui.layer.tips('点击此处返回用户列表', '.layui-layer-close1', {
                                tips: 1
                            });
                        }, 300)
                    },
                    end: function () {
                        console.log(chileData);
                        if (chileData.sid == obj.data.sid) {
                            obj.update({
                                name: chileData.name,
                                sex: chileData.sex,
                                tid: chileData.tid,
                                tel: chileData.tel
                            });
                            layer.msg("更新成功", {icon: 6})
                            chileData = null;
                        }
                    }
                });
                //layui.layer.full(index);//设置弹出层布满窗口
                //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
                $(window).on("resize", function () {
                    layui.layer.full(window.sessionStorage.getItem("index"));
                })
            }
        });

        var $ = layui.$, active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            , getCheckLength: function () { //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
            }
            , isAll: function () { //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            }
            , addDate: function () { //添加数据
                location.href = "form_add.jsp";
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        //接受弹出层的表单数据  --  用于更新表单数据
        window.setData = function (data1) {
            // chileData = $.parseJSON(data1);
            chileData = data1;
        }
    });

</script>
</body>
</html>