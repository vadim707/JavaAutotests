package API;

public class ColorsData {
    private Integer id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;

    public ColorsData() {}

    public ColorsData(Integer id, String name, Integer year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
