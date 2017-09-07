//public class A1 {
//    public static void main (String[]args)  {
//        char Character = 'x';
//        int[] GridArray = new int[20];
//        System.out.print(GridArray[0]);
//    }
//}

public class A1 {

    public static void main(String[] args) {
        char Ccharacter = 'x';
        printGrid();
        Initialise();


    }

    public static void printGrid() {
        String[][] GridArray = new String [15][15];
        for (int x = 0; x<GridArray.length;x++){
            for (int y = 0; y <GridArray.length;y++){
                GridArray[x][y] = " ";  // Initialize the cell
                System.out.print("[" +GridArray[x][y] + "]"); // Display the content of cell board
            }
            System.out.println();  // go to next line

        }
    }

    public static void Initialise() {

    }
}