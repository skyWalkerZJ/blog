package com.quilt.controller.home;

import com.quilt.dto.ArticleWithBLOBsDto;
import com.quilt.dto.Chapter;
import com.quilt.dto.Result;
import com.quilt.entity.*;
import com.quilt.exception.enums.QuiltEnums;
import com.quilt.service.*;
import com.quilt.utils.ChapterUtil;
import com.quilt.utils.PagedResult;
import com.quilt.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TagService tagService;

    @Autowired
    CommentService commentService;

    @Autowired
    VisitorService visitorService;

    ResourceBundle resourceBundle=ResourceBundle.getBundle("sentence");
    @RequestMapping(value = "/{pageNo}")
    public String getArticlePage(Model model,
                                 @PathVariable("pageNo")Integer pageNo ){

        List<ArticleWithBLOBsDto> articleWithBLOBsDtoList = new ArrayList<ArticleWithBLOBsDto>();
        PagedResult<ArticleWithBLOBs> pagedResult = articleService.getArticlePage(pageNo,2);


        for (ArticleWithBLOBs articleWithBLOBs : pagedResult.getDataList()){

            List<Category> categoryList = categoryService.getCategoryListByArticleId(articleWithBLOBs.getId());
            List<Tag> tagList = tagService.getTagListByArticleId(articleWithBLOBs.getId());

            ArticleWithBLOBsDto articleWithBLOBsDto = new ArticleWithBLOBsDto(articleWithBLOBs,tagList,categoryList);
            articleWithBLOBsDtoList.add(articleWithBLOBsDto);

        }
        model.addAttribute("pagedResult",pagedResult);
        model.addAttribute("articleWithBLOBsDtoList",articleWithBLOBsDtoList);
        model.addAttribute("backgroundImage","/static/images/index/index.jpg");
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);
        return "home/index";
    }
    /**
     * 前台首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String getIndexPage(HttpServletRequest request, Model model) throws IOException {
        //添加访客记录
        Visitor visitor = new Visitor();
        visitor.setIp(WebUtils.getClientIp(request));
        visitor.setBrower(WebUtils.getBrowserInfo(request));
        visitor.setCreateTime(new Date());
        visitorService.addVisitorRecord(visitor);
        return "redirect:/1";
    }

    /**
     * 文章时间线
     * @param model
     * @return
     */
    @RequestMapping("/archives")
    public String getArchivesPage(Model model){

        List<Article> articleList = articleService.getAllArticle();
        model.addAttribute("articleList",articleList);

        model.addAttribute("backgroundImage","/static/images/index/wood.jpg");
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);

        return  "home/archives";

    }

    /**
     * 前台标签页
     * @param model
     * @return
     */
    @RequestMapping("/tags")
    public String getTagsPage(Model model){

        List<Tag> tagList = tagService.getAllTags();
        model.addAttribute("tagList",tagList);

        model.addAttribute("tagCount",tagList.size());
        model.addAttribute("backgroundImage","/static/images/index/sky.jpg");
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);

        return  "home/tags";

    }

    /**
     * 前台分类页
     * @param model
     * @return
     */
    @RequestMapping("/categories")
    public String getCategoriesPage(Model model){

        //得到所有的父子分类
        List<Category> categoryParentList = categoryService.getAllParentCategory();
        List<Category> categoryChildList = categoryService.getAllChildCategory();

        //构建一个MAP，Key用于存放分类ID，Value用于存放对应的文章数量
        Map<Integer,Integer> categoryIdAndArticleCount = new HashMap<Integer, Integer>();

        for(Category category : categoryParentList){

            categoryIdAndArticleCount.put(category.getId(),categoryService.getArticleCountByCategoryId(category.getId()));
        }

        for (Category category : categoryChildList){

            categoryIdAndArticleCount.put(category.getId(),categoryService.getArticleCountByCategoryId(category.getId()));
        }

        model.addAttribute("categoryCount",categoryParentList.size()+categoryChildList.size());
        model.addAttribute("categoryIdAndArticleCount",categoryIdAndArticleCount);
        model.addAttribute("categoryParentList",categoryParentList);
        model.addAttribute("categoryChildList",categoryChildList);

        model.addAttribute("backgroundImage","/static/images/index/cloud.jpg");
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);
        return  "home/categories";

    }

    /**
     * 个人信息页
     * @param model
     * @return
     */
    @RequestMapping("/friend")
    public String getFriendPage(Model model){

        UserWithBLOBs userWithBLOBs = userService.getUserInfoById(1);

        model.addAttribute("backgroundImage","/static/images/index/friend.jpg");
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);
        model.addAttribute("htmlContent",userWithBLOBs.getHtmlContent());

        return  "home/friend";

    }
    @RequestMapping("/about")
    public String getAboutPage(Model model){

        UserWithBLOBs userWithBLOBs = userService.getUserInfoById(1);

        model.addAttribute("backgroundImage","/static/images/index/me.jpg");
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);
        model.addAttribute("htmlContent",userWithBLOBs.getHtmlContent());

        return  "home/about";

    }

    /**
     * 文章详情页
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String getAboutPage(Model model,
                               @PathVariable("id") Integer id){

        articleService.viewCountPlusOne(id);
        ArticleWithBLOBs articleWithBLOBs = articleService.getArticleById(id);

        List<Category> categoryList = categoryService.getCategoryListByArticleId(id);
        List<Tag> tagList = tagService.getTagListByArticleId(id);
        List<Comment> commentList = commentService.getAllCommentByArticleId(id);

        User user = userService.getUserInfoById(articleWithBLOBs.getUserId());
        String[] userTagList = user.getUserTag().split(" ");

        int articleCount = articleService.getArticleCount();
        int tagCount  = tagService.getTagCount();
        int categoryCount = categoryService.getCategoryCount();

        List<Chapter> chapterList = ChapterUtil.handleChapeter(articleWithBLOBs.getHtmlContent());

        model.addAttribute("articleWithBLOBs",articleWithBLOBs);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("tagList",tagList);
        model.addAttribute("commentList",commentList);
        model.addAttribute("user",user);
        model.addAttribute("userTagList",userTagList);
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("categoryCount",categoryCount);
        model.addAttribute("chapterList",chapterList);
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);
        return  "home/detail";

    }

    /**
     * 标签时间线
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/category/timeline/{id}")
    public String getCategoryTimelinePage(Model model,
                                          @PathVariable("id") Integer id){

        List<Article> articleList = categoryService.getArticleListByCategoryId(id);
        model.addAttribute("articleList",articleList);
        Category category = categoryService.getCategory(id);

        model.addAttribute("category",category);
        model.addAttribute("backgroundImage","/static/images/index/category.jpg");
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);

        return "home/category_timeline";

    }

    @RequestMapping("/tag/timeline/{id}")
    public String getTagTimelinePage(Model model,
                                          @PathVariable("id") Integer id){

        List<Article> articleList = tagService.getArticleListByTagId(id);
        model.addAttribute("articleList",articleList);
        Tag tag = tagService.getTag(id);

        model.addAttribute("tag",tag);
        model.addAttribute("backgroundImage","/static/images/index/tags.jpg");
        int num=(int)(Math.random()*101);
        String sentence = resourceBundle.getString(String.valueOf(num));
        model.addAttribute("slogan",sentence);
        return "home/tag_timeline";

    }

    @RequestMapping("/search")
    @ResponseBody
    public Result getArticleListByTitle(@RequestParam("title") String title){

        List<Article> articleList = articleService.getArticleListByTitle(title);
        Result<List<Article>> result = new Result<List<Article>>(QuiltEnums.SUCCESS,articleList);

        return result;
    }
}
