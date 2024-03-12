package at6;

import java.util.concurrent.atomic.AtomicBoolean;

public class SearchArray {
    private int[] array;
    private int target;
    private AtomicBoolean stopSearch = new AtomicBoolean(false);

    public SearchArray(int[] array, int target) {
        this.array = array;
        this.target = target;
    }

    public int search(int start, int end) {
        for (int i = start; i < end && !stopSearch.get(); i++) {
            if (array[i] == target) {
                stopSearch.set(true);
                return i;
            }
        }
        return -1;
    }

    public boolean isStopSearch() {
        return stopSearch.get();
    }
    
    public int getTarget() {
        return target;
    }
}
