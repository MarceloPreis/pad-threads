package at6;

public class SearchThread extends Thread {
    private SearchArray searchArray;
    private int start;
    private int end;

    public SearchThread(SearchArray arraySearch, int start, int end) {
        this.searchArray = arraySearch;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int result = searchArray.search(start, end);
        if (result != -1) {
            System.out.println("Thread encontrou o número " + searchArray.getTarget() + " no índice " + result);
        }
    }
}
