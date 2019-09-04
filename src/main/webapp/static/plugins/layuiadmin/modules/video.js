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

    var forminit = function () {
        admin.req({
            type: 'get'
            , url: layui.setter.ContextPath + "/video/query"
            , data: null
            , done: function (res) {
                var vId = res.data.vId;
                var name = res.data.name;
                var video = res.data.video;
                var cId = res.data.cId;
                $("#videoInfo").prop("src", layui.setter.ContextPath+video);
                console.log(res)
                form.val("videofilter", {
                    "cId": cId
                    , "name": name
                    , "video": video
                    , "vId": vId
                });
            }
        });
    };
    forminit();

    //重置
    form.on('submit(reset)', function (obj) {
        //加载层-默认风格
        layer.load();
        //此处演示关闭
        setTimeout(function () {
            forminit();//初始化
            layer.closeAll('loading');
        }, 300);
        return null;
    });

    // //设置我的俱乐部视频
    form.on('submit(setVideoInfo)', function (obj) {
        //提交修改
        admin.req({
            type: 'post'
            , url: ContextPath + "/video/update"
            , contentType: "application/json;charset=utf-8"
            , data: JSON.stringify(obj.field)
            , done: function (res) {
                layer.msg("更新成功", {icon: 6});
            }
        });

        return false;
    });

    //对外暴露的接口
    exports('video', {});
});