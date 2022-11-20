public class Processor {

    private final int frequensy;
    private final int numberOfCores;
    private final String manufacturer;
    private final int weightProcessors;

    private int frequensy2;
    private int numberOfCores2;
    private String manufacturer2;
    private int weightProcessors2;


    public Processor(int frequensy, int numberOfCores, String manufacturer, int weightProcessors) {
        this.frequensy = frequensy;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weightProcessors = weightProcessors;
        this.frequensy2 = frequensy;
        this.numberOfCores2 = numberOfCores;
        this.manufacturer2 = manufacturer;
        this.weightProcessors2 = weightProcessors;
    }

    public int getFrequensy() {
        return frequensy;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getWeightProcessors() {
        return weightProcessors;
    }

    public Processor setFrequensy(int frequensy) {
        frequensy2 = frequensy;
        System.out.println("\n" + "Частота процессора изменена с " + this.frequensy + " на " + frequensy + "ГГц");
        return new Processor(frequensy, numberOfCores, manufacturer, weightProcessors);
    }

    public Processor setNumberOfCores(int numberOfCores) {
        numberOfCores2 = numberOfCores;
        System.out.println("\n" + "Количество ядер процессора изменено с " + this.numberOfCores + " на " + numberOfCores);
        return new Processor(frequensy, numberOfCores, manufacturer, weightProcessors);
    }

    public Processor setManufacturer(String manufacturer) {
        manufacturer2 = manufacturer;
        System.out.println("\n" + "Производитель процессора изменён с " + this.manufacturer + " на " + manufacturer);
        return new Processor(frequensy, numberOfCores, manufacturer, weightProcessors);
    }

    public Processor setWeight(int weightProcessors) {
        weightProcessors2 = weightProcessors;
        System.out.println("\n" + "Вес процессора изменён с " + this.weightProcessors + " на " + weightProcessors);
        return new Processor(frequensy, numberOfCores, manufacturer, weightProcessors);
    }


    public String toString() {
        return "\n" + "Процессор: " + "\n" +
                "Частота: " + frequensy2 + "ГГц" + "\n" +
                "Количество ядер: " + numberOfCores2 + "\n" +
                "Производитель: " + manufacturer2 + "\n" +
                "Вес: " + weightProcessors2 + "гр";

    }
}
