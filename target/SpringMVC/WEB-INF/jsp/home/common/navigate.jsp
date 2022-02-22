<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="nav" style="background-image:url(<%=request.getContextPath()%>${backgroundImage})">
    <div id="page-header">
        <span class="pull-left"><strong></h2><a href="#">UESTC_SPACE</a></strong></span>
        <i class="fa fa-bars toggle-menu pull-right" aria-hidden="true"></i>
        <span class="pull-right menus">
                    <a class="site-page social-icon search"><i class="fa fa-search"></i><span> 搜索</span></a>
                    <a class="site-page" href="<%=request.getContextPath()%>/"><i class="menu-item-icon fa fa-fw fa-home"></i>首页</a>
                    <a class="site-page" href="<%=request.getContextPath()%>/archives"><i class="menu-item-icon fa fa-fw fa-archive"></i>归档</a>
                    <a class="site-page" href="<%=request.getContextPath()%>/tags"><i class="menu-item-icon fa fa-fw fa-tags"></i>标签</a>
                    <a class="site-page" href="<%=request.getContextPath()%>/categories"><i class="menu-item-icon fa fa-fw fa-th"></i>分类</a>
                    <a class="site-page" href="<%=request.getContextPath()%>/about"> <i
                            class="menu-item-icon fa fa-fw fa-user fa-fw"></i>关于</a></span>
    </div>

    <div id="site-info">
        <div id="site-title">
            Study And Life
        </div>
        <div id="site-sub-title">
            ${slogan}
        </div>
    </div>
</nav>
