package arrays;

public class Scoreboard {
    private int numbEntries = 0;  // numb of actual entries
    private GameEntry[] board;  // array of game entries (names & score)

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }


    // Attempt to add a new score to the collection (if it is high enough)
    public void add(GameEntry e) {
        int newScore = e.getScore();

        // is the new entry really a high score
        if (numbEntries < board.length || newScore > board[numbEntries - 1].getScore()) {
            if (numbEntries < board.length)
                numbEntries++;    // increase

            int j = numbEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;

            }
            board[j] = e;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= numbEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + i);

        GameEntry temp = board[i];
        for(int j = i; j < numbEntries - 1; j++)
            board[j] = board[j + 1];
        board[numbEntries - 1] = null;
        numbEntries--;
        return temp;
    }
}
