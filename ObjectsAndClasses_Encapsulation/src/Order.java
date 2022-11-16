public class Order {
    private final int mass;
    private final String deliveryAddress;
    private final boolean flipOver;
    private final String registrationNumber;
    private final boolean fragile;

    private final Dimensions dimensions;
    private double dimensionsHeight;
    private double dimensionsWidth;
    private double dimensionsLong;
    private double volume;

/*    public Order() {
        this.mass = 0;
        this.deliveryAddress = "N/A";
        this.flipOver = true;
        this.registrationNumber = "N/A";
        this.fragile = true;
    }*/

    public Order(Dimensions dimensions, int mass, String deliveryAddress, boolean flipOver, String registrationNumber, boolean fragile) {
        this.dimensions = dimensions;
        dimensionsHeight = dimensions.getDimensionsHeight();
        dimensionsWidth = dimensions.getDimensionsHeight();
        dimensionsLong = dimensions.getDimensionsLong();
        volume = dimensions.getVolume();
        this.mass = mass;
        this.deliveryAddress = deliveryAddress;
        this.flipOver = flipOver;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;

        this.mass2 = mass;
        this.deliveryAddress2 = deliveryAddress;
        this.flipOver2 = flipOver;
        this.registrationNumber2 = registrationNumber;
        this.fragile2 = fragile;
    }


    public int getMass() {
        return mass;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isFlipOver() {
        return flipOver;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return fragile;
    }



    private int mass2;
    private String deliveryAddress2;
    private boolean flipOver2;
    private String registrationNumber2;
    private boolean fragile2;
    public Order setMass(int mass) {
        mass2 = mass;
        System.out.println("\n" + "Масса груза изменена с " + this.mass + " на " + mass2);
        return new Order(dimensions, mass2, deliveryAddress, flipOver, registrationNumber, fragile);
    }

    public Order setDeliveryAddress(String deliveryAddress) {
        deliveryAddress2 = deliveryAddress;
        System.out.println("\n" + "Адрес доставки изменён с " + this.deliveryAddress + " на " + deliveryAddress2);
        return new Order(dimensions, mass, deliveryAddress2, flipOver, registrationNumber, fragile);
    }

    public Order setFlipOver(boolean flipOver) {
        flipOver2 = flipOver;
        if (flipOver != this.flipOver) {
            System.out.println("\n" + "Возможность перевернуть изменена с " + this.flipOver + " на " + flipOver2);
        }
        return new Order(dimensions, mass, deliveryAddress, flipOver2, registrationNumber, fragile);
    }

    public Order setRegistrationNumber(String registrationNumber) {
        registrationNumber2 = registrationNumber;
        System.out.println("\n" + "Номер регистрации изменён с " + this.registrationNumber + " на " + registrationNumber2);
        return new Order(dimensions, mass, deliveryAddress, flipOver, registrationNumber2, fragile);
    }

    public Order setFragile(boolean fragile) {
        fragile2 = fragile;
        if (fragile2 != this.fragile) {
            System.out.println("\n" + "Хрупкость груза изменена с " + this.fragile + " на " + fragile2);
        }
        return new Order(dimensions, mass, deliveryAddress, flipOver, registrationNumber, fragile2);
    }

    public String toString() {
        String fl = "";
        if (flipOver) {
            fl = "Не переворачивать!";
        }
        String fr = "";
        if (fragile) {
            fr = "Хрупкое!";
        }

        return "\n" + "Масса: " + mass + "\n" +
                "Адрес доставки: " + deliveryAddress + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n" +
                fl + "\n" +
                fr + "\n" +
                dimensions;
    }


    public double getDimensionsHeight() {
        return dimensionsHeight = dimensions.getDimensionsHeight();
    }

    public void setDimensionsHeight(double dimensionsHeight) {
        dimensions.setDimensionsHeight(dimensionsHeight);
    }

    public double getDimensionsWidth() {
        return dimensionsWidth = dimensions.getDimensionsWidth();
    }

    public void setDimensionsWidth(double dimensionsWidth) {
        dimensions.setDimensionsWidth(dimensionsWidth);
    }

    public double getDimensionsLong() {
        return dimensionsLong = dimensions.getDimensionsLong();
    }

    public void setDimensionsLong(double dimensionsLong) {
        dimensions.setDimensionsLong(dimensionsLong);
    }

    public double getVolume() {
        return volume = dimensions.getVolume();
    }

    public  void print() {
        String fl = "";
        if (flipOver2) {
            fl = "Не переворачивать!";
        }
        String fr = "";
        if (fragile2) {
            fr = "Хрупкое!";
        }

        System.out.println("\n" + "Масса: " + mass2 + "\n" +
                "Адрес доставки: " + deliveryAddress2 + "\n" +
                "Регистрационный номер: " + registrationNumber2 + "\n" +
                fl + "\n" +
                fr + "\n" +
                "Длинна: " + getDimensionsLong() + " м" + "\n" +
                "Ширина: " + getDimensionsWidth() + " м" + "\n" +
                "Высота: " + getDimensionsHeight() + " м" + "\n" +
                "Объём: " + getVolume() + " м3");
    }
}
