public class StorageOfInformation {

    private final TypeStorageOfInformation typeStorage;
    private final int memoryStorage;
    private final int weightStorage;

    private TypeStorageOfInformation typeStorage2;
    private int memoryStorage2;
    private int weightStorage2;

    public StorageOfInformation(TypeStorageOfInformation typeStorage, int memoryStorage, int weightStorage) {
        this.typeStorage = typeStorage;
        this.memoryStorage = memoryStorage;
        this.weightStorage = weightStorage;
        this.typeStorage2 = typeStorage;
        this.memoryStorage2 = memoryStorage;
        this.weightStorage2 = weightStorage;
    }

    public TypeStorageOfInformation getTypeStorage() {
        return typeStorage;
    }

    public int getMemoryStorage() {
        return memoryStorage;
    }

    public int getWeightStorage() {
        return weightStorage;
    }

    public StorageOfInformation setTypeStorage(TypeStorageOfInformation typeStorage) {
        typeStorage2 = typeStorage;
        System.out.println("\n" + "Тип накопителя памяти изменён с " + this.typeStorage + " на " + typeStorage);
        return new StorageOfInformation(typeStorage, memoryStorage, weightStorage);
    }

    public StorageOfInformation setMemoryStorage(int memoryStorage) {
        memoryStorage2 = memoryStorage;
        System.out.println("\n" + "Объём накопителя памяти изменён с " + this.memoryStorage + " на " + memoryStorage);
        return new StorageOfInformation(typeStorage, memoryStorage, weightStorage);
    }

    public StorageOfInformation setWeightStorage(int weightStorage) {
        weightStorage2 = weightStorage;
        System.out.println("\n" + "Вес накопителя памяти изменён с " + this.weightStorage + " на " + weightStorage);
        return new StorageOfInformation(typeStorage, memoryStorage, weightStorage);
    }

    public String toString() {
        return "\n" + "Накопитель памяти: " + "\n" +
                "Тип: " + typeStorage2 + "\n" +
                "Объём: " + memoryStorage2 + "\n" +
                "Вес: " + weightStorage2 + "гр";

    }
}
