public class Scene {
    private int score;
    private String fn;

    public Scene(String filename) {
        score = 0;
        fn = filename;
    }

    public String getFileName(){return "images/" + fn;}
}
