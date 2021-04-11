package Keyword.commons.paging;

public class SearchCriteria extends Criteria{
    // 페이징(Criteria) + 검색
    private String searchType;      // 검색 조건
    private String searchKeyword;         // 검색 키워드

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "searchType='" + searchType + '\'' +
                ", searchKeyword='" + searchKeyword + '\'' +
                '}';
    }
}
