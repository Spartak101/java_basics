public class Keyboard {

    private final TypeKeyboard keyboardType;
    private final IlluminationKeyboard illumination;
    private final int weightKeyboard;
    private TypeKeyboard keyboardType2;
    private IlluminationKeyboard illumination2;
    private int weightKeyboard2;

    public Keyboard(TypeKeyboard keyboardType, IlluminationKeyboard illumination, int weightKeyboard) {
        this.keyboardType = keyboardType;
        this.illumination = illumination;
        this.weightKeyboard = weightKeyboard;
        this.keyboardType2 = keyboardType;
        this.illumination2 = illumination;
        this.weightKeyboard2 = weightKeyboard;
    }

    public TypeKeyboard getKeyboardType() {
        return keyboardType;
    }

    public IlluminationKeyboard isIllumination() {
        return illumination;
    }

    public int getWeightKeyboard() {
        return weightKeyboard;
    }

    public Keyboard setKeyboardType(TypeKeyboard keyboardType) {
        keyboardType2 = keyboardType;
        System.out.println("\n" + "Тип клавиатуры изменён с " + this.keyboardType + " на " + keyboardType);
        return new Keyboard(keyboardType, illumination, weightKeyboard);
    }

    public Keyboard setIllumination(IlluminationKeyboard illumination) {
        illumination2 = illumination;
        System.out.println("\n" + "Подсветка клавиатуры изменена с " + this.illumination + " на " + illumination);
        return new Keyboard(keyboardType, illumination, weightKeyboard);
    }

    public Keyboard setWeightKeyboard(int weightKeyboard) {
        weightKeyboard2 = weightKeyboard;
        System.out.println("\n" + "Вес клавиатуры изменён с " + this.weightKeyboard + " на " + weightKeyboard);
        return new Keyboard(keyboardType, illumination, weightKeyboard);
    }

    public String toString() {
        return "\n" + "Клавиатура: " + "\n" +
                "Тип: " + keyboardType2 + "\n" +
                "Подсветка: " + illumination2 + "\n" +
                "Вес: " + weightKeyboard2 + "гр";

    }
}
