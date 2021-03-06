package org.focusns.service.blog;

import java.util.Date;

import org.focusns.model.blog.BlogCategory;
import org.focusns.model.blog.BlogPost;
import org.focusns.model.common.Page;
import org.focusns.model.core.Project;
import org.focusns.model.core.ProjectUser;
import org.focusns.service.AbstractServiceTest;
import org.focusns.service.core.ProjectService;
import org.focusns.service.core.ProjectUserService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Ignore
public class BlogPostServiceTest extends AbstractServiceTest {

    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private BlogCategoryService tagService;
    @Autowired
    private BlogPostService postService;
    
    @Test
    public void testCreateBlogPost() {
        Project project = projectService.getProject("focusns");
        Assert.assertNotNull(project);
        //
        BlogCategory blogTag = new BlogCategory();
        blogTag.setLabel("未分类");
        blogTag.setProjectId(project.getId());
        //
        tagService.createBlogCategory(blogTag);
        //
        ProjectUser user = projectUserService.getUser("admin");
        Assert.assertNotNull(user);
        //
        Date now = new Date();
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("Blog Title");
        blogPost.setContent("Blog Content");
        blogPost.setCreateAt(now);
        blogPost.setModifyAt(now);
        blogPost.setCategoryId(blogTag.getId());
        blogPost.setCreateById(user.getId());
        //
        postService.createBlogPost(blogPost);
    }
    
    @Test
    public void testRemoveBlogPost() {
        Project project = projectService.getProject("focusns");
        Assert.assertNotNull(project);
        //
        Page<BlogPost> page = new Page<BlogPost>(10);
        page = postService.fetchPageByProjectId(page, project.getId());
        for(BlogPost post : page.getResults()) {
            postService.removeBlogPost(post);
        }
    }
    
}
