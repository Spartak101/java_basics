public class Screen {

    private final int diagonal;
    private final TypeScreen typeScreen;
    private final int weightScreen;
    private int diagonal2;
    private TypeScreen typeScreen2;
    private int weightScreen2;

    public Screen(int diagonal, TypeScreen typeScreen, int weightScreen) {
        this.diagonal = diagonal;
        this.typeScreen = typeScreen;
        this.weightScreen = weightScreen;
        this.diagonal2 = diagonal;
        this.typeScreen2 = typeScreen;
        this.weightScreen2 = weightScreen;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public TypeScreen getTypeScreen() {
        return typeScreen;
    }

    public int getWeightScreen() {
        return weightScreen;
    }

    public Screen setDiagonal(int diagonal) {
        diagonal2 =diagonal;
        System.out.println("\n" + "Диагональ экрана изменена с " + this.diagonal + " на " + diagonal);
        return new Screen(diagonal, typeScreen, weightScreen);
    }

    public Screen setTypeScreen(TypeScreen typeScreen) {
        typeScreen2 = typeScreen;
        System.out.println("\n" + "Тип экрана изменён с " + this.typeScreen+ " на " + typeScreen);
        return new Screen(diagonal, typeScreen, weightScreen);
    }

    public Screen setWeightScreen(int weightScreen) {
        weightScreen2 = weightScreen;
        System.out.println("\n" + "Вес экрана изменён с " + this.weightScreen + " на " + weightScreen);
        return new Screen(diagonal, typeScreen, weightScreen);
    }

    public String toString() {
        return "\n" + "Монитор: " + "\n" +
                "Диагональ: " + diagonal2 + "\n" +
                "Тип: " + typeScreen2 + "\n" +
                "Вес: " + weightScreen2 + "гр";

    }
}
