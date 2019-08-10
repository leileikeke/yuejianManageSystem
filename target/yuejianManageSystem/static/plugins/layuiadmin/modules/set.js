/**

 @Name：layuiAdmin（iframe版） 设置
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License: LPPL

 */

layui.define(['form', 'upload'], function (exports) {
    var $ = layui.$
        , layer = layui.layer
        , laytpl = layui.laytpl
        , setter = layui.setter
        , view = layui.view
        , admin = layui.admin
        , form = layui.form
        , upload = layui.upload
        , ContextPath = layui.setter.ContextPath;

    var $body = $('body');

    //自定义验证
    form.verify({
        nickname: function (value, item) { //value：表单的值、item：表单的DOM对象
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '用户名不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '用户名首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '用户名不能全为数字';
            }
        }

        //我们既支持上述函数式的方式，也支持下述数组的形式
        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
        , pass: [
            /^[\S]{6,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]

        //确认密码
        , repass: function (value) {
            if (value !== $('#LAY_password').val()) {
                return '两次密码输入不一致';
            }
        }
    });

    //设置我的资料
    form.on('submit(setmyinfo)', function (obj) {
        layer.msg(JSON.stringify(obj.field));
        //提交修改
        admin.req({
            type: 'post'
            , url: ContextPath + "/admin/set"
            , contentType: "application/json;charset=utf-8"
            , data: JSON.stringify(obj.field)
            , done: function (res) {
                layer.msg("更新成功", {icon: 6});
            }
        });

        return false;
    });

    //设置密码
    form.on('submit(setmypass)', function (obj) {
        // layer.msg(JSON.stringify(obj.field));
        var url = ContextPath + "admin/setpass";
        //提交修改
        admin.req({
            url: url
            , data: obj.field
            , done: function (data) {
                console.log(data);
                if (data.code == 200) {
                    // 登入成功的提示与跳转
                    layer.msg('修改成功', {
                        offset: '15px',
                        icon: 1,
                        time: 1000
                    });
                }
            }
        });
        return false;
    });

    //对外暴露的接口
    exports('set', {});
});