package dijkstras_interpreter;

public class App {
    public static void main(String[] args) {
        DijkstraAlg alg = new DijkstraAlg();

        alg.interpreterExpression("( ( 1 + 2 ) * 3 )");
        alg.result();
    }
}
