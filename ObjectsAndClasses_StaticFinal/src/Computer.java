public class Computer {
    private final String vendor;
    private final String name;
    private String vendor2;
    private String name2;
    private Processor processor;
    private RAM ram;
    private StorageOfInformation storageOfInformation;
    private Screen screen;
    private Keyboard keyboard;

    private final int weight;


    public Computer(String vendor, String name, Processor processor, RAM ram,
                    StorageOfInformation storageOfInformation, Screen screen, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.vendor2 = vendor;
        this.name2 = name;
        this.processor = processor;
        this.ram = ram;
        this.storageOfInformation = storageOfInformation;
        this.screen = screen;
        this.keyboard = keyboard;
        this.weight = processor.getWeightProcessors() + ram.getWeightRAM()
                + storageOfInformation.getWeightStorage() + screen.getWeightScreen()
                + keyboard.getWeightKeyboard();
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }


    public Computer setVendor(String vendor) {
        vendor2 = vendor;
        System.out.println("\n" + "Производитель компьютера изменён с " + this.vendor + " на " + vendor);
        return new Computer(vendor, name, processor, ram, storageOfInformation, screen, keyboard);
    }

    public Computer setName(String name) {
        name2 = name;
        System.out.println("\n" + "Название компьютера изменено с " + this.name + " на " + name);
        return new Computer(vendor, name, processor, ram, storageOfInformation, screen, keyboard);
    }

    public void setProcessorFrequensy(int frequensy) {
        processor.setFrequensy(frequensy);
    }

    public void setProcessorNumberOfCores(int numberOfCores) {
        processor.setNumberOfCores(numberOfCores);
    }

    public void setProcessorManufacturer(String manufacturer) {
        processor.setManufacturer(manufacturer);
    }

    public void setProcessorWeight(int weight) {
        processor.setWeight(weight);
    }

    public  void setTypeRAM(TypeRAM typeRAM) {
        ram.setTypeRAM(typeRAM);
    }

    public void setMemoryCapacity(MemoryCapacityRAM memoryCapacity) {
        ram.setMemoryCapacity(memoryCapacity);
    }

    public void setWeightRAM(int weightRAM) {
        ram.setWeightRAM(weightRAM);
    }

    public void setTypeStorage(TypeStorageOfInformation typeStorage) {
        storageOfInformation.setTypeStorage(typeStorage);
    }

    public void setMemoryStorage(int memoryStorage) {
        storageOfInformation.setMemoryStorage(memoryStorage);
    }

    public void setWeightStorage(int weightStorage) {
        storageOfInformation.setWeightStorage(weightStorage);
    }

    public void setDiagonal(int diagonal) {
        screen.setDiagonal(diagonal);
    }

    public void setTypeScreen(TypeScreen typeScreen) {
        screen.setTypeScreen(typeScreen);
    }

    public void setWeightScreen(int weightScreen) {
        screen.setWeightScreen(weightScreen);
    }

    public void setKeyboardType(TypeKeyboard keyboardType) {
        keyboard.setKeyboardType(keyboardType);
    }

    public void setIllumination(IlluminationKeyboard illumination) {
        keyboard.setIllumination(illumination);
    }

    public void setWeightKeyboard(int weightKeyboard) {
        keyboard.setWeightKeyboard(weightKeyboard);
    }

    public String toString() {
        return "\n" + "Компьютер: " + "\n" +
                "Производитель: " + vendor2 + "\n" +
                "Название: " + name2 + "\n" +
                processor.toString() + "\n" +
                ram.toString() + "\n" +
                storageOfInformation.toString() + "\n" +
                screen.toString() + "\n" +
                keyboard.toString() + "\n" +
                "\n" + "Вес компьютера: " + weight + "гр";

    }
}
