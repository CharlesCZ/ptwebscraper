package org.teleinformatyka.api.model;

import java.util.List;

public class RecipeTagsPage {

    private List<RecipeTags> recipeTags;
    private String url;
    private String pageLinkTags;

    public List<RecipeTags> getRecipeTags() {
        return recipeTags;
    }

    public void setRecipeTags(List<RecipeTags> recipeTags) {
        this.recipeTags = recipeTags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageLinkTags() {
        return pageLinkTags;
    }

    public void setPageLinkTags(String pageLinkTags) {
        this.pageLinkTags = pageLinkTags;
    }

    @Override
    public String toString() {
        return "RecipeTagsPage{" +
                "recipeTags=" + recipeTags +
                ", url='" + url + '\'' +
                ", pageLinkTags='" + pageLinkTags + '\'' +
                '}';
    }
}
