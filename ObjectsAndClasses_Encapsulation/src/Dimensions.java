public class Dimensions {
    private final double dimensionsHeight;
    private final double dimensionsWidth;
    private final double dimensionsLong;
    private double volume;

    private double dimensionsHeight2;
    private double dimensionsWidth2;
    private double dimensionsLong2;
    private double volume2;

    public Dimensions(double dimensionsHeight, double dimensionsWidth, double dimensionsLong) {
        this.dimensionsHeight = dimensionsHeight;
        this.dimensionsWidth = dimensionsWidth;
        this.dimensionsLong = dimensionsLong;
        this.volume = dimensionsHeight * dimensionsLong * dimensionsWidth;

        this.dimensionsHeight2 = dimensionsHeight;
        this.dimensionsWidth2 = dimensionsWidth;
        this.dimensionsLong2 = dimensionsLong;
        this.volume2 = volume;
    }

    public double getDimensionsHeight() {
        return dimensionsHeight;
    }

    public double getDimensionsWidth() {
        return dimensionsWidth;
    }

    public double getDimensionsLong() {
        return dimensionsLong;
    }

    public double getVolume() {
        return volume;
    }

    public Dimensions setDimensionsHeight(double dimensionsHeight) {
        dimensionsHeight2 = dimensionsHeight;
        this.volume2 = dimensionsHeight2 * dimensionsLong * dimensionsWidth;
        System.out.println("\n" + "Высота груза изменена с " + this.dimensionsHeight + " на " + dimensionsHeight2);
        return new Dimensions(dimensionsHeight2, dimensionsWidth, dimensionsLong);
    }

    public Dimensions setDimensionsWidth(double dimensionsWidth) {
        dimensionsWidth2 = dimensionsWidth;
        this.volume2 = dimensionsHeight * dimensionsLong * dimensionsWidth2;
        System.out.println("\n" + "Ширина груза изменена с " + this.dimensionsWidth + " на " + dimensionsWidth2);
        return new Dimensions(dimensionsHeight, dimensionsWidth2, dimensionsLong);
    }

    public Dimensions setDimensionsLong(double dimensionsLong) {
        dimensionsLong2 = dimensionsLong;
        this.volume2 = dimensionsHeight * dimensionsLong2 * dimensionsWidth;
        System.out.println("\n" + "Длинна груза изменена с " + this.dimensionsLong + " на " + dimensionsLong2);
        return new Dimensions(dimensionsHeight, dimensionsWidth, dimensionsLong2);
    }

    public String toString() {
        return "\n" + "Длинна: " + dimensionsLong + " м" + "\n" +
                "Ширина: " + dimensionsWidth + " м" + "\n" +
                "Высота: " + dimensionsHeight + " м" + "\n" +
                "Объём: " + volume + " м3";
    }
    public void dimensionsPrint() {
        System.out.println("\n" + "Длинна: " + dimensionsLong2 + " м" + "\n" +
                "Ширина: " + dimensionsWidth2 + " м" + "\n" +
                "Высота: " + dimensionsHeight2 + " м" + "\n" +
                "Объём: " + volume2 + " м3");
    }
}

