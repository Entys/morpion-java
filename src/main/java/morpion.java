import java.util.Scanner;

public class morpion {

    public static void main(String[] args) {
        char[] grid =
                {
                        '1', '2', '3',
                        '4', '5', '6',
                        '7', '8', '9'
                };
        char p1 = 'O';
        char p2 = 'X';
        char currentPlayer = p1;

        Scanner scan = new Scanner(System.in);
        String input;
        boolean win = false;

        while (true) {

            System.out.println("[" + grid[0] + '|' + grid[1] + '|' + grid[2] + ']');
            System.out.println("[" + grid[3] + '|' + grid[4] + '|' + grid[5] + ']');
            System.out.println("[" + grid[6] + '|' + grid[7] + '|' + grid[8] + ']');

            int c;
            while (true) {
                System.out.print("Player '" + currentPlayer + "' type the grid case number : ");
                input = scan.nextLine();
                try {
                    c = Integer.parseInt(input);
                    if (1 <= c && c <= 9 && grid[c - 1] != p1 && grid[c - 1] != p2) {
                        break;
                    }
                } catch (Exception e) {
                }
            }
            grid[c - 1] = currentPlayer;

            for (int i = 0; i < 3; ++i) {
                if (grid[i * 3] == currentPlayer && grid[i * 3 + 1] == currentPlayer && grid[i * 3 + 2] == currentPlayer)
                    win = true;
            }
            if (win) {
                System.out.println("Congratulation ! player '" + currentPlayer + "' won the game !");
                break;
            }

            for (int i = 0; i < 3; ++i) {
                if (grid[i] == currentPlayer && grid[i + 3] == currentPlayer && grid[i + 6] == currentPlayer)
                    win = true;
            }

            if (win) {
                System.out.println("Congratulation ! player '" + currentPlayer + "' won the game !");
                break;
            }

            if (grid[0] == currentPlayer && grid[4] == currentPlayer && grid[8] == currentPlayer) {
                System.out.println("Congratulation ! player '" + currentPlayer + "' won the game !");
                break;
            }

            if (grid[2] == currentPlayer && grid[4] == currentPlayer && grid[6] == currentPlayer) {
                System.out.println("Congratulation ! player '" + currentPlayer + "' won the game !");
                break;
            }

            if (currentPlayer == p1)
                currentPlayer = p2;
            else
                currentPlayer = p1;
        }
    }
}
