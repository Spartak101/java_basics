public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("Тула электрик", "Могучий калькулятор",
                new Processor(3, 4, "AMD", 100),
                new RAM(TypeRAM.DDR3, MemoryCapacityRAM.GB_2, 120),
                new StorageOfInformation(TypeStorageOfInformation.SSD, 500, 650),
                new Screen(22, TypeScreen.TN, 4000),
                new Keyboard(TypeKeyboard.MECHANICAL, IlluminationKeyboard.ARGB, 1200));
        computer.setName("Ого арифмометр");
        computer.setProcessorFrequensy(5);
        computer.setProcessorManufacturer("HUAWEI");
        computer.setIllumination(IlluminationKeyboard.RGB);
        computer.setMemoryCapacity(MemoryCapacityRAM.GB_16);
        computer.setTypeScreen(TypeScreen.IPS);
        System.out.println(computer);
    }
}