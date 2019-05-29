package org.teleinformatyka.model;

public class RecipeTagsPage {

 private RecipeTags recipeTags;
 private String url;
 private String pageLinkTags;


    public String getPageLinkTags() {
        return pageLinkTags;
    }

    public void setPageLinkTags(String pageLinkTags) {
        this.pageLinkTags = pageLinkTags;
    }

    public RecipeTags getRecipeTags() {
        return recipeTags;
    }

    public void setRecipeTags(RecipeTags recipeTags) {
        this.recipeTags = recipeTags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
