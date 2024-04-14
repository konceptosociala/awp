package org.verstiukhnutov.awp.msg;

public class SearchMsg extends AwpMsg {
    private final String searchPrompt;

    public String getPrompt() {
        return searchPrompt;
    }

    public SearchMsg(String searchPrompt) {
        this.searchPrompt = searchPrompt;
    }
}
