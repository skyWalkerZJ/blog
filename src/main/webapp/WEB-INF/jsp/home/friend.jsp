
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <jsp:include page="common/head.jsp"></jsp:include>
</head>
<title> New Document </title>
<style>
    .inputText4 {
        font-family:Arial,Helvetica,sans-serif;
        background:none repeat scroll 0 0 #F5F7FD;
        border:1px solid #B8BFE9;
        padding:5px 7px;
        width:180px;
        vertical-align:middle;
        height:30px;
        font-size:12px;
        margin:0;
        list-style:none outside none;
    }
</style>
<body>

<canvas class="fireworks"></canvas>
<i class="fa fa-arrow-right" id="toggle-sidebar" aria-hidden="true"></i>

<jsp:include page="common/navigate.jsp"></jsp:include>

<div id="content-outer">

    <div class="page-friends page-common">

    <div class="link-title wow rollIn animated"
         style="visibility: visible; animation-name: rollIn;">订阅博主</div>
    <ul class="readers-list clearfix">

        <li class="wow slideInUp animated" style="visibility: visible;
         animation-name: slideInUp;">
            <a rel="colleague" title="在右侧留下您的邮箱即可一键订阅哦"
               id="subbtn" href="javascript:myadd();"><div><font
                    color="#1e90ff">一键订阅</font></div>
                <div>博客的更新将会第一时间通知您哦</div></a></li>
            <form id="myForm" method="post" enctype="multipart/form-data">
                <li> <font color="#5f9ea0" size="5px">name: </font> <input type="text" maxlength="27" class="inputText4" size="100" id="name" value="" name="name" placeholder="请留下您的芳名"></li>
                <li> <font color="#5f9ea0" size="5px">email: </font><input type="email" maxlength="27" class="inputText4" size="100" id="email" value="" name="email" placeholder="请留下您的邮箱"></li>
            </form>
    </ul>

<%--    <div class="link-title wow rollIn animated"
         style="visibility: visible; animation-name: rollIn;">博客友链</div>
    <ul class="readers-list clearfix">

        <li class="wow slideInUp animated" style="visibility: visible; animation-name: slideInUp;"><a rel="colleague" title="创造狮，一个创意工作者的导航" target="_blank" href="https://ziyuanbox.xyz/"><div><font color="#1e90ff">ZZY的百宝箱</font></div><div>优质资源 一站收录</div></a></li>

    </ul>

    <div class="link-title wow rollIn animated" style="visibility: visible;
        animation-name: rollIn;">Viking2021年招新</div>
    <ul class="readers-list clearfix">

        <li class="wow slideInUp animated"
            style="visibility: visible; animation-name: slideInUp;">
            <a rel="" title="学的不仅是技术，更是梦想" target="_blank" href="http://139.196.79.159:8000/">
                <div>Viking2021年招新</div><div>We Are Waiting for You!</div></a></li>
    </ul>
</div>--%>

</div>

<jsp:include page="common/foot.jsp"></jsp:include>

</body>

</html>
<style>
    .clearfix {zoom:1;}
    .clearfix:after {content:'.';display:block;visibility:hidden;height:0;clear:both;}
    .readers-list {list-style:none;}
    .readers-list *{margin:0;padding:0;}
    .readers-list li{position:relative;float:left;margin-top:20px!important;padding:0 10px;}
    .readers-list li a{display:block;border:1px solid #eee;border-left: 3px solid #FF002B;border-radius:7px;padding-left:15px;transition:all .3s;color: white;}
    .readers-list li:nth-of-type(6n+1) a{border-left-color:#FF002B;}
    .readers-list li:nth-of-type(6n+2) a{border-left-color:#FFA900;}
    .readers-list li:nth-of-type(6n+3) a{border-left-color:#00CC00;}
    .readers-list li:nth-of-type(6n+4) a{border-left-color:#00CCFF;}
    .readers-list li:nth-of-type(6n+5) a{border-left-color:#0089FA;}
    .readers-list li:nth-of-type(6n+6) a{border-left-color:#404040;}
    .readers-list li a div{padding:12px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;color:#999;}
    .readers-list li a div:first-child{border-bottom:1px dashed #eee;font-size:1.3em;color:#666;}
    .readers-list li a:hover {
        -webkit-transform: translateY(-6px);
        transform: translateY(-6px);
        box-shadow: 0 26px 40px -24px rgba(0,0,0,0.3);
    }
    .link-title {
        position: relative;
        left: -19px;
        display: inline-block;
        margin: 20px 0;
        font-size: 15px;
        padding: 0 30px 0 25px;
        height: 45px;
        line-height: 45px;
        border-radius: 0 35px 35px 0;
        background: #404040;
        color: #fff;
    }
    @media(min-width:768px){
        .readers-list li{width:50%;}
    }
    @media(max-width:767px){
        .readers-list li{width:100%;}
    }

    .page-common ul li, .page-common ol li {
        margin-bottom: 12px;
    }
    .page-friends ul {
        padding: 0;
        margin: 0;
    }
</style>

<script>
    function myadd() {
        var content = $("#name").val();
        var name = $("#email").val();
        var temp = $("#no_comment").val();
        if (content && name) {
            $.ajax({
                type: "POST",
                url: '<%=request.getContextPath()%>/customer/addCustomer',
                data: new FormData($("#myForm")[0]),
                cache: false,
                async: false,
                processData: false,
                contentType: false,
                dataType: "json",
                success: function (data) {
                    if (data.state == 1) {
                        layer.alert("订阅成功", {icon: 1},function () {
                            location.reload();
                        });

                    } else
                        layer.alert("订阅失败", {icon: 5});
                }
            });
        } else {
            layer.msg("姓名和邮箱均不能为空");
        }

    }
</script>