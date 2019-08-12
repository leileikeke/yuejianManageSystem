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
    <title>yuejie 后台管理(club)</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${ctx}/static/plugins/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/plugins/layuiadmin/style/admin.css" media="all">

    <script>
        /^http(s*):\/\//.test(location.href) || alert('请先部署到 localhost 下再访问');
    </script>
</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="http://www.layui.com/admin/" target="_blank" title="前台">
                        <i class="layui-icon layui-icon-website"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="views/template/search.html?keywords=">
                </li>
            </ul>




            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
                <li class="layui-nav-item" lay-unselect>
                    <a lay-href="views/app/message/index.html" layadmin-event="message" lay-text="消息中心">
                        <i class="layui-icon layui-icon-notice"></i>
                        <!-- 如果有新消息，则显示小圆点 -->
                        <span class="layui-badge-dot"></span>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>



                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="note">
                        <i class="layui-icon layui-icon-note"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>${clubAdmin.nickname}</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="info">基本资料</a></dd>
                        <dd><a lay-href="views/set/user/password.html">修改密码</a></dd>
                        <hr>
                        <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="views/home/console.html">
                    <span>layuiAdmin</span>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" lay-tips="主页" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>主页</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="console" class="layui-this">
                                <a lay-href="views/home/console.html">控制台</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="views/home/homepage1.html">主页一</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="views/home/homepage2.html">主页二</a>
                            </dd>
                        </dl>
                    </li>





                    <li data-name="user" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="俱乐部" lay-direction="2">
                            <i class="layui-icon layui-icon-user"></i>
                            <cite>俱乐部</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a lay-href="views/club/clubinfo.html?id=${clubAdmin.id}">俱乐部</a>
                            </dd>
                            <dd>
                                <a lay-href="views/club/admin/list.html?id=${clubAdmin.id}">俱乐部活动</a>
                            </dd>
                        </dl>
                    </li>







                    <li data-name="user" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="用户" lay-direction="2">
                            <i class="layui-icon layui-icon-user"></i>
                            <cite>用户</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a lay-href="views/user/user/list.html">网站用户</a>
                            </dd>
                            <dd>
                                <a lay-href="views/user/administrators/list.html">后台管理员</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="set" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="设置" lay-direction="2">
                            <i class="layui-icon layui-icon-set"></i>
                            <cite>设置</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd class="layui-nav-itemed">
                                <a href="javascript:;">我的设置</a>
                                <dl class="layui-nav-child">
                                    <dd><a lay-href="views/set/user/info.html?id=${clubAdmin.id}">基本资料</a></dd>
                                    <dd><a lay-href="views/set/user/password.html">修改密码</a></dd>
                                </dl>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="views/home/console.html" lay-attr="views/home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="views/home/console.html" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>

<script src="${ctx}/static/plugins/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${ctx}/static/plugins/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index',function () {
        var $ = layui.$;
        //事件
        var active = {
            batchdel: function () {
                var checkStatus = table.checkStatus('LAY-club-back-manage')
                    , checkData = checkStatus.data; //得到选中的数据

                if (checkData.length === 0) {
                    return layer.msg('请选择数据');
                }

                layer.prompt({
                    formType: 1
                    , title: '敏感操作，请验证口令'
                }, function (value, index) {
                    layer.close(index);
                    if (value == layui.setter.Command) {
                        layer.confirm('确定删除吗？', function (index) {
                            var url = layui.setter.ContextPath + "/club/deleteAll";
                            admin.req({
                                type: 'post'
                                , url: url
                                , contentType: "application/json;charset=utf-8"
                                , data: JSON.stringify(checkData)
                                , done: function (res) {
                                    // 删除成功提示
                                    layer.msg('成功删除: ' + res.count + ' 条', {
                                        offset: '15px',
                                        icon: 1,
                                        time: 1000
                                    });
                                    //执行 Ajax 后重载
                                    table.reload('LAY-club-back-manage');
                                }
                            });
                        });
                    } else {
                        layer.msg("验证口令错误,操作失败");
                    }

                });
            }
            , add: function () {
                layer.open({
                    type: 2
                    , title: '添加俱乐部'
                    , content: 'clubform.html'
                    , area: ['455px', '500px']
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
                            console.log(field);
                            var url = layui.setter.ContextPath + '/club/add';
                            admin.req({
                                type: 'post'
                                , url: url
                                , contentType: "application/json;charset=utf-8"
                                , data: JSON.stringify(field)
                                , done: function (res) {
                                    layer.msg("添加成功", {icon: 6});
                                    //提交 Ajax 成功后，静态更新表格中的数据
                                    table.reload('LAY-club-back-manage'); //数据刷新
                                    layer.close(index); //关闭弹层
                                }
                            });
                        });

                        submit.trigger('click');
                    }
                });
            }
        }

        $('.layui-btn.layuiadmin-btn-club').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    // <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i
    // class="layui-icon layui-icon-edit"></i>编辑</a>

    });
</script>
</body>
</html>