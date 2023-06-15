                                                                                                                    
//                                                                                                         .--,-``-.     
//   .--.--.                                                            ,----,     ,----..        ,----,  /   /     '.   
//  /  /    '. ,-.----.             ,--,                              .'   .' \   /   /   \     .'   .' \/ ../        ;  
// |  :  /`. / \    /  \   __  ,-.,--.'|         ,---,              ,----,'    | /   .     :  ,----,'    \ ``\  .`-    ' 
// ;  |  |--`  |   :    |,' ,'/ /||  |,      ,-+-. /  |  ,----._,.  |    :  .  ;.   /   ;.  \ |    :  .  ;\___\/   \   : 
// |  :  ;_    |   | .\ :'  | |' |`--'_     ,--.'|'   | /   /  ' /  ;    |.'  /.   ;   /  ` ; ;    |.'  /      \   :   | 
//  \  \    `. .   : |: ||  |   ,',' ,'|   |   |  ,"' ||   :     |  `----'/  ; ;   |  ; \ ; | `----'/  ;       /  /   /  
//   `----.   \|   |  \ :'  :  /  '  | |   |   | /  | ||   | .\  .    /  ;  /  |   :  | ; | '   /  ;  /        \  \   \  
//   __ \  \  ||   : .  ||  | '   |  | :   |   | |  | |.   ; ';  |   ;  /  /-, .   |  ' ' ' :  ;  /  /-,   ___ /   :   | 
//  /  /`--'  /:     |`-';  : |   '  : |__ |   | |  |/ '   .   . |  /  /  /.`| '   ;  \; /  | /  /  /.`|  /   /\   /   : 
// '--'.     / :   : :   |  , ;   |  | '.'||   | |--'   `---`-'| |./__;      :  \   \  ',  /./__;      : / ,,/  ',-    . 
//   `--'---'  |   | :    ---'    ;  :    ;|   |/       .'__/\_: ||   :    .'    ;   :    / |   :    .'  \ ''\        ;  
//             `---'.|            |  ,   / '---'        |   :    :;   | .'        \   \ .'  ;   | .'      \   \     .'   
//               `---`             ---`-'                \   \  / `---'            `---`    `---'          `--`-,,-'     
//                                                        `--`-'                                                         

/* Christina Torres
* Spring 2023
* CMSC 451 Project 1
*/
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.io.*;


public class Program2 {

    Program2() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Talk to me :)");

        // only accept certain files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        // grab user selection
        int userSelection = fileChooser.showOpenDialog(null);
        // get the file
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                // Read the selected file
                readTextFile(selectedFile);
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            System.out.println("File selection canceled.");
        }
    }

    private static void readTextFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;


        /// gui
        // new window
        JFrame frame = new JFrame("Magic Results");
        ImageIcon image = new ImageIcon("unicorn.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // NUMBER OF ROWS AND COLUMNS
        DefaultTableModel tableModel = new DefaultTableModel(12, 5);
        // new table
        JTable table = new JTable(tableModel);
        JTableHeader headers =table.getTableHeader();
        String[] headText = new String[]{"size", "time", "%/avg", "count", "/%avg"};
        for (int i=0; i < headText.length; i++) headers.getColumnModel().getColumn(i).setHeaderValue(headText[i]);

        /// write to file
        int col=0;
        int row=0;
        while ((line = bufferedReader.readLine()) != null) {
            // Split the line into an array of elements based on spaces
            String[] elements = line.split(",");
            // Process the array elements as needed
            for (String element : elements) {
                System.out.print(element + " ");
                // populate data
                // table.setValueAt(element, row, coly);
                table.setValueAt(element, row, col);
                col++;
            }
            col=0;
            row++;
            System.out.println("next while");
        }
        bufferedReader.close();

        // make the tbale as small as it can be
        // while still keeping everything in there
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        // SCROLLING
        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        // Add the scroll pane to a panel
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        panel.setBackground(Color.PINK);

        // Add the panel to the frame
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Program2();
    }
}
