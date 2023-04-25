package gardenspeedrun;

public class Main {
    public static void main(String[] args) {
        Garden g = new Garden();

        g.addPlant(new Flower("ruzova"));
        g.addPlant(new Flower("bezova"));

        g.addPlant(new Tree("hnedy"));
        g.addPlant(new Tree("zeleny"));

        System.out.println(g);

        g.water(40);
        g.water(70);
    }
}
