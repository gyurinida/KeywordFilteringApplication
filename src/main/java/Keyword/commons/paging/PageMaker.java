package Keyword.commons.paging;

public class PageMaker {
    private int totalCount; // 전체 항목 갯수
    private int startPage;  // 페이징 목록 시작 페이지 번호
    private int endPage;    // 페이징 목록 끝 페이지 번호
    private boolean prev;   // 이전 링크
    private boolean next;   // 다음 링크
    private int displayPageNum = 10;    // 페이징 목록의 페이지 번호 갯수
    private Criteria criteria;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData(){
        endPage = (int)(Math.ceil(criteria.getPage()/(double)displayPageNum)*displayPageNum);
        startPage = (endPage - displayPageNum) + 1;

        int tmpEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
        if(endPage>tmpEndPage)
            endPage = tmpEndPage;

        prev = startPage==1?false:true;
        next = endPage*criteria.getPerPageNum()>=totalCount?false:true;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }

    public Criteria getCriteria(){
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "PageMaker{" +
                "totalCount=" + totalCount +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", displayPageNum=" + displayPageNum +
                ", criteria=" + criteria +
                '}';
    }
}
