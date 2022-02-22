<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1" />
<meta name="keywords" content="" />
<meta name="copyright" content="Molunerfinn" />
<title>张金!白驹过隙</title>
<!-- <link rel="shortcut icon" href="/favicon.ico" /> -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/index.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/font-awesome/css/font-awesome.css">
<script type="text/javascript">
var OriginTitle = document.title;
var titleTime;
document.addEventListener('visibilitychange', function () {
if (document.hidden) {
$('[rel="icon"]').attr('href', "/img/trhx2.png");
document.title = '不要走嘛！QAQ';
clearTimeout(titleTime);
}
else {
$('[rel="icon"]').attr('href', "/img/trhx2.png");
document.title = '你回来辣qvq！' + OriginTitle;
titleTime = setTimeout(function () {
document.title = OriginTitle;
}, 2000);
}
});
</script>