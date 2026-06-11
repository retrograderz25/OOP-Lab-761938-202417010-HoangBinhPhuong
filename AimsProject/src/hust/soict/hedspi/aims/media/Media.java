package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private static int nbMedia = 0;
    private String title;
    private String category;
    private float cost;

    public Media() {
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        this.id = nbMedia;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        // Kiểm tra trỏ cùng một vùng nhớ
        if (this == obj) {
            return true;
        }
        // Xử lý NullPointerException và ClassCastException bằng toán tử instanceof
        if (obj == null || !(obj instanceof Media)) {
            return false;
        }

        // Ép kiểu an toàn (vì đã qua kiểm tra instanceof)
        Media other = (Media) obj;

        // So sánh Tiêu đề (xử lý an toàn trường hợp title bị null) và Giá tiền
        boolean isTitleEqual = (this.title != null && this.title.equals(other.getTitle()))
                || (this.title == null && other.getTitle() == null);

        return isTitleEqual && (this.cost == other.getCost());
    }

    @Override
    public int compareTo(Media other) {
        // Bắt lỗi NullPointerException
        if (other == null) {
            throw new NullPointerException("Không thể so sánh với một đối tượng null!");
        }

        // 1. So sánh theo tiêu đề (Title) trước (Alphabetical order)
        int titleComparison = 0;
        if (this.title != null && other.getTitle() != null) {
            titleComparison = this.title.compareToIgnoreCase(other.getTitle());
        } else if (this.title == null && other.getTitle() != null) {
            return -1; // null đứng trước
        } else if (this.title != null && other.getTitle() == null) {
            return 1;
        }

        // 2. Nếu tiêu đề giống nhau, tiếp tục so sánh theo giá tiền (Cost)
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            // Sử dụng Float.compare để so sánh giá
            return Float.compare(this.cost, other.getCost());
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Title: " + title + " - Category: " + category + " - Cost: " + cost + " $";
    }
}