public class RAM {

    private final TypeRAM typeRAM;
    private final MemoryCapacityRAM memoryCapacity;
    private final int capacity;
    private int capacity2;
    private final int weightRAM;

    private TypeRAM typeRAM2;
    private MemoryCapacityRAM memoryCapacity2;
    private int weightRAM2;

    public RAM(TypeRAM typeRAM, MemoryCapacityRAM memoryCapacity, int weightRAM) {
        this.typeRAM = typeRAM;
        this.memoryCapacity = memoryCapacity;
        this.weightRAM = weightRAM;
        if (memoryCapacity == MemoryCapacityRAM.GB_1) {
            this.capacity = 1;
        } else if (memoryCapacity == MemoryCapacityRAM.GB_2) {
            this.capacity = 2;
        } else if (memoryCapacity == MemoryCapacityRAM.GB_4) {
            this.capacity = 4;
        } else if (memoryCapacity == MemoryCapacityRAM.GB_8) {
            this.capacity = 8;
        } else if (memoryCapacity == MemoryCapacityRAM.GB_16) {
            this.capacity = 16;
        } else if (memoryCapacity == MemoryCapacityRAM.GB_32) {
            this.capacity = 32;
        } else if (memoryCapacity == MemoryCapacityRAM.GB_64) {
            this.capacity = 64;
        } else this.capacity = 128;
        this.typeRAM2 = typeRAM;
        this.memoryCapacity2 = memoryCapacity;
        this.weightRAM2 = weightRAM;
        this.capacity2 = capacity;
    }

    public TypeRAM getTypeRAM() {
        return typeRAM;
    }

    public MemoryCapacityRAM getMemoryCapacity() {
        return memoryCapacity;
    }

    public int getWeightRAM() {
        return weightRAM;
    }

    public RAM setTypeRAM(TypeRAM typeRAM) {
        typeRAM2 = typeRAM;
        System.out.println("\n" + "Тип оперативной памяти изменён с " + this.typeRAM + " на " + typeRAM);
        return new RAM(typeRAM, memoryCapacity, weightRAM);
    }

    public RAM setMemoryCapacity(MemoryCapacityRAM memoryCapacity) {
        memoryCapacity2 = memoryCapacity;
        if (memoryCapacity2 == MemoryCapacityRAM.GB_1) {
            this.capacity2 = 1;
        } else if (memoryCapacity2 == MemoryCapacityRAM.GB_2) {
            this.capacity2 = 2;
        } else if (memoryCapacity2 == MemoryCapacityRAM.GB_4) {
            this.capacity2 = 4;
        } else if (memoryCapacity2 == MemoryCapacityRAM.GB_8) {
            this.capacity2 = 8;
        } else if (memoryCapacity2 == MemoryCapacityRAM.GB_16) {
            this.capacity2 = 16;
        } else if (memoryCapacity2 == MemoryCapacityRAM.GB_32) {
            this.capacity2 = 32;
        } else if (memoryCapacity2 == MemoryCapacityRAM.GB_64) {
            this.capacity2 = 64;
        } else this.capacity2 = 128;
        System.out.println("\n" + "Объём оперативной памяти изменён с " + this.memoryCapacity + " на " + memoryCapacity);
        return new RAM(typeRAM, memoryCapacity, weightRAM);
    }

    public RAM setWeightRAM(int weightRAM) {
        weightRAM2 = weightRAM;
        System.out.println("\n" + "Вес оперативной памяти изменён с " + this.weightRAM + " на " + weightRAM);
        return new RAM(typeRAM, memoryCapacity, weightRAM);
    }

    public String toString() {
        return "\n" + "Оперативная память: " + "\n" +
                "Тип: " + typeRAM2 + "\n" +
                "Объём: " + capacity2 + " Гб" + "\n" +
                "Вес: " + weightRAM2 + " гр";

    }
}
