<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="footer-bg" style="background-image:url(<%=request.getContextPath()%>${backgroundImage})">
    <div class="layout" id="footer">
        <div class="copyright">
            &copy;2021 - future By ZhangJin
        </div>
        <div class="framework-info">
            <span>争渡，争渡，惊起一滩鸥鹭</span>
        </div>
        <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=2021007981">渝ICP备2021007981号</a>
    </div>
</footer>

<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
<script>
    L2Dwidget.init({
        "model": {
            jsonPath: "https://unpkg.com/live2d-widget-model-koharu@1.0.5/assets/koharu.model.json",
            "scale": 1
        },
        "display": {
            "position": "right", //看板娘的表现位置
            "width": 140,  //小萝莉的宽度
            "height": 260, //小萝莉的高度
            "hOffset": 0,//小萝莉的X偏移量
            "vOffset": -10//小萝莉的Y偏移量
        },
        "mobile": {
            "show": true,
            "scale": 0.5
        },
        "react": {
            "opacityDefault": 0.7,//小萝莉的透明度
            "opacityOnHover": 0.2
        }
    });
</script>   <!--看板娘-->

<i class="fa fa-arrow-up" id="go-up" aria-hidden="true"></i>
<section class="rightside" id="rightside">
    <i class="fa fa-moon nightshift_pc kk" id="nightshift_pc"></i>
    <div class="progress_show">
        <span class="progress-num">0</span>
    </div>
</section>

<div class="search-dialog" id="local-search">
    <div class="search-dialog__title" id="local-search-title">
        本地搜索
    </div>
    <div id="local-input-panel">
        <div id="local-search-input">
            <div class="local-search-box">
                <input class="local-search-box--input" placeholder="搜索文章" onkeyup="searchWord(this)">
            </div>
        </div>
    </div>
    <hr>
    <div id="local-search-results">
        <div id="local-hits">
            <div class="search-result-list">
                <div id="display">
                    <!-- 			显示查询的结果 -->
                </div>
            </div>
        </div>
    </div>
    <span class="search-close-button">
               <i class="fa fa-times">
               </i>
          </span>
</div>
<div class="search-mask"></div>

<script src="<%=request.getContextPath()%>/static/js/anime.min.js"></script>
<script src="<%=request.getContextPath()%>/static/jquery/jquery.js"></script>
<script src="<%=request.getContextPath()%>/static/js/jquery.fancybox.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/velocity.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/velocity.ui.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/utils.js"></script>
<script src="<%=request.getContextPath()%>/static/js/fancybox.js"></script>
<script src="<%=request.getContextPath()%>/static/js/sidebar.js"></script>
<script src="<%=request.getContextPath()%>/static/js/fireworks.js"></script>
<script src="<%=request.getContextPath()%>/static/js/transition.js"></script>
<script src="<%=request.getContextPath()%>/static/js/scroll.js"></script>
<script src="<%=request.getContextPath()%>/static/js/nightshift.js"></script>
<script src="<%=request.getContextPath()%>/static/js/head.js"></script>
<script src="<%=request.getContextPath()%>/static/js/local-search.js"></script>
<script async="" src="<%=request.getContextPath()%>/static/js/busuanzi.pure.mini.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery.flexText.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/layer/layer.js"></script>
<script type="text/javascript">
    function overFn(obj) { //鼠标在上面
        $(obj).css("background", "#F0F8FF");
    }

    function outFn(obj) { //鼠标离开
        $(obj).css("background", "white");
    }

    function clickFn(obj) { //鼠标点击
        $("#display").val($(obj).html());
    }
    //上面的是提示框的css代码，下面的是ajax获取代码
    function searchWord(obj) {
        //1、获得输入框的输入的内容
        var word = $(obj).val();
        //2、根据输入框的内容去数据库中模糊查询---List<Product>
        var content = "";
        $.post(
            "<%=request.getContextPath()%>/search", {
                title: word
            },
            function (result) {

                if (result.data.length > 0) {
                    for (var i = 0; i < result.data.length; i++) {
                        content += '<div class="search-result-lis " onclick=' + clickFn(this) +
                            'onmouseover=' + overFn(this) + ' onmouseout=' + outFn(this) +
                            '><div class="local-search__hit-item"><a href=<%=request.getContextPath()%>/detail/' + result.data[i].id
                                 + ' class="search-result-title">	' + result.data[i].title + '</a></div>';
                    }
                    $("#display").html(content);
                    $("#display").css("display", "block");
                }else {
                    $("#display").css("display", "none");
                }
            },
            "json"
        );
        if (obj.value.length == 0) { //判断输入框是否为空，如果为空则隐藏提示区域
            console.log("111");
            $("#display").css("display", "none");
        }
    }
</script>
