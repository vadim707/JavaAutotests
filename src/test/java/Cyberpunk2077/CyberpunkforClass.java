package Cyberpunk2077;

public class CyberpunkforClass {
    private String word;
    private int year;
    private boolean future;

    public CyberpunkforClass(String word, int year, boolean future) {
        this.word = word;
        this.year = year;
        this.future = future;
    }

    public String getWord() {
        return word;
    }

    public int getYear() {
        return year;
    }

    public boolean isFuture() {
        return future;
    }
}
