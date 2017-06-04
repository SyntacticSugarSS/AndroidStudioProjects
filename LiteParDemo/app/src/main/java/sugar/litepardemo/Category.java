package sugar.litepardemo;

/**
 * Created by admin on 2017/6/4.
 */

public class Category {
    private int id;
    private String categoryName;
    private int categoryCode;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
